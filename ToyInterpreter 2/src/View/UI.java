package View;

import java.util.Scanner;

import Controller.ToyInterpreter;
import Model.Expression.ArithExpression;
import Model.Expression.ConstExpression;
import Model.Expression.Expression;
import Model.Expression.VarExpression;
import Model.Statement.AssignStatement;
import Model.Statement.CompoundStatement;
import Model.Statement.ForkStatement;
import Model.Statement.IfStatement;
import Model.Statement.PrintStatement;
import Model.Statement.Statement;
import Repository.MemRepo;
import Repository.Repo;

public class UI {
	
	//pentru optiunile de la punctul 4 apelezi serialize from file si serialize to file
	//din ti
	private final Scanner keyboard = new Scanner(System.in);
	private final ToyInterpreter ti;
	public UI() {
		ti = new ToyInterpreter();
	}
	
	public void printState() {
		System.out.println(ti.r.toString());
	}
	
	public void startUI() {
		
		//System.out.println("Input statement");
		ti.addStatement(readStatement(),1);
		//ti.test();
		System.out.println("1: Step by step\n2: Execute whole program");
		int c = keyboard.nextInt();
		if(c == 1)
			stepByStep();
		else {
			ti.startInterpreting();
			System.out.println(ti.r.ob.toString());
		}
		
		
	}
	
	public void stepByStep() {
		printState();
		while(true) {
			System.out.println("1: Next Step");
			System.out.println("0: Exit");
			int c = keyboard.nextInt();
			
			if(c == 0 || ti.r.getNumProg() == 0) break;
			ti.interpretNext();
			printState();
		}
		System.out.println(ti.r.ob.toString());
	}
	
	public Statement readStatement() {
		System.out.println("1: Compound Statement\n2: If Statement\n3: Assign Statement\n4: Print Statement\n5: Fork statement");
		int c = keyboard.nextInt();
		if(c == 1) return readCS();
		else if(c == 2) return readIfS();
		else if(c == 3) return readAS();
		else if(c == 4) return readPS();
		else if(c == 5) return readFS();
		else return null;
	}
	
	private Statement readPS() {
		PrintStatement ps = new PrintStatement();
		System.out.println("Input expression:");
		ps.setE(readExpression());
		return ps;
	}
	private Statement readAS() {
		AssignStatement as = new AssignStatement();
		System.out.println("Input variable name:");
		as.setVar(keyboard.next());
		System.out.println("Input variable value:");
		as.setE(readExpression());
		return as;
	}
	private Statement readIfS() {
		IfStatement is = new IfStatement();
		System.out.println("Input expression");
		is.setE(readExpression());
		System.out.println("Input first statement:");
		is.setS1(readStatement());
		System.out.println("Input second statement:");
		is.setS2(readStatement());
		return is;
	}
	
	private Statement readFS() {
		ForkStatement fs = new ForkStatement();
		System.out.println("Input statement");
		fs.setS(readStatement());
		return fs;
	}
	
	
	private Expression readExpression() {
		System.out.println(" 1: Const Expression\n 2: Var Expression\n 3: Arith Expression");
		int c = keyboard.nextInt();
		if(c == 1) {
			System.out.println("Input constant expression");
			ConstExpression cx = new ConstExpression(keyboard.nextInt());
			return cx;
		}else if(c == 2) {
			System.out.println("Input variable expression");
			VarExpression ve = new VarExpression(keyboard.next());
			return ve;
		}else if(c == 3) {
			ArithExpression ae = new ArithExpression();
			System.out.println("Input left expression");
			ae.setL(readExpression());
			System.out.println("Input operator");
			ae.setOp(keyboard.next().charAt(0));
			System.out.println("Input right expression");
			ae.setR(readExpression());
			return ae;
		}
		return null;
	}
	
	private Statement readCS() {
		CompoundStatement cs = new CompoundStatement();
		System.out.println("Input first statement:");
		cs.setS1(readStatement());
		System.out.println("Input second statement:");
		cs.setS2(readStatement());
		return cs;
	}
}
