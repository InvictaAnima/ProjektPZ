package mvc;


import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.TableCellRenderer;

public class View extends JScrollPane {

	private static final long serialVersionUID = 1L;

	JTable table;

	public View() {

	}

	public void setData(Object[][] rowData, Object[] columnNames) {
		table = new JTable(rowData, columnNames);		
		table.getColumnModel().getColumn(0).setCellRenderer(new ClientsTableButtonRenderer());
		table.getColumnModel().getColumn(0).setCellEditor(new ClientsTableRenderer(new JCheckBox()));
		
		this.setViewportView(table);
	}
}

///

class ClientsTableButtonRenderer extends JLabel implements TableCellRenderer {
	
	private static final long serialVersionUID = 1L;

	public ClientsTableButtonRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		return this;
	}

}

class ClientsTableRenderer extends DefaultCellEditor {
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JLabel jLabel;
	private String text;
	private int row, column;
	private boolean clicked;
	
	

	public ClientsTableRenderer(JCheckBox checkBox) {
		super(checkBox);
		jLabel = new JLabel();
		jLabel.setOpaque(true);
		jLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				fireEditingStopped();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.table = table;
		this.row = row;
		this.column = column;

		text = "";		
		clicked = true;
		return jLabel;
	}

	public Object getCellEditorValue() {
		if (clicked) {
			JOptionPane.showMessageDialog(jLabel, "Klikni�to wiersz z warto�ci�: " + table.getValueAt(row, 1));
		}
		clicked = false;
		return new String(text);
	}

	public boolean stopCellEditing() {
		clicked = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}
