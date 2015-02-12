package com.schappell.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;

/**
 * The purpose of this class is to read a CSV file named "aiddata2-1_thin.csv".
 * CVS file must be in the same location as the executable JAR file.
 * 
 * @author Scott Chappell
 */
public class CSVFileReader 
{
	// Creates a new CSVStrategy object that sets parsing rules
	private CSVStrategy myStrategy = new CSVStrategy(',', '"', '#', true, true);
	
	// Stores the filepath of the CSV file
	// Set to be in the same directory as the executable JAR file
	private String filePath = "./aiddata2-1_thin.csv";
	
	/**
	 * Gathers string data from a CSV file
	 * 
	 * @return A list of AidDataRecord objects with the string data
	 */
	public List<AidDataRecord> readFile()
	{
		try
		{
			FileReader reader = new FileReader(filePath);
			
			// Parses the CSV file
			CSVReader<AidDataRecord> csvPersonReader = new CSVReaderBuilder<AidDataRecord>(reader)
					.strategy(myStrategy).entryParser(new RecordParser()).build();
			
			// Puts the data in the CSV file into a list
			List<AidDataRecord> aidDataRecords = csvPersonReader.readAll();
			return aidDataRecords;
			
		}
		catch(IOException e)
	    {
			JOptionPane.showMessageDialog(null, 
					"File Not Found\nPlease put the 'aiddata2-1_thin.csv' " +
					"file in the same folder as the Jar file");
			return null;
	    }
	}
	

}
