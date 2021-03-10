package basic.knowledge.stephen.design_Pattern._01DesignPattern_Decorator.DecortorMode;

public class CarDecorator implements ICarShowable{
	private ICarShowable myCar;

	public CarDecorator(ICarShowable myCar) {
		this.myCar = myCar;
	}
	
	@Override
	public void show() {
		myCar.show();
	}
}
