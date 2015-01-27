using System;

namespace ToyInterpreter.Model.MObserver
{
	[Serializable()]
	public class OutBufferObserver : CObserver
	{
		public override void onUpdate (Object o)
		{
			Console.WriteLine ("OutBuffer:");
			Console.WriteLine (o.ToString());
		}
	}
}

