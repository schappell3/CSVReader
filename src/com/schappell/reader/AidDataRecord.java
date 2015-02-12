package com.schappell.reader;

import java.text.NumberFormat;

/**
 * The purpose of this class is to hold data from a CSV file
 * (comma separated values file)
 * 
 * @author Scott Chappell
 */
public class AidDataRecord 
{
	private String id;			// Unique id of AidData records
	private String year;		// Year donation was made
	private String donor;		// Donor country
	private String recipient;	// Recipient country
	private String amount;		// Amount given
	private String purposeCode; // Code to identify purpose
	private String purposeName; // Name of the purpose
	
	
	/*
	 * A constructor that sets all the string values of an AidDataRecord object
	 * 
	 */
	public AidDataRecord(String id, String year, String donor, String recipient, 
			String amount, String purposeCode, String purposeName)
	{
		this.id = id;
		this.year = year;
		this.donor = donor;
		this.recipient = recipient;
		this.amount = amount;
		this.purposeCode = purposeCode;
		this.purposeName = purposeName;
	}
	
	/**
	 * A get method that returns the AidData ID.
	 * 
	 * @return A string of the AidData ID
	 */
	public String getId()
	{
		return this.id;
	}
	
	/**
	 * A get method that returns the year.
	 * 
	 * @return A string of the year
	 */
	public String getYear()
	{
		return this.year;
	}
	
	/**
	 * A get method that returns the donor country.
	 * 
	 * @return A string of the donor country
	 */
	public String getDonor()
	{
		return this.donor;
	}
	
	/**
	 * A get method that returns the recipient country.
	 * 
	 * @return A string of the recipient country
	 */
	public String getRecipient()
	{
		return this.recipient;
	}
	
	/**
	 * A get method that returns the donation amount.
	 * 
	 * @return A string of the donation amount
	 */
	public String getAmount()
	{
		return this.amount;
	}
	
	/**
	 * A get method that returns the purpose code.
	 * 
	 * @return A string of the purpose code
	 */
	public String getPurposeCode()
	{
		return this.purposeCode;
	}
	
	/**
	 * A get method that returns the purpose name.
	 * 
	 * @return A string of the purpose name
	 */
	public String getPurposeName()
	{
		return this.purposeName;
	}
	
	/**
	 * Formats a string number to be a currency
	 * 
	 * @param usd The string version of amount
	 * @return A String of the donation amount converted to currency form 
	 */
	public String currency(String usd)
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		Double currencyInt = Double.parseDouble(usd);
		return fmt.format(currencyInt).toString();
	
	}
	
	
	/**
	 *  Returns a string representation of the values in the AidDataRecord object.
	 *  
	 *  @return A String of all the values in the AidDataRecord object
	 */
	public String toString()
	{
		return "AidData ID: " + id + "\nYear: " + year + "\nDonor Country: " +
				donor + "\nRecipient Country: " + recipient + 
				"\nCommitment Amount in USD: " + currency(amount) + 
				"\nCoalesced Purpose Code: " + purposeCode + 
				"\nCoalesced Purpose Name: " + purposeName + "\n";
	}	
}
