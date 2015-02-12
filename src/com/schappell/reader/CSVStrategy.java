package com.schappell.reader;

/**
 * The purpose of this class is to store the
 * CSV strategy variables (defined as the JCSV parsing rules)
 * 
 * @author Scott Chappell
 *
 */
public class CSVStrategy 
{
	private char delimiter;			// The delimiter character to use
	private char quoteCharacter;	// The quote character to use
	private char commentIndicator;  // The comment indicator to use
	private boolean noSkip;         // Skip first line
	private boolean ignoreEmpty;    // Ignore empty spaces
	
	/**
	 * A constructor that sets the values of the CSVStrategy object
	 * 
	 * @param delimiter The delimiter character to use
	 * @param quoteCharacter The quote character to use
	 * @param commentIndicator The comment indicator to use
	 * @param noSkip boolean to Skip first line
	 * @param ignoreEmpty boolean to Ignore empty spaces
	 */
	public CSVStrategy(char delimiter, char quoteCharacter, 
			char commentIndicator, boolean noSkip, boolean ignoreEmpty)
	{
		this.delimiter = delimiter;
		this.quoteCharacter = quoteCharacter;
		this.commentIndicator = commentIndicator;
		this.noSkip = noSkip;
		this.ignoreEmpty = ignoreEmpty;
	}
}
