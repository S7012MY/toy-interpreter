using System;

namespace ToyInterpreter.Model.MObserver
{
	[Serializable()]
	public class StackObserver : CObserver
	{
		public override void onUpdate (Object o)
		{
			Console.WriteLine ("ExeStack:");
			Console.WriteLine (o.ToString());
		}
	}
}

