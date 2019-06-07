package basic.knowledge.stephen.design_mode._01DesignMode_Decorator.DecortorMode;

public class MyCar implements ICarShowable{
	private String carName;

	public MyCar(String carName) {
		this.carName = carName;
	}

	@Override
	public void show() {
		System.out.println("裸车名:"+ carName);
	}
}
