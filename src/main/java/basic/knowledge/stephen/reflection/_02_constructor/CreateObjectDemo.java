package basic.knowledge.stephen.reflection._02_constructor;



import basic.knowledge.stephen.reflection.entity.Person;

import java.lang.reflect.Constructor;


public class CreateObjectDemo {
	public static void main(String[] args) throws Exception {
		Class<Person> clz = (Class<Person>) Class.forName("Cooper.reflection.classes.Person");
		Constructor<Person> con = clz.getDeclaredConstructor(String.class,int.class,int.class);
		con.setAccessible(true);
		Person p1 = con.newInstance("gg",25,1);
		Person p2 = clz.newInstance();
		con = clz.getDeclaredConstructor(String.class,int.class);
		Person p3 = con.newInstance("AA",22);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}
