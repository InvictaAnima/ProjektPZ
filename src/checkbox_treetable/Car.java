package checkbox_treetable;

public class Car {
	@ToDisplay
	private int size;
	@ToDisplay
	private String mark;
	@ToDisplay
	private double maxSpeed;

	public Car(int size, String mark, double maxSpeed) {
		super();
		this.size = size;
		this.mark = mark;
		this.maxSpeed = maxSpeed;
	}
}
