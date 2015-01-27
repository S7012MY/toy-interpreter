/*
 * Created by SharpDevelop.
 * User: puscas
 * Date: 10-Jan-15
 * Time: 16:50
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.Drawing;
using System.Windows.Forms;
using ToyInterpreter.Model.MStatement;
using ToyInterpreter.Model.MExpression;
namespace ToyInterpreter.View
{
	/// <summary>
	/// Description of AssignForm.
	/// </summary>
	public partial class AssignForm : Form
	{
		private Expression expression;
		public Statement stmt;
		public Statement getStatement()
			{
				return this.stmt;
			}
		public AssignForm()
		{
			
			//
			// The InitializeComponent() call is required for Windows Forms designer support.
			//
			InitializeComponent();
			
			//
			// TODO: Add constructor code after the InitializeComponent() call.
			//
		}
		void ButtonExpressionClick(object sender, EventArgs e)
		{
			using(ExpressionForm expF = new ExpressionForm())
			{
				if (expF.ShowDialog()== System.Windows.Forms.DialogResult.OK)
				{
					this.expression=expF.getExpression();
				}
			}
		}
		void finished()
		{
			this.DialogResult = System.Windows.Forms.DialogResult.OK;
			this.Close();
		}
		void ButtonOKClick(object sender, EventArgs e)
		{
			String variable = textBoxVariable.Text;
			AssignStatement asstm =new AssignStatement();
			asstm.setVar(variable);
			asstm.setE(this.expression);
			stmt=asstm;
			finished();
		}
	}
}
