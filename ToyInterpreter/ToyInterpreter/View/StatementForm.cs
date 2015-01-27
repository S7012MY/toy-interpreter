/*
 * Created by SharpDevelop.
 * User: puscas
 * Date: 10-Jan-15
 * Time: 15:38
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.Drawing;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;
using ToyInterpreter.Model.MStatement;
using ToyInterpreter.Model.MExpression;
namespace ToyInterpreter.View
{
	/// <summary>
	/// Description of StatementForm.
	/// </summary>
	public partial class StatementForm : Form
	{
		
		public Statement stmt ;
		public Statement getStatement()
		{
			return stmt;
		}
		public StatementForm()
		{
		
			//
			// The InitializeComponent() call is required for Windows Forms designer support.
			//
			InitializeComponent();
			
			//
			// TODO: Add constructor code after the InitializeComponent() call.
			//
		}
		public StatementForm(String title)
		{
		
			//
			// The InitializeComponent() call is required for Windows Forms designer support.
			//
			InitializeComponent();
			this.Text = title;
			//
			// TODO: Add constructor code after the InitializeComponent() call.
			//
		}
		void ButtonCompoundClick(object sender, EventArgs e)
		{
			Statement firstStatement =null;
			Statement secondStatement = null ;
				using(StatementForm sf = new StatementForm("First Compound Statement"))
			      {
					if (sf.ShowDialog() == System.Windows.Forms.DialogResult.OK)
						{
							firstStatement=sf.getStatement();
							using(StatementForm sf2 = new StatementForm("Second Compound"))
							{
								if (sf2.ShowDialog()==System.Windows.Forms.DialogResult.OK)
								{
									secondStatement= sf2.getStatement();
								}
							}
						}
			      }
				CompoundStatement cs = new CompoundStatement ();
				cs.setS1(firstStatement);
				cs.setS2(secondStatement);
				this.stmt=cs;
				finished();
				
				
		}
		void ButtonAssignClick(object sender, EventArgs e)
		{
			using (AssignForm asm = new AssignForm())
			{
				if (asm.ShowDialog() == System.Windows.Forms.DialogResult.OK)
				{
					stmt = asm.getStatement();
					finished();
				}
			}
			
		}
		void ButtonPrintStatementClick(object sender, EventArgs e)
		{
			PrintStatement ps = new PrintStatement();
			using(ExpressionForm expF = new ExpressionForm())
			{
				if (expF.ShowDialog()== System.Windows.Forms.DialogResult.OK)
				{	
					
					ps.setE(expF.getExpression());
					this.stmt=ps;
					finished();
				}
			}
		}
		void ButtonIfClick(object sender, EventArgs e)
		{
			Expression exp = null;
			using(ExpressionForm expF = new ExpressionForm("IF's Expression"))
			{
				if (expF.ShowDialog()== System.Windows.Forms.DialogResult.OK)
				{
					exp =expF.getExpression();
					
				}
			}
			Statement firstStatement =null;
			Statement secondStatement = null ;
				using(StatementForm sf = new StatementForm("First IF Statement"))
			      {
					if (sf.ShowDialog() == System.Windows.Forms.DialogResult.OK)
						{
							firstStatement=sf.getStatement();
							using(StatementForm sf2 = new StatementForm("Second IF Statement"))
							{
								if (sf2.ShowDialog()==System.Windows.Forms.DialogResult.OK)
								{
									secondStatement= sf2.getStatement();
								}
							}
						}
			      }
				
				IfStatement ifS= new IfStatement();
				ifS.setE(exp);
				ifS.setS1(firstStatement);
				ifS.setS2(secondStatement);
				
				stmt=ifS;
				finished();
		}

		void ButtonForkClick(object sender, EventArgs e)
		{
			Statement st = null;
			using(StatementForm sf = new StatementForm("Fork's Statement"))
			{
				if (sf.ShowDialog() == System.Windows.Forms.DialogResult.OK)
				{
					st = sf.getStatement();
				}
			}
			ForkStatement fs = new ForkStatement ();
			fs.setS(st);
			this.stmt=fs;
			finished();


		}

		void Button1Click(object sender, EventArgs e)
		{
			
		}
		void finished()
		{
			this.DialogResult = System.Windows.Forms.DialogResult.OK;
			this.Close();
		}
	}
}
