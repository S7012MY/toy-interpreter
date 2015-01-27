using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System;
using ToyInterpreter.Model;

namespace ToyInterpreter.Repository
{
	public class MemRepo
	{
		private ProgState ps;
		public MemRepo (ProgState ps) {
			this.ps = ps;
		}

		public bool SerializeToFile() {
			try {
				FileStream fs = File.Create("toyInterpreter.txt");

				BinaryFormatter bformatter = new BinaryFormatter();

				bformatter.Serialize(fs, ps);

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

		public ProgState SerializeFromFile() {
			try {
				FileStream fs = File.OpenRead("toyInterpreter.txt");
				BinaryFormatter bformatter = new BinaryFormatter();

				ps = (ProgState) bformatter.Deserialize(fs);

				fs.Close();
				return ps;
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

