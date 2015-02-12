package com.schappell.reader;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * The purpose of this class is to create a custom table 
 * that can use the objects in the given list
 * 
 * @author Scott Chappell
 *
 */
public class FinalTableModel extends AbstractTableModel 
{

    private List<AidDataRecord> dataList;	// List of AidDataRecord objects
    
    // Column names for the table
    private String[] columnNames = { "Aid Data ID", "Year", "Donor",
                "Recpient", "Amount", "Purpose Code", "Purpose Name"};

    /**
     * A constructor that sets the list of AidDataRecord objects
     * 
     * @param list A list of AidDataRecord objects
     */
    public FinalTableModel(List<AidDataRecord> list)
    {
         this.dataList = list;
    }

    /**
     * Gets the column name of the table
     * 
     * @param columnIndex The number of the column
     * @return A string of the column name
     */
    @Override
    public String getColumnName(int columnIndex)
    {
         return columnNames[columnIndex];
    }
    
    /**
     * Gets the number of rows to be in the table
     * 
     * @return An int of the number of objects in the list (one for each row)
     */
    @Override
    public int getRowCount() 
    {
        return dataList.size();
    }

    /**
     * Gets the number of columns to be in the table
     * 
     * @return An int of the number of columns the table will have
     */       
    public int getColumnCount() {
        return 7; 
    }
    
    /**
     * Determines if each cell is editable
     * 
     * @param row Row number
     * @param col Column number
     * @return Boolean to determine if the cell is editable
     */
    public boolean isCellEditable(int row, int col) 
    {
		return false;	
	}

    /**
     * Returns objects at given row and column
     * 
     * @param rowIndex Row number
     * @param columnIndex Column number
     * @return Object that contains AidData information
     */
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
    	AidDataRecord list = dataList.get(rowIndex);
        switch (columnIndex) 
        {
            case 0: 
                return list.getId();
            case 1:
                return list.getYear();
            case 2:
                return list.getDonor();
            case 3:
                return list.getRecipient();
            case 4:
                return list.getAmount();
            case 5:
                return list.getPurposeCode();
            case 6:
                return list.getPurposeName(); 
           }
           return null;
   }

 }
