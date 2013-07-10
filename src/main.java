import java.io.*;
import java.util.*;

public class main {
	public static void spitOut(Vector v) {		
		Enumeration vEnum = v.elements();
		while(vEnum.hasMoreElements()) {
			System.out.print(vEnum.nextElement());
			System.out.print("\n");
		}					

	}
	public static Vector readAndSplit(String filename,int splitColNum) {
		Vector col = new Vector(1,1);
		
		try{
			// Open file
			FileInputStream fstream = new FileInputStream(filename);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String strLine;

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
				String parts[] = strLine.split("\\s+");
				col.addElement(Float.parseFloat(parts[splitColNum]));
			}
			//Close the input stream
			in.close();			 			  

		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		return col;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector field = new Vector(1,1);
		Vector val = new Vector(1,1);

		String filename = "Cr7MnpCr7ZngJ-0.440.mag2K";
		field = readAndSplit(filename,1);
		val = readAndSplit(filename,2);
		
		spitOut(val);
		spitOut(field);
				

	}

}

