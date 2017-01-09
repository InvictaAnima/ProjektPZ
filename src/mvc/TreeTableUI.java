package mvc;


import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.table.TableCellRenderer;

import checkbox_treetable.CheckBox;

public class TreeTableUI extends ComponentUI {

	public static final String UI_CLASS_ID = "TreeTableUI";

	private JTable table;
	private TreeTable treeTable;
	private JScrollPane scrollPane;
	private ChangeListener changeListener;

	public static ComponentUI createUI(JComponent c) {
		return new TreeTableUI();
	}

	public void installUI(JComponent c) {
		this.treeTable = (TreeTable) c;
		installComponents();
		installListeners();
		c.setLayout(new FlowLayout());
	}

	public void uninstallUI(JComponent c) {
		c.setLayout(null);
		uninstallListeners();
		uninstallComponents();
		this.treeTable = null;
	}

	protected void installComponents() {
		scrollPane = new JScrollPane();
		this.treeTable.add(scrollPane);
	}

	protected void installListeners() {
		changeListener = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				TreeTableModel model = (TreeTableModel) arg0.getSource();
				setData(model.getRowData(), model.getColumnNames());
				treeTable.repaint();
			}
		};
		this.treeTable.getModel().addChangeListener(changeListener);
	}

	protected void uninstallComponents() {
		scrollPane = null;
	}

	protected void uninstallListeners() {
		this.treeTable.getModel().removeChangeListener(changeListener);
		changeListener = null;
	}

	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
	}

	public void setData(Object[][] rowData, Object[] columnNames) {
		table = new JTable(rowData, columnNames);	
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);	
		table.getColumnModel().getColumn(0).setCellRenderer(new CheckBoxRenderer());
		table.getColumnModel().getColumn(0).setCellEditor(new CheckBoxEditor(new JCheckBox()));
		
		
		scrollPane.setViewportView(table);
	}
}

///

class CheckBoxRenderer extends JLabel implements TableCellRenderer {
	
	private static final long serialVersionUID = 1L;

	public CheckBoxRenderer() {
		super.setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		CheckBox c = (CheckBox) value;
		if (c.getState() == 0) {
			this.setIcon(CheckBox.getIcon("empty"));
		} else if (c.getState() == 1) {
			this.setIcon(CheckBox.getIcon("half"));
		} else if (c.getState() == 2) {
			this.setIcon(CheckBox.getIcon("full"));
		}

		return this;
	}

}

class CheckBoxEditor extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;
	private CheckBox c;	
			
	public CheckBoxEditor(JCheckBox checkBox) {
		super(checkBox);
		checkBox.setOpaque(true);		
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		c = (CheckBox) value;		
		return this.getComponent();
	}

	public Object getCellEditorValue() {
		c.changeState();		
		return c;
	}	
}
