/*
 * Created by SharpDevelop.
 * User: puscas
 * Date: 10-Jan-15
 * Time: 15:28
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
namespace ToyInterpreter.View
{
	partial class StartUi
	{
		/// <summary>
		/// Designer variable used to keep track of non-visual components.
		/// </summary>
		private System.ComponentModel.IContainer components = null;
		private System.Windows.Forms.Button buttonAddStatement;
		private System.Windows.Forms.Button buttonSerializeToFile;
		private System.Windows.Forms.Button buttonSerializeFromFile;
		private System.Windows.Forms.Button buttonSteByStep;
		private System.Windows.Forms.Button buttonRunWholeProgram;
		
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
			this.buttonAddStatement = new System.Windows.Forms.Button();
			this.buttonSerializeToFile = new System.Windows.Forms.Button();
			this.buttonSerializeFromFile = new System.Windows.Forms.Button();
			this.buttonSteByStep = new System.Windows.Forms.Button();
			this.buttonRunWholeProgram = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// buttonAddStatement
			// 
			this.buttonAddStatement.Location = new System.Drawing.Point(76, 38);
			this.buttonAddStatement.Name = "buttonAddStatement";
			this.buttonAddStatement.Size = new System.Drawing.Size(111, 23);
			this.buttonAddStatement.TabIndex = 0;
			this.buttonAddStatement.Text = "Add Statement";
			this.buttonAddStatement.UseVisualStyleBackColor = true;
			this.buttonAddStatement.Click += new System.EventHandler(this.ButtonAddStatementClick);
			// 
			// buttonSerializeToFile
			// 
			this.buttonSerializeToFile.Location = new System.Drawing.Point(76, 83);
			this.buttonSerializeToFile.Name = "buttonSerializeToFile";
			this.buttonSerializeToFile.Size = new System.Drawing.Size(111, 23);
			this.buttonSerializeToFile.TabIndex = 1;
			this.buttonSerializeToFile.Text = "Serialize to file";
			this.buttonSerializeToFile.UseVisualStyleBackColor = true;
			this.buttonSerializeToFile.Click += new System.EventHandler(this.ButtonSerializeToFileClick);
			// 
			// buttonSerializeFromFile
			// 
			this.buttonSerializeFromFile.Location = new System.Drawing.Point(76, 129);
			this.buttonSerializeFromFile.Name = "buttonSerializeFromFile";
			this.buttonSerializeFromFile.Size = new System.Drawing.Size(111, 23);
			this.buttonSerializeFromFile.TabIndex = 2;
			this.buttonSerializeFromFile.Text = "Serialize from file";
			this.buttonSerializeFromFile.UseVisualStyleBackColor = true;
			this.buttonSerializeFromFile.Click += new System.EventHandler(this.ButtonSerializeFromFileClick);
			// 
			// buttonSteByStep
			// 
			this.buttonSteByStep.Location = new System.Drawing.Point(75, 176);
			this.buttonSteByStep.Name = "buttonSteByStep";
			this.buttonSteByStep.Size = new System.Drawing.Size(112, 25);
			this.buttonSteByStep.TabIndex = 3;
			this.buttonSteByStep.Text = "StepByStep";
			this.buttonSteByStep.UseVisualStyleBackColor = true;
			this.buttonSteByStep.Click += new System.EventHandler(this.ButtonSteByStepClick);
			// 
			// buttonRunWholeProgram
			// 
			this.buttonRunWholeProgram.Location = new System.Drawing.Point(34, 226);
			this.buttonRunWholeProgram.Name = "buttonRunWholeProgram";
			this.buttonRunWholeProgram.Size = new System.Drawing.Size(201, 23);
			this.buttonRunWholeProgram.TabIndex = 4;
			this.buttonRunWholeProgram.Text = "Run whole program";
			this.buttonRunWholeProgram.UseVisualStyleBackColor = true;
			this.buttonRunWholeProgram.Click += new System.EventHandler(this.ButtonRunWholeProgramClick);
			// 
			// StartUi
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(284, 261);
			this.Controls.Add(this.buttonRunWholeProgram);
			this.Controls.Add(this.buttonSteByStep);
			this.Controls.Add(this.buttonSerializeFromFile);
			this.Controls.Add(this.buttonSerializeToFile);
			this.Controls.Add(this.buttonAddStatement);
			this.Name = "StartUi";
			this.Text = "StartUi";
			this.ResumeLayout(false);

		}
	}
}
