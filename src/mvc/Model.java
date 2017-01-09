package mvc;

import java.util.ArrayList;

import checkbox_treetable.Car;
import checkbox_treetable.Node;
import checkbox_treetable.Settings;

public class Model {
	private Object[][] rowData;
	private Object columnNames[];
	
	ArrayList <Node> nodes;
	
	public Model(){
		int columns;
		int rows;
		
		nodes = new ArrayList<>();
		nodes.add(new Node<Car>(new Car(5,"Audi",42.4)));		
		nodes.add(new Node<Car>(new Car(9,"Fiat",42224)));
		nodes.add(new Node<Car>(new Car(2,"Skoda",42123.4)));		
		nodes.add(new Node<Car>(new Car(6,"Mazda",11164)));
		nodes.add(new Node<Car>(new Car(1,"Toyota",7777.4)));		
		nodes.add(new Node<Car>(new Car(3,"Suzuki",421)));
		nodes.add(new Node<Car>(new Car(0,"Seat",866.4)));		
				
		nodes.get(0).checkIfNodeContainsValuesToDisplay();
		Settings.clearVariablesToDisplay();
		
		rows = nodes.size();
		columns = Settings.getVariablesToDisplaySize();
		
		Object[][] tmp = new Object[rows][columns+1];
		
		Node tmpNode;
		for(int i=0;i<nodes.size();i++){
			tmpNode = nodes.get(i);
			
			for(int j=0 ; j<tmpNode.getDataToDisplaySize();j++){
				tmp[i][j+1] = tmpNode.getData(j);
			}
		}
		
		rowData = tmp;
		
		Object[] tmp2 = new Object[columns+1];				
		tmp2[0] = "";				
		for(int i=0; i<columns; i++){
			tmp2[i+1] = Settings.getVariableToDisplay(i);
		}
		
		columnNames = tmp2;
		
	}
	
//	public void fillWithDataFromList(){
//		List<String> tokens = new ArrayList<String>();
//		rowData = new Object[10][3];
//		
//		for(int i=0;i<20;i++){
//			 tokens.add("test");
//		}
//		
//		for(int i=0;i<20;i++){
//			rowData[i%10][i%3] = tokens.get(i);
//		}
//	}

	public Object[][] getRowData() {
		return rowData;
	}

	public Object[] getColumnNames() {
		return columnNames;
	}
}
