package checkbox_treetable;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mvc.TreeTable;

public class Main {
	Settings s = new Settings();
	XMLReader x = new XMLReader();
	
	TreeTable treeTable = new TreeTable();
	
	public Main(){			
		JFrame frame = new JFrame("ProjektPZ");	
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    treeTable.addData();
	    frame.add(treeTable, BorderLayout.CENTER);
	    frame.setSize(300, 150);
	    frame.pack();
	    frame.setVisible(true);
	    
	}
	
	public static void main(String[] args) {
		new Main();    
		
	}
}