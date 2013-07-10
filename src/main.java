import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;


public class main {
	
	public static Vector readAndSplit(String filename,int splitColNum) {
		/**
		 * Reads in a file and splits it by any string delimiter,
		 * and returns a vector corresponding to the column given.
		 * @param filename the file that is going to be read and split
		 * @param splitColNum the column number that will be returned
		 * @return a vector containing that column
		 */
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
				float s = Float.parseFloat(parts[splitColNum]);
				col.addElement(s);
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
	
	public static void PlotData(XYSeries d) {
		PlotTest p = new PlotTest(d);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector field = new Vector();
		Vector val = new Vector();

		// Reads in datafile
		String filename = "Cr7MnpCr7ZngJ-0.440.mag2K";
		field = readAndSplit(filename,1);
		val = readAndSplit(filename,2);
				
		// Spits out stuff to console
		debug.spitOut(val);
		debug.spitOut(field);
		
		XYSeries d = new XYSeries("blarg");
		for(int i=0;i<field.size();i++) {
			d.add((Float)field.get(i),(Float)val.get(i));
		}
		
		PlotData(d);
	}
	
	
	

}

