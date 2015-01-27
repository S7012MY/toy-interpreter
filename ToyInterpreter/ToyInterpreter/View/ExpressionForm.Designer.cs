/*
 * Created by SharpDevelop.
 * User: puscas
 * Date: 10-Jan-15
 * Time: 16:13
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
namespace ToyInterpreter.View
{
	partial class ExpressionForm
	{
		/// <summary>
		/// Designer variable used to keep track of non-visual components.
		/// </summary>
		private System.ComponentModel.IContainer components = null;
		private System.Windows.Forms.TextBox textBoxConstant;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Button buttonSubmitConstant;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.TextBox textBoxVariable;
		private System.Windows.Forms.Button buttonSubmitVariable;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Button buttonLeftExpression;
		private System.Windows.Forms.Button buttonRightExpression;
		private System.Windows.Forms.Button buttonSubmitArithmetic;
		private System.Windows.Forms.TextBox textBoxArithmeticOperand;
		
		/// <summary>
		/// Disposes resources used by the form.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing) {
				if (components != null) {
					components.Dispose();
				}
			}
			base.Dispose(disposing);
		}
		
		/// <summary>
		/// This method is required for Windows Forms designer support.
		/// Do not change the method contents inside the source code editor. The Forms designer might
		/// not be able to load this method if it was changed manually.
		/// </summary>
		private void InitializeComponent()
		{
			this.textBoxConstant = new System.Windows.Forms.TextBox();
			this.label1 = new System.Windows.Forms.Label();
			this.buttonSubmitConstant = new System.Windows.Forms.Button();
			this.label2 = new System.Windows.Forms.Label();
			this.textBoxVariable = new System.Windows.Forms.TextBox();
			this.buttonSubmitVariable = new System.Windows.Forms.Button();
			this.label3 = new System.Windows.Forms.Label();
			this.buttonLeftExpression = new System.Windows.Forms.Button();
			this.buttonRightExpression = new System.Windows.Forms.Button();
			this.buttonSubmitArithmetic = new System.Windows.Forms.Button();
			this.textBoxArithmeticOperand = new System.Windows.Forms.TextBox();
			this.SuspendLayout();
			// 
			// textBoxConstant
			// 
			this.textBoxConstant.Location = new System.Drawing.Point(25, 118);
			this.textBoxConstant.Name = "textBoxConstant";
			this.textBoxConstant.Size = new System.Drawing.Size(100, 20);
			this.textBoxConstant.TabIndex = 0;
			// 
			// label1
			// 
			this.label1.Location = new System.Drawing.Point(36, 44);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(100, 23);
			this.label1.TabIndex = 1;
			this.label1.Text = "Constant";
			// 
			// buttonSubmitConstant
			// 
			this.buttonSubmitConstant.Location = new System.Drawing.Point(36, 184);
			this.buttonSubmitConstant.Name = "buttonSubmitConstant";
			this.buttonSubmitConstant.Size = new System.Drawing.Size(75, 23);
			this.buttonSubmitConstant.TabIndex = 2;
			this.buttonSubmitConstant.Text = "submit";
			this.buttonSubmitConstant.UseVisualStyleBackColor = true;
			this.buttonSubmitConstant.Click += new System.EventHandler(this.ButtonSubmitConstantClick);
			// 
			// label2
			// 
			this.label2.Location = new System.Drawing.Point(209, 35);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(100, 23);
			this.label2.TabIndex = 3;
			this.label2.Text = "Variable";
			// 
			// textBoxVariable
			// 
			this.textBoxVariable.Location = new System.Drawing.Point(198, 118);
			this.textBoxVariable.Name = "textBoxVariable";
			this.textBoxVariable.Size = new System.Drawing.Size(100, 20);
			this.textBoxVariable.TabIndex = 4;
			// 
			// buttonSubmitVariable
			// 
			this.buttonSubmitVariable.Location = new System.Drawing.Point(209, 184);
			this.buttonSubmitVariable.Name = "buttonSubmitVariable";
			this.buttonSubmitVariable.Size = new System.Drawing.Size(75, 23);
			this.buttonSubmitVariable.TabIndex = 5;
			this.buttonSubmitVariable.Text = "submit";
			this.buttonSubmitVariable.UseVisualStyleBackColor = true;
			this.buttonSubmitVariable.Click += new System.EventHandler(this.ButtonSubmitVariableClick);
			// 
			// label3
			// 
			this.label3.Location = new System.Drawing.Point(393, 35);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(100, 23);
			this.label3.TabIndex = 6;
			this.label3.Text = "Arithmetic";
			// 
			// buttonLeftExpression
			// 
			this.buttonLeftExpression.Location = new System.Drawing.Point(366, 74);
			this.buttonLeftExpression.Name = "buttonLeftExpression";
			this.buttonLeftExpression.Size = new System.Drawing.Size(127, 23);
			this.buttonLeftExpression.TabIndex = 7;
			this.buttonLeftExpression.Text = "Left Expression";
			this.buttonLeftExpression.UseVisualStyleBackColor = true;
			this.buttonLeftExpression.Click += new System.EventHandler(this.ButtonLeftExpressionClick);
			// 
			// buttonRightExpression
			// 
			this.buttonRightExpression.Location = new System.Drawing.Point(366, 142);
			this.buttonRightExpression.Name = "buttonRightExpression";
			this.buttonRightExpression.Size = new System.Drawing.Size(127, 23);
			this.buttonRightExpression.TabIndex = 8;
			this.buttonRightExpression.Text = "Right Expression";
			this.buttonRightExpression.UseVisualStyleBackColor = true;
			this.buttonRightExpression.Click += new System.EventHandler(this.ButtonRightExpressionClick);
			// 
			// buttonSubmitArithmetic
			// 
			this.buttonSubmitArithmetic.Location = new System.Drawing.Point(380, 185);
			this.buttonSubmitArithmetic.Name = "buttonSubmitArithmetic";
			this.buttonSubmitArithmetic.Size = new System.Drawing.Size(87, 22);
			this.buttonSubmitArithmetic.TabIndex = 9;
			this.buttonSubmitArithmetic.Text = "submit";
			this.buttonSubmitArithmetic.UseVisualStyleBackColor = true;
			this.buttonSubmitArithmetic.Click += new System.EventHandler(this.ButtonSubmitArithmeticClick);
			// 
			// textBoxArithmeticOperand
			// 
			this.textBoxArithmeticOperand.Location = new System.Drawing.Point(367, 118);
			this.textBoxArithmeticOperand.Name = "textBoxArithmeticOperand";
			this.textBoxArithmeticOperand.Size = new System.Drawing.Size(100, 20);
			this.textBoxArithmeticOperand.TabIndex = 10;
			// 
			// ExpressionForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(505, 261);
			this.Controls.Add(this.textBoxArithmeticOperand);
			this.Controls.Add(this.buttonSubmitArithmetic);
			this.Controls.Add(this.buttonRightExpression);
			this.Controls.Add(this.buttonLeftExpression);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.buttonSubmitVariable);
			this.Controls.Add(this.textBoxVariable);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.buttonSubmitConstant);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.textBoxConstant);
			this.Name = "ExpressionForm";
			this.Text = "ExpressionForm";
			this.ResumeLayout(false);
			this.PerformLayout();

		}
	}
}
