/*
 * Created by SharpDevelop.
 * User: puscas
 * Date: 10-Jan-15
 * Time: 16:50
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
namespace ToyInterpreter.View
{
	partial class AssignForm
	{
		/// <summary>
		/// Designer variable used to keep track of non-visual components.
		/// </summary>
		private System.ComponentModel.IContainer components = null;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.TextBox textBoxVariable;
		private System.Windows.Forms.Button buttonExpression;
		private System.Windows.Forms.Button buttonOK;
		
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
			this.label1 = new System.Windows.Forms.Label();
			this.textBoxVariable = new System.Windows.Forms.TextBox();
			this.buttonExpression = new System.Windows.Forms.Button();
			this.buttonOK = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.Location = new System.Drawing.Point(103, 39);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(144, 20);
			this.label1.TabIndex = 0;
			this.label1.Text = "Variable";
			// 
			// textBoxVariable
			// 
			this.textBoxVariable.Location = new System.Drawing.Point(85, 90);
			this.textBoxVariable.Name = "textBoxVariable";
			this.textBoxVariable.Size = new System.Drawing.Size(100, 20);
			this.textBoxVariable.TabIndex = 1;
			// 
			// buttonExpression
			// 
			this.buttonExpression.Location = new System.Drawing.Point(80, 164);
			this.buttonExpression.Name = "buttonExpression";
			this.buttonExpression.Size = new System.Drawing.Size(122, 23);
			this.buttonExpression.TabIndex = 2;
			this.buttonExpression.Text = "Expression create";
			this.buttonExpression.UseVisualStyleBackColor = true;
			this.buttonExpression.Click += new System.EventHandler(this.ButtonExpressionClick);
			// 
			// buttonOK
			// 
			this.buttonOK.Location = new System.Drawing.Point(259, 239);
			this.buttonOK.Name = "buttonOK";
			this.buttonOK.Size = new System.Drawing.Size(75, 23);
			this.buttonOK.TabIndex = 3;
			this.buttonOK.Text = "OK";
			this.buttonOK.UseVisualStyleBackColor = true;
			this.buttonOK.Click += new System.EventHandler(this.ButtonOKClick);
			// 
			// AssignForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(370, 274);
			this.Controls.Add(this.buttonOK);
			this.Controls.Add(this.buttonExpression);
			this.Controls.Add(this.textBoxVariable);
			this.Controls.Add(this.label1);
			this.Name = "AssignForm";
			this.Text = "AssignForm";
			this.ResumeLayout(false);
			this.PerformLayout();

		}
	}
}
