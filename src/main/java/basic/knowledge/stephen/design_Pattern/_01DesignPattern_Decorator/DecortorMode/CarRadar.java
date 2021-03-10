package basic.knowledge.stephen.design_Pattern._01DesignPattern_Decorator.DecortorMode;

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
