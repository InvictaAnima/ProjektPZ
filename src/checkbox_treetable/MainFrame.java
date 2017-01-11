package checkbox_treetable;

import java.awt.Dimension;

import javax.swing.JFrame;

import mvc.TreeTable;

public class MainFrame extends JFrame {
	
	Settings s = new Settings();
	XMLReader x = new XMLReader();
	
	TreeTable treeTable = new TreeTable();
	
	public MainFrame(){
		super("ProjektPZ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    treeTable.addData();
	    this.add(treeTable);
	    this.setMinimumSize(new Dimension(470,470));
	    this.pack();
	    this.setVisible(true);
	}

}
