package mvc;

import javax.swing.JComponent;
import javax.swing.UIManager;

public class TreeTable extends JComponent{
	
	private TreeTableModel model;
	
	public void setUI(TreeTableUI ui) {
		super.setUI(ui);
	}

	public void updateUI() {
		if (UIManager.get(getUIClassID()) != null) {
			setUI((TreeTableUI) UIManager.getUI(this));
		} else {
			setUI(new TreeTableUI());
		}
	}

	public TreeTableUI getUI() {
		return (TreeTableUI) ui;
	}

	public String getUIClassID() {
		return TreeTableUI.UI_CLASS_ID;
	}
	
	public TreeTable(){
		this.model = new TreeTableModel();
		this.updateUI();
	}
	
	public void addData(){
		this.model.addData();
	}
	
	public TreeTableModel getModel(){
		return this.model;
	}
	
}
