using System;
using ToyInterpreter.Model;
using ToyInterpreter.View;
using ToyInterpreter.Model.MStatement;
using ToyInterpreter.Model.MExpression;
using ToyInterpreter.Repository;
using ToyInterpreter.Model.MObserver;

namespace ToyInterpreter.Controller
{
	public class CToyInterpreter {
		public Repo r;

		public void addStatement(Statement s) {
			r.ps.es.push(s);
		}
		public void addStatement(Statement s,int idx) {
			r.getPS (idx).es.push (s);
		}

		public ProgState getPs() {
			return r.ps;
		}

		public ProgState getPs(int idx) {
			return r.getPS(idx);
		}

		public CToyInterpreter() {
			r = new Repo();
			test ();
		}
		public void test() {
			/*r.ps.es.push(
				new CompoundStatement(
					new CompoundStatement(
						new CompoundStatement(new AssignStatement("a",new ArithExpression(new ConstExpression(55),new ConstExpression(2),'*')),
							new AssignStatement("b",new ArithExpression(new ConstExpression(55),new ConstExpression(2),'/'))
						),
						new PrintStatement(new ArithExpression(new VarExpression("a"),new VarExpression("b"),'/'))),
					new AssignStatement("z",new ArithExpression(new ConstExpression(23),new ConstExpression(1),'+'))
				)
			);*/
			r.getPS (1).es.push (new CompoundStatement(
				new AssignStatement("v",new NewExpression(new ReadExpression())),
				new CompoundStatement(
					new PrintStatement(new RExpression(new VarExpression("v"))),
					new ForkStatement(new CompoundStatement(
							new WHStatement("v",new ArithExpression(new ConstExpression(1),new ReadExpression(),'+')),
							new CompoundStatement(
								new PrintStatement(new RExpression(new VarExpression("v"))),
								new CompoundStatement(
									new ForkStatement(new WHStatement("v",new ConstExpression(20))),
									new CompoundStatement(
										new PrintStatement(new RExpression(new VarExpression("v"))),
										new PrintStatement(new ArithExpression(new RExpression(new VarExpression("v")),new ConstExpression(1),'+'))
									)
								)
							)
					))
				)));
		}

		public void interpretNextMT() {
			for (int i = 1; i <= r.getNumProg (); ++i) {
				Statement st = r.getPS(i).es.top ();
				r.getPS(i).es.pop ();
				if (st is AssignStatement) {
					AssignStatement _as = (AssignStatement)st;
					r.getPS (i).vt.set (
						_as.getVar (), 
						_as.getE ().eval (r.getPS (i).vt, r.getPS (i).hp));
					r.getPS (i).vt.printTable ();
				} else if (st is CompoundStatement) {
					CompoundStatement cs = (CompoundStatement)st;
					r.getPS (i).es.push (cs.getS2 ());
					r.getPS (i).es.push (cs.getS1 ());
				} else if (st is IfStatement) {
					IfStatement _is = (IfStatement)st;
					if (_is.getE ().eval (r.getPS (i).vt, r.getPS (i).hp) != 0)
						r.getPS (i).es.push (_is.getS1 ());
					else
						r.getPS (i).es.push (_is.getS2 ());
				} else if (st is PrintStatement) {
					PrintStatement pr = (PrintStatement)st;
					r.getPS (i).ob.add (pr.getE ().eval (r.getPS (i).vt, r.getPS (i).hp).ToString ());
				} else if (st is ForkStatement) {
					r.addPs (r.getPS (i).ob, r.getPS (i).vt, ((ForkStatement)st).getS ());
				} else if (st is WHStatement) {
					WHStatement wh = (WHStatement)st;
					int addr = r.getPS (i).vt.get (wh.getVN());
					r.getPS (i).hp.mod (addr, wh.getV ().eval (r.getPS (i).vt, r.getPS (i).hp));
				}
				if(r.getPS(i).es.isEmpty()) {
					r.removePs(i);
					--i;
				}
			}
		}

		public void interpretNext() {
			Statement st = r.ps.es.top();

			r.ps.es.pop();
			if(st is AssignStatement) {
				AssignStatement _as = (AssignStatement)st;
				r.ps.vt.set(
					_as.getVar(), 
					_as.getE().eval(r.ps.vt,r.ps.hp));
				r.ps.vt.printTable();
			}
			else if(st is CompoundStatement) {
				CompoundStatement cs =(CompoundStatement) st;
				r.ps.es.push(cs.getS2());
				r.ps.es.push(cs.getS1());
			}else if(st is IfStatement) {
				IfStatement _is = (IfStatement) st;
				if(_is.getE().eval(r.ps.vt,r.ps.hp)!=0) r.ps.es.push(_is.getS1());
				else r.ps.es.push(_is.getS2());
			}else if(st is PrintStatement) {
				PrintStatement pr = (PrintStatement) st;
				r.ps.ob.add(pr.getE().eval(r.ps.vt,r.ps.hp).ToString());
			}
		}

		public void startInterpretingMT() {
			while(r.getNumProg() > 0) {
				interpretNextMT();
			}
		}

		public void startInterpreting() {
			while(!r.ps.es.isEmpty()) {
				interpretNext ();
			}

		}

		public void debugMT() {
			System.IO.StreamWriter file = new System.IO.StreamWriter("debug.txt");
			while(r.getNumProg() > 0) {
				file.WriteLine("Step------");
				file.Write (r.toString ());
				interpretNext();
			}
			file.WriteLine ("Program Terminated----");
			file.Write (r.toString ());
			file.Close ();
		}

		public void debug() {
			System.IO.StreamWriter file = new System.IO.StreamWriter("debug.txt");
			while(!r.ps.es.isEmpty()) {
				file.WriteLine("Step------");
				file.Write (r.toString ());
				interpretNext();
			}
			file.Close ();
		}

		public void serializeFromFile() {
			MemRepo mr = new MemRepo (r.ps);
			r.ps = mr.SerializeFromFile ();
		}

		public void serializeToFile() {
			MemRepo mr = new MemRepo (r.ps);
			mr.SerializeToFile ();
		}
	}
}

