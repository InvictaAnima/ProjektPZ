package checkbox_treetable;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	
	public MenuBar(){
		super();
		createComponents();
	}
	
	private void createComponents(){
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Nodes");
		
		JMenu exportMenu = new JMenu("Export...");
		exportMenu.setIcon(createIcon("/images/Export24.gif"));
		JMenu importMenu = new JMenu("Import...");
		importMenu.setIcon(createIcon("/images/Import24.gif"));
		
		//FIlE MENU
		JMenuItem exportJson = new JMenuItem("json");
		JMenuItem exportXml = new JMenuItem("xml");
		JMenuItem importJson = new JMenuItem("json");
		JMenuItem importXml = new JMenuItem("xml");
		
		//EDIT MENU
		JMenuItem addItem = new JMenuItem("Add");
		addItem.setIcon(createIcon("/images/Add24.gif"));
		JMenuItem editItem = new JMenuItem("Edit");
		editItem.setIcon(createIcon("/images/Edit24.gif"));
		JMenuItem removeItem = new JMenuItem("Remove");
		removeItem.setIcon(createIcon("/images/Delete24.gif"));
		JMenuItem refreshItem = new JMenuItem("Refresh");
		refreshItem.setIcon(createIcon("/images/Refresh24.gif"));
		
		fileMenu.add(exportMenu);
		fileMenu.addSeparator();
		fileMenu.add(importMenu);
		
		exportMenu.add(exportJson);
		exportJson.setIcon(createIcon("/images/json_icon.png"));
		exportMenu.add(exportXml);
		exportXml.setIcon(createIcon("/images/xml_icon.png"));
		
		importMenu.add(importJson);
		importJson.setIcon(createIcon("/images/json_icon.png"));
		importMenu.add(importXml);
		importXml.setIcon(createIcon("/images/xml_icon.png"));
		
		editMenu.add(addItem);
		editMenu.add(editItem);
		editMenu.add(removeItem);
		editMenu.add(refreshItem);
		
		
		this.add(fileMenu);
		this.add(editMenu);
	}
	
	private ImageIcon createIcon(String path) {

		URL url = getClass().getResource(path);

		if (url == null) {
			System.err.println("Unable to load image: " + path);
		}

		ImageIcon icon = new ImageIcon(url);
		return icon;
	}
	

}
