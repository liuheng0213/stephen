package basic.knowledge.stephen.design_mode._01DesignMode_Decorator.DecortorMode;

public class CarRadar extends CarDecorator{
	public CarRadar(ICarShowable myCar) {
		super(myCar);
	}

	@Override
	public void show() {
		super.show();
		System.out.println("radar added");
	}
}
