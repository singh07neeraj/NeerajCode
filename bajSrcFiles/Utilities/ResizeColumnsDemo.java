package Utilities;
 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
 
public class ResizeColumnsDemo extends JPanel {
    public ResizeColumnsDemo() {
        super(new FlowLayout());
 
        String[] columnNames = {"First Name",
                                "Last Name",
                                "Sport",
                                "# of Years",
                                "Vegetarian"};
 
        Object[][] data = {
        {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
        {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
        {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
        {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
        {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
        };
 
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
 
        // automatically resize the columns whenever the data in the table changes
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
			public void tableChanged(TableModelEvent e) {
                ColumnsAutoSizer.sizeColumnsToFit(table);
            }
        });
 
        JButton autoSizeButton = new JButton("Auto-size columns");
 
        // resize the columns when the user clicks the button
        autoSizeButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                ColumnsAutoSizer.sizeColumnsToFit(table);
            }
        });
 
 
        JButton setLongNameButton = new JButton("Set longer name");
 
        // set a longer name to test automatic resizing after value changes
        setLongNameButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                table.getModel().setValueAt("Kathy Kathy Kathy", 0, 0);
            }
        });
 
        JButton setVeryLongNameButton = new JButton("Set very long name");
 
        // set a longer name to test automatic resizing after value changes
        setVeryLongNameButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                table.getModel().setValueAt("Kathy Kathy Kathy Kathy Kathy Kathy Kathy Kathy Kathy Kathy Kathy", 0, 0);
            }
        });
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
 
        add(autoSizeButton);
 
        add(setLongNameButton);
 
        add(setVeryLongNameButton);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        ResizeColumnsDemo newContentPane = new ResizeColumnsDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.setSize(600, 200);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                createAndShowGUI();
            }
        });
    }
}