package basic.knowledge.stephen.design_mode._01DesignMode_Decorator.DecortorMode;

public class DecorateDemo {
	public static void main(String[] args) {
		ICarShowable car1 = new CarAudio(new CarRadar(new MyCar("我的宝马车")));
		car1.show();
		System.out.println("------------------");
		ICarShowable car2 = new CarRadar(new MyCar("我的宝马车"));
		car2.show();
		System.out.println("-------------------");
		ICarShowable car3 = new CarABS(new CarAudio(new CarRadar(new MyCar("我的宝马车"))));
		car3.show();
	}
}
