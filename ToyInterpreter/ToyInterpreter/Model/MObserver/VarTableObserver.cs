using System;

namespace ToyInterpreter.Model.MObserver
{
	[Serializable()]
	public class VarTableObserver : CObserver
	{
		public override void onUpdate (Object o)
		{
			Console.WriteLine ("VarTable:");
			Console.WriteLine (o.ToString());
		}
	}
}

