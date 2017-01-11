package checkbox_treetable;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mvc.TreeTable;

public class MainFrame extends JFrame {
	
	Settings s = new Settings();
	XMLReader x = new XMLReader();
	
	//MenuBar menuBar = new MenuBar();
	
	TreeTable treeTable = new TreeTable();
	
	public MainFrame(){
		super("ProjektPZ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    treeTable.addData();
	    
	    //this.add(menuBar,BorderLayout.NORTH);
	    this.add(treeTable);
	    
	    
	    this.setSize(300, 150);
	    this.pack();
	    this.setVisible(true);
	}

}
