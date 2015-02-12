package com.schappell.reader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



/**
 * 
 * @author Scott
 *
 */
public class CSVReaderGUI extends JPanel 
{
	private JTable table;				// A table that will hold AidData records
	private JTextArea output;			// Used for displaying selected row data
	private List<AidDataRecord> list;   // List of records

	
	/**
	 * A constructor that sets the values for the GUI
	 *  
	 */
	public CSVReaderGUI() 
	{
		super();
		final int rows = 20; 	// Number of rows to cycle
		
		// Creates a new list of AidData objects
		list = new CSVFileReader().readFile();	
		
		// UI will be empty if the list is null
		if(list != null)
		{
			// Uses BoxLayout to stack elements of the GUI
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			// Creates a table and populates it with the objects in the list
			table = new JTable(new FinalTableModel(list));
			
			// Creates a scroll pane so the table can paginate
			final JScrollPane scrollPane = new JScrollPane(table,
	                JScrollPane.VERTICAL_SCROLLBAR_NEVER, 
	                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			// Size of the table
			Dimension d = table.getPreferredSize();
			
			// Sets the scroll view to show 20 rows
			scrollPane.setPreferredSize(new Dimension(d.width,342)); 
			
			// Prevents scroll pane from showing more than 20 rows
			scrollPane.setMaximumSize(new Dimension(d.width,342));
			
			// Creates row listener for when user clicks a row
			table.getSelectionModel().addListSelectionListener(new RowListener());
			
			// Hides column one, five, six, and seven
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(4).setMinWidth(0);
			table.getColumnModel().getColumn(4).setMaxWidth(0);
			table.getColumnModel().getColumn(5).setMinWidth(0);
			table.getColumnModel().getColumn(5).setMaxWidth(0);
			table.getColumnModel().getColumn(6).setMinWidth(0);
			table.getColumnModel().getColumn(6).setMaxWidth(0);
			
			// Allows rows to be selected
			table.setRowSelectionAllowed(true);
			
			// Only allows one row to be selected at a time
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			// Adds the scroll pane
			add(scrollPane);

			// Creates a new Jpanel for the navigation buttons
			JPanel navigation = new JPanel(new FlowLayout(FlowLayout.CENTER));
			
			// Forward Button
	        JButton next = new JButton(">");
	        next.addActionListener( new ActionListener()
	        {
	        	// Scrolls Forwards the distance of 20 rows
	        	public void actionPerformed(ActionEvent ae) 
	            {
	                int height = table.getRowHeight()*(rows);
	                JScrollBar bar = scrollPane.getVerticalScrollBar();
	                bar.setValue( bar.getValue()+height );
	            }
	        });
	        
	        // Back Button
	        JButton previous = new JButton("<");
	        previous.addActionListener( new ActionListener()
	        {
	        	// Scrolls backwards the distance of 20 rows
	        	public void actionPerformed(ActionEvent ae) 
	            {
	                int height = table.getRowHeight()*(rows);
	                JScrollBar bar = scrollPane.getVerticalScrollBar();
	                bar.setValue( bar.getValue()-height );
	            }
	        });
	            
	        // Adds the navigation buttons
	        navigation.add(previous);
	        navigation.add(next);

	        // Adds the navigation panel and the scroll pane
	        add(scrollPane, BorderLayout.CENTER);
	        add(navigation, BorderLayout.SOUTH);

	        // Creates a text area where record data is
	        // displated when a row is clicked
	        output = new JTextArea(10,0);
	        output.setEditable(false);
	        add(new JScrollPane(output));
		}	
	}

	/**
	 * Finds which row is selected and returns a string representation  
	 * of that object
	 * 
	 * @return A string that represents the data object from a selected row
	 */
	private String rowSelectionOutput() 
	{
		String rowOutput = null;
		for (int c : table.getSelectedRows()) 
		{
			rowOutput = list.get(c).toString();
        }
		return rowOutput;
	}

	/**
	 * Checks if a row is selected
	 */
	private class RowListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event)
		{	
			// Outputs the correct string for the corresponding row
			output.setText(rowSelectionOutput());
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Disable boldface controls.
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		// Create and set up the window.
		JFrame frame = new JFrame("CSV Reader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		CSVReaderGUI newContentPane = new CSVReaderGUI();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
