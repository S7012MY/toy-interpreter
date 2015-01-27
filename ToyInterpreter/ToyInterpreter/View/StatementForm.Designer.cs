/*
 * Created by SharpDevelop.
 * User: puscas
 * Date: 10-Jan-15
 * Time: 15:38
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
namespace ToyInterpreter.View
{
	partial class StatementForm
	{
		/// <summary>
		/// Designer variable used to keep track of non-visual components.
		/// </summary>
		private System.ComponentModel.IContainer components = null;
		private System.Windows.Forms.Button buttonCompound;
		private System.Windows.Forms.Button buttonAssign;
		private System.Windows.Forms.Button buttonIf;
		private System.Windows.Forms.Button buttonPrintStatement;
		private System.Windows.Forms.Button buttonFork;
		
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
			this.buttonCompound = new System.Windows.Forms.Button();
			this.buttonAssign = new System.Windows.Forms.Button();
			this.buttonIf = new System.Windows.Forms.Button();
			this.buttonPrintStatement = new System.Windows.Forms.Button();
			this.buttonFork = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// buttonCompound
			// 
			this.buttonCompound.Location = new System.Drawing.Point(39, 59);
			this.buttonCompound.Name = "buttonCompound";
			this.buttonCompound.Size = new System.Drawing.Size(164, 23);
			this.buttonCompound.TabIndex = 0;
			this.buttonCompound.Text = "Add Compound Statement";
			this.buttonCompound.UseVisualStyleBackColor = true;
			this.buttonCompound.Click += new System.EventHandler(this.ButtonCompoundClick);
			// 
			// buttonAssign
			// 
			this.buttonAssign.Location = new System.Drawing.Point(251, 59);
			this.buttonAssign.Name = "buttonAssign";
			this.buttonAssign.Size = new System.Drawing.Size(180, 23);
			this.buttonAssign.TabIndex = 1;
			this.buttonAssign.Text = "Assign Statement";
			this.buttonAssign.UseVisualStyleBackColor = true;
			this.buttonAssign.Click += new System.EventHandler(this.ButtonAssignClick);
			// 
			// buttonIf
			// 
			this.buttonIf.Location = new System.Drawing.Point(39, 188);
			this.buttonIf.Name = "buttonIf";
			this.buttonIf.Size = new System.Drawing.Size(164, 23);
			this.buttonIf.TabIndex = 2;
			this.buttonIf.Text = "IfStatement";
			this.buttonIf.UseVisualStyleBackColor = true;
			this.buttonIf.Click += new System.EventHandler(this.ButtonIfClick);
			// 
			// buttonPrintStatement
			// 
			this.buttonPrintStatement.Location = new System.Drawing.Point(251, 188);
			this.buttonPrintStatement.Name = "buttonPrintStatement";
			this.buttonPrintStatement.Size = new System.Drawing.Size(180, 23);
			this.buttonPrintStatement.TabIndex = 3;
			this.buttonPrintStatement.Text = "Print  Statement";
			this.buttonPrintStatement.UseVisualStyleBackColor = true;
			this.buttonPrintStatement.Click += new System.EventHandler(this.ButtonPrintStatementClick);

			// 
			// buttonFork
			// 
			this.buttonFork.Location = new System.Drawing.Point(121, 100);
			this.buttonFork.Name = "buttonFork";
			this.buttonFork.Size = new System.Drawing.Size(200, 23);
			this.buttonFork.TabIndex = 4;
			this.buttonFork.Text = "Fork Statement";
			this.buttonFork.UseVisualStyleBackColor = true;
			this.buttonFork.Click += new System.EventHandler(this.ButtonForkClick);

			// 
			// StatementForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(505, 270);
			this.Controls.Add(this.buttonPrintStatement);
			this.Controls.Add(this.buttonIf);
			this.Controls.Add(this.buttonAssign);
			this.Controls.Add(this.buttonCompound);
			this.Controls.Add (this.buttonFork);
			this.Name = "StatementForm";
			this.Text = "StatementForm";
			this.ResumeLayout(false);

		}
	}
}
