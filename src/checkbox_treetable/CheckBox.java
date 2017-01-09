package checkbox_treetable;

import javax.swing.ImageIcon;

public class CheckBox {
	int state;

	static final ImageIcon emptyCheckBox = new ImageIcon("empty.png");
	static final ImageIcon halfCheckBox = new ImageIcon("half.png");
	static final ImageIcon fullCheckBox = new ImageIcon("full.png");

	public CheckBox(int state) {
		this.state = state;
	}
	
	public void changeState(){
		state++;
		state%=3;
	}

	public static ImageIcon getIcon(String name) {
		switch (name) {
			case "empty":
				return emptyCheckBox;
			case "half":
				return halfCheckBox;
			case "full":
				return fullCheckBox;
			default:
				return null;
		}
	}

	public int getState() {
		return state;
	}
}
