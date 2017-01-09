package checkbox_treetable;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mvc.Controller;
import mvc.Model;
import mvc.View;

public class Main {
	Settings s = new Settings();
	XMLReader x = new XMLReader();
	View view = new View();
	Model model = new Model();	
	
	Controller controller = new Controller(view, model);
	
	public Main(){			
		JFrame frame = new JFrame("ProjektPZ");	
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(view, BorderLayout.CENTER);
	    frame.setSize(300, 150);
	    frame.pack();
	    frame.setVisible(true);
	    
	}
	
	public static void main(String[] args) {
		new Main();    
		
	}
}