using System;
using ToyInterpreter.Model.MStatement;
using ToyInterpreter.Model.MObserver;

namespace ToyInterpreter.Model
{
	public interface IStack
	{
		void push(Statement s);
		Statement top();
		void pop();
		bool isEmpty();
		String toString();
		void addObserver(StackObserver o);
	}
}

