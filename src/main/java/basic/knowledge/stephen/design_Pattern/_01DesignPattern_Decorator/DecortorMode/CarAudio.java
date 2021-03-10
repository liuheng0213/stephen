package basic.knowledge.stephen.design_Pattern._01DesignPattern_Decorator.DecortorMode;

public class CarAudio extends CarDecorator {
	//cause CarAudio implements ICarShowable ,new CarAudio can be seen as ICarShowable
	public CarAudio(ICarShowable myCar) {
		super(myCar);
	}

	@Override
	public void show() {
		super.show();
		System.out.println("audio added");
	}
}
