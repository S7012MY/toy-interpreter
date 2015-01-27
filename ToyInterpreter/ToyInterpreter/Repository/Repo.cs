using System;
using ToyInterpreter.Model;
using ToyInterpreter.Model.MStatement;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

namespace ToyInterpreter.Repository
{
	[Serializable()]
	public class Repo : IRepo
	{
		private int numProg;
		private ProgState[] pslist = new ProgState[100];
		public ProgState ps = new ProgState(new ExeStack(),new OutBuffer(),new VarTable(),1,new Heap());
		public OutBuffer ob;
		public Heap hp;
		private int cid = 1;

		public void removePs(int i) {
			ob = (OutBuffer) pslist[1].ob;
			hp = (Heap)pslist [1].hp;
			for(;i<numProg; ++i) pslist[i]=pslist[i+1];
			--numProg;
		}

		public ProgState getPS(int i) {return pslist[i];}
		public void addPs(IOutBuffer ob, IDictionary vt, Statement st) {
			++numProg;
			pslist[numProg] = new ProgState(new ExeStack(), ob, vt.clone(),cid,hp);
			++cid;
			pslist[numProg].es.push(st);
		}

		public String toString() {
			String s="";
			s+="Number of programs: " + numProg+"\n";
			for(int i=1; i <= numProg; ++i) {
				s+="Program "+i+ "\n";
				s+=pslist[i].es.toString();
				s+=pslist[i].ob.toString();
				s+=pslist[i].vt.toString();
				s += pslist [i].hp.toString ();
			}
			return s;
		}

		public Repo() {
			numProg = 1;
			ob = new OutBuffer ();
			hp = new Heap ();
			pslist[numProg] = new ProgState(new ExeStack(),ob,new VarTable(),cid,hp);
			++cid;
		}

		public int getNumProg() {
			return numProg;
		}

		public bool SerializeToFile() {
			try {
				FileStream fs = File.Create("toyInterpreter.txt");

				BinaryFormatter bformatter = new BinaryFormatter();

				bformatter.Serialize(fs, this);

				fs.Close();
				return true;
			}
			catch (SerializationException e) {
				Console.WriteLine("ERROR: could not write: " + e.Message);
			}
			catch (IOException e) {
				Console.WriteLine("ERROR: could not write: " + e.Message);
			}
			return false;
		}

		public Repo SerializeFromFile() {
			try {
				FileStream fs = File.OpenRead("toyInterpreter.txt");
				BinaryFormatter bformatter = new BinaryFormatter();

				Repo r = (Repo) bformatter.Deserialize(fs);

				fs.Close();
				return r;
			}
			catch (SerializationException e) {
				Console.WriteLine("ERROR: could not read: " + e.Message);
			}
			catch (IOException e) {
				Console.WriteLine("ERROR: could not read: " + e.Message);
			}

			return null;
		}
	}
}

