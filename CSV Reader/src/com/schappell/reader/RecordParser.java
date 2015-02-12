package com.schappell.reader;

import javax.swing.JOptionPane;

import com.googlecode.jcsv.reader.CSVEntryParser;

/**
 * The purpose of this class is to parse a CSV file into an AidDataRecord object.
 * The number of columns must match the number of variables to be filled in the 
 * AidDataRecord object.
 * 
 * @author Scott Chappell
 */
public class RecordParser implements CSVEntryParser<AidDataRecord> 
{
	public AidDataRecord parseEntry(String... data) 
	{
		 if (data.length != 7) 
		 {
			 // Error message if a CSV file is parsed with the wrong number of columns
			 JOptionPane.showMessageDialog(null, 
					 "Data is not a valid record/nThe CSR file needs to have 7 fields");
			 throw new IllegalArgumentException("data is not a valid record");     
		 }

        String aiddataId = data[0];
        String year = data[1];
        String donor = data[2];
        String recipient = data[3];
        String amount = data[4];
        String purposeCode = data[5];
        String purposeName = data[6];

        return new AidDataRecord(aiddataId, year, donor, recipient, 
        		amount, purposeCode, purposeName);
	}
	

}
