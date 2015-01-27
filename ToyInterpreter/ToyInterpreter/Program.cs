using System;
using ToyInterpreter.Controller;
using ToyInterpreter.View;
using System.Drawing;
using System.Windows.Forms;

namespace ToyInterpreter
{
	class MainClass:System.Windows.Forms.Form
	{
		public static void Main ()
		{

			Application.EnableVisualStyles();

			//UI ui = new UI();
			//ui.startUI ();
			Application.Run(new StartUi());
		}
	}
}
