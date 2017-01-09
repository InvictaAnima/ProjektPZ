import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class CheckBox extends JCheckBox implements Icon, ActionListener {

    public CheckBox() {
    	this(""); 
    }

    public CheckBox(String text) {
    	super(text);
    	putClientProperty("SelectionState", 0);
    	setIcon(this);
    	addActionListener(this);
    }

    public CheckBox(String text, int option) {
        //2-ptaszek 1-kropka 0-nic
        super(text, option > 1 ? true : false);

        if (option==2) setSelected (true);
        else if (option==1 || option==0) setSelected (false);
        else throw new IllegalArgumentException();
        
        addActionListener(this);
        setIcon(this);
    }

    @Override
    public boolean isSelected() {
        if (getSelectionState() > 0) return true;
        else return super.isSelected();
    }

    public int getSelectionState() {
    	if (getClientProperty("SelectionState") != null) return (int)getClientProperty("SelectionState");
    	else if (super.isSelected()==true) return 2;
    	else return 0;
    }

    public void setSelectionState(int option) {
        
        if (option==2) setSelected (true);
        else if (option==1 || option==0) setSelected (false);
        else throw new IllegalArgumentException();
        
        putClientProperty("SelectionState", option);
    }
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		CheckBox cb = (CheckBox)arg0.getSource();
        if (cb.getSelectionState() == 2) cb.setSelected(true);

        if (cb.getSelectionState() == 0) cb.putClientProperty("SelectionState",2);
        else cb.putClientProperty("SelectionState",cb.getSelectionState() - 1);
		
	}
	
	final static Icon icon = UIManager.getIcon("CheckBox.icon");

    @Override
    public int getIconWidth() {
        return icon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return icon.getIconHeight();
    }
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		icon.paintIcon(c, g, x, y);
        if (getSelectionState() != 1) return;

        int width = getIconWidth();
        int height = getIconHeight();
        g.setColor(Color.BLACK);
        g.fillRect(x+3, y+3, width-6, height-6);
		
	}
}
