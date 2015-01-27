using System;

namespace ToyInterpreter.Model.MObserver
{
	[Serializable()]
	public abstract class CObserver {
		public abstract void onUpdate (Object o);
	}
}

