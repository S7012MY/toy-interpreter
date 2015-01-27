using System;
using ToyInterpreter.Model;
using ToyInterpreter.Model.MStatement;
using ToyInterpreter.Model.MExpression;
using ToyInterpreter.Controller;

namespace ToyInterpreter.View
{
	public class UI {
		private CToyInterpreter ti;
		public UI() {
			this.ti = new CToyInterpreter ();
		}

		private Statement readPS() {
			PrintStatement ps = new PrintStatement();
			Console.WriteLine("Input expression:");
			ps.setE(readExpression());
			return ps;
		}
		private Statement readAS() {
			AssignStatement _as = new AssignStatement();
			Console.WriteLine("Input variable name:");
			_as.setVar(Console.ReadLine());
			Console.WriteLine("Input variable value:");
			_as.setE(readExpression());
			return _as;
		}
		private Statement readIfS() {
			IfStatement _is = new IfStatement();
			Console.WriteLine("Input expression");
			_is.setE(readExpression());
			Console.WriteLine("Input first statement:");
			_is.setS1(readStatement());
			Console.WriteLine("Input second statement:");
			_is.setS2(readStatement());
			return _is;
		}

		private Statement readFS() {
			ForkStatement fs = new ForkStatement();
			Console.WriteLine("Input fork's statement");
			fs.setS(readStatement());
			return fs;
		}

		public void printState() {
			Console.WriteLine (ti.r.toString ());
		}

		private Expression readExpression() {
			Console.WriteLine (" 1: Const Expression\n 2: Var Expression\n 3: Arith Expression");
			int c = Convert.ToInt32(Console.ReadLine());
			if (c == 1) {
				Console.WriteLine ("Input constant expression");
				ConstExpression cx = new ConstExpression (Convert.ToInt32(Console.ReadLine()));
				return (Expression)cx;
			} else if (c == 2) {
				Console.WriteLine ("Input variable expression");
				VarExpression ve = new VarExpression (Console.ReadLine());
				return (Expression)ve;
			} else if (c == 3) {
				ArithExpression ae = new ArithExpression ();
				Console.WriteLine ("Input left expression");
				ae.setL (readExpression ());
				Console.WriteLine ("Input operator");
				ae.setOp (Console.ReadLine()[0]);
				Console.WriteLine ("Input right expression");
				ae.setR (readExpression ());
				return (Expression)ae;
			}
			return null;
		}

		private Statement readCS() {
			CompoundStatement cs = new CompoundStatement ();
			Console.WriteLine ("Input first statement");
			cs.setS1 (readStatement ());
			Console.WriteLine ("Input second statement");
			cs.setS2 (readStatement ());
			return cs;
		}

		public Statement readStatement() {
			Console.WriteLine("1: Compound Statement\n2: If Statement\n3: Assign Statement\n4: Print Statement\n5: Fork Statement");
			int c = Convert.ToInt32(Console.ReadLine());
			if (c == 1)
				return readCS ();
			else if (c == 2)
				return readIfS ();
			else if (c == 3)
				return readAS ();
			else if (c == 4)
				return readPS ();
			else if (c == 5)
				return readFS ();
			else return null;
		}

		public void stepByStep() {
			printState ();
			while(true) {
				Console.WriteLine("1: Next Step");
				Console.WriteLine("0: Exit");
				int c = Convert.ToInt32(Console.ReadLine());

				if(c == 0 || ti.r.getNumProg() == 0) break;
				ti.interpretNextMT();
				printState();
			}
			Console.WriteLine (ti.r.ob.toString ());
		}

		public void startUI() {
			Console.WriteLine("Input statement");
			ti.addStatement(readStatement(),1);
			Console.WriteLine ("1: Step by step\n2: Execute whole program");
			int c = Convert.ToInt32(Console.ReadLine());
			if(c == 1)
				stepByStep();
			else {
				ti.startInterpretingMT();
				Console.WriteLine(ti.r.ob.toString());
			}
		}
	}
}

