/*
 * Created by SharpDevelop.
 * User: puscas
 * Date: 10-Jan-15
 * Time: 16:13
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.Drawing;
using System.Windows.Forms;
using ToyInterpreter.Model.MExpression;
namespace ToyInterpreter.View
{
	/// <summary>
	/// Description of ExpressionForm.
	/// </summary>
	public partial class ExpressionForm : Form
	{
		public Expression expression;
		public Expression rightExpression;
		public Expression leftExpression;
		public Expression newExpression;
		public Expression getExpression()
		{
			return expression;
		}
		public ExpressionForm(String title)
		{
			//
			// The InitializeComponent() call is required for Windows Forms designer support.
			//
			InitializeComponent();
			this.Text=title;
			
			//
			// TODO: Add constructor code after the InitializeComponent() call.
			//
		}
		public ExpressionForm()
		{
			//
			// The InitializeComponent() call is required for Windows Forms designer support.
			//
			InitializeComponent();
			
			//
			// TODO: Add constructor code after the InitializeComponent() call.
			//
		}
		void ButtonSubmitConstantClick(object sender, EventArgs e)
		{
			String constant = textBoxConstant.Text;
			ConstExpression cx = new ConstExpression (Convert.ToInt32(constant));
			expression = cx;
			finished();
		}
		void ButtonSubmitVariableClick(object sender, EventArgs e)
		{
			String variable = textBoxVariable.Text;
			VarExpression ve = new VarExpression (variable);
			expression=ve;
			finished();
			
		}
		void ButtonSubmitArithmeticClick(object sender, EventArgs e)
		{
			String operand = textBoxArithmeticOperand.Text;
			ArithExpression ae = new ArithExpression ();
			ae.setL(leftExpression);
			ae.setOp(operand[0]);
			ae.setR(rightExpression);
			expression=ae;
			finished();
		}
		void finished()
		{
			this.DialogResult = System.Windows.Forms.DialogResult.OK;
			this.Close();
		}
		void ButtonLeftExpressionClick(object sender, EventArgs e)
		{
			//PrintStatement ps = new PrintStatement();
			using(ExpressionForm expF = new ExpressionForm())
			{
				if (expF.ShowDialog()== System.Windows.Forms.DialogResult.OK)
				{
					
					this.leftExpression=expF.getExpression();
					
				}
			}
	
		}
		void ButtonRightExpressionClick(object sender, EventArgs e)
		{
			using(ExpressionForm expF = new ExpressionForm())
			{
				if (expF.ShowDialog()== System.Windows.Forms.DialogResult.OK)
				{
					
					this.rightExpression=expF.getExpression();
					
				}
			}
		}
	}
}
