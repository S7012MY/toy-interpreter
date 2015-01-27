using System;
using ToyInterpreter.Model.MObserver;

namespace ToyInterpreter.Model
{
	public interface IOutBuffer
	{
		void add(String s);
		int getSize();
		void printBuffer();
		String toString();
		void addObserver(OutBufferObserver o);
	}
}

