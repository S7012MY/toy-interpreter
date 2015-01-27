/*
 * Created by SharpDevelop.
 * User: puscas
 * Date: 10-Jan-15
 * Time: 15:28
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.Drawing;
using System.Windows.Forms;
using ToyInterpreter.Controller;

namespace ToyInterpreter.View
{
	/// <summary>
	/// Description of StartUi.
	/// </summary>
	public partial class StartUi : Form
	{	private CToyInterpreter ti;
		public StartUi()
		{
			this.ti = new CToyInterpreter ();
			//
			// The InitializeComponent() call is required for Windows Forms designer support.
			//
			InitializeComponent();
			
			//
			// TODO: Add constructor code after the InitializeComponent() call.
			//
		}
		void ButtonAddStatementClick(object sender, EventArgs e)
		{
			using (StatementForm sf = new StatementForm("choose Statement"))
			{
				if (sf.ShowDialog() == System.Windows.Forms.DialogResult.OK)
				{
					ti.addStatement(sf.getStatement(),1);
				}
			}
		}
		void ButtonSerializeToFileClick(object sender, EventArgs e)
		{
			ti.serializeToFile();
		}
		void ButtonSerializeFromFileClick(object sender, EventArgs e)
		{
			ti.serializeFromFile();
		}
		void ButtonSteByStepClick(object sender, EventArgs e)
		{
			MessageBox.Show(ti.r.toString());

			System.IO.StreamWriter file = new System.IO.StreamWriter("debug.txt");
			Console.WriteLine ("aici");
			while(true) {
				int c = 2;

				if(c == 0 || ti.r.getNumProg() == 0) break;
				ti.interpretNextMT();
				MessageBox.Show(ti.r.toString());
				file.WriteLine(ti.r.toString() + "\n---------");
			}
			file.WriteLine(ti.r.toString());
			file.Close ();
			MessageBox.Show(ti.r.ob.toString());
		}
		void ButtonRunWholeProgramClick(object sender, EventArgs e)
		{
			ti.startInterpretingMT();
			MessageBox.Show(ti.r.ob.toString());
		}
	}
}
