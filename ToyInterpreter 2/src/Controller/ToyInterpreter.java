package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import mobserver.OutBufferObserver;
import mobserver.StackObserver;
import mobserver.VarTableObserver;
import Model.OutBuffer;
import Model.ProgState;
import Model.Expression.ArithExpression;
import Model.Expression.ConstExpression;
import Model.Expression.VarExpression;
import Model.Statement.AssignStatement;
import Model.Statement.CompoundStatement;
import Model.Statement.ForkStatement;
import Model.Statement.IfStatement;
import Model.Statement.LockEnter;
import Model.Statement.LockExit;
import Model.Statement.PrintStatement;
import Model.Statement.Statement;
import Repository.MemRepo;
import Repository.Repo;

public class ToyInterpreter {
	public Repo r;
	
	public void addStatement(Statement s, int idx) {
		r.getPS(idx).es.push(s);
	}
	
	public ToyInterpreter() {
		r = new Repo();
		test();
	}
	public void test() {
		/*r.getPS(0).es.push(
				new CompoundStatement(
					new CompoundStatement(
							new CompoundStatement(new AssignStatement("a",new ArithExpression(new ConstExpression(55),new ConstExpression(2),'*')),
												  new AssignStatement("b",new ArithExpression(new ConstExpression(55),new ConstExpression(2),'/'))
							),
					new PrintStatement(new ArithExpression(new VarExpression("a"),new VarExpression("b"),'/'))),
					new AssignStatement("z",new ArithExpression(new ConstExpression(23),new ConstExpression(1),'+'))
				)
		);*/
		r.getPS(1).es.push(new CompoundStatement(
				new AssignStatement("v",new ConstExpression(10)),new CompoundStatement(
						new PrintStatement(new VarExpression("v")),
						new CompoundStatement(
								new ForkStatement(new CompoundStatement(
										new AssignStatement("v",new ConstExpression(20)),
										new CompoundStatement(
												new LockEnter(new ConstExpression(1)),
												new CompoundStatement(
														new PrintStatement(new VarExpression("v")),
														new LockExit(new ConstExpression(1)))
												)
										)),
								new CompoundStatement(
										new PrintStatement(new ArithExpression(new VarExpression("v"),new ConstExpression(1),'+')),
										new LockExit(new ConstExpression(1))
										)
								)
						)
				));
	}
	
	public ProgState getPs(int idx) {
		return r.getPS(idx);
	}
	
	public void interpretNext() {
		for(int i = 1; i <= r.getNumProg(); ++i) {
			Statement st = r.getPS(i).es.top();
			//System.out.println(i);
			r.getPS(i).es.pop();
			if(st instanceof AssignStatement) {
				AssignStatement as = (AssignStatement)st;
				r.getPS(i).vt.set(
						as.getVar(), 
						as.getE().eval(r.getPS(i).vt));
			}
			else if(st instanceof CompoundStatement) {
				CompoundStatement cs =(CompoundStatement) st;
				r.getPS(i).es.push(cs.getS2());
				r.getPS(i).es.push(cs.getS1());
			}else if(st instanceof IfStatement) {
				IfStatement is = (IfStatement) st;
				if(is.getE().eval(r.getPS(i).vt)!=0) r.getPS(i).es.push(is.getS1());
				else r.getPS(i).es.push(is.getS2());
			}else if(st instanceof PrintStatement) {
				PrintStatement pr = (PrintStatement) st;
				r.getPS(i).ob.add(Integer.toString(pr.getE().eval(r.getPS(i).vt)));
			}else if(st instanceof ForkStatement) {
				r.addPs(r.getPS(i).ob, r.getPS(i).vt,((ForkStatement) st).getS());
			}else if(st instanceof LockEnter) {
				LockEnter le = (LockEnter) st;
				if(r.getPS(i).lt.get(le.getE().eval(r.getPS(i).vt)) == 0)
					r.getPS(i).lt.set(le.getE().eval(r.getPS(i).vt),r.getPS(i).getPsId());
				else r.getPS(i).es.push(le);
			}else if(st instanceof LockExit) {
				LockExit le = (LockExit) st;
				if(r.getPS(i).lt.get(le.getE().eval(r.getPS(i).vt)) == r.getPS(i).getPsId())
					r.getPS(i).lt.set(le.getE().eval(r.getPS(i).vt), 0);
			}
			if(r.getPS(i).es.isEmpty()) {
				r.removePs(i);
				--i;
			}
		}
	}
	
	public void serializeToFile() {
		r.serializeToFile();
	}
	
	public void serializeFromFile() {
		r = r.serializeFromFile();
	}
	
	public void startInterpreting() {
		while(r.getNumProg() > 0) {
			interpretNext();
		}
	}
	public void debug() {
		PrintWriter writer;
		//Optiunile de la punctul 4
		//mr.serializeToFile();
		//r.ps = mr.serializeFromFile();
		try {
			writer = new PrintWriter("debug.txt");
			while(r.getNumProg() > 0) {
				//Punctul 3
				writer.write("Step------\n");
				writer.write(r.toString());
				interpretNext();
				
			}
			writer.write("Program terminated------\n");
			writer.write(r.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
