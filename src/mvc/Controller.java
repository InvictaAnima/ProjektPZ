package mvc;

public class Controller {
	private View view;
	private Model model;
	
	public Controller(View view,Model model){
		this.view = view;
		this.model = model;
		
		updateViewData();
	}
	
	public void updateViewData(){
		view.setData(model.getRowData(),model.getColumnNames());
	}
	
}
