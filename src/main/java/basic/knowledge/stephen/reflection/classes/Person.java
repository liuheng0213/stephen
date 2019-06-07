package basic.knowledge.stephen.reflection.classes;

import java.util.Arrays;

public class Person {
	private String name;
	private int age;
	private int id;
	/**
	 * 
	 */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 */
	protected Person(String name) {
		super();
		this.name = name;
	}
	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	/**
	 * @param name
	 * @param age
	 * @param id
	 */
	protected Person(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	public void show1(){
		System.out.println("i am show1 ");
	}
	
	void show2(int x){
		System.out.println("i am show2 ");
	}
	
	private void show3(int x, String str1){
		System.out.println("i am show3,i have two vars which are  "+ x + ",and "+ str1);
	}
	
	private static String show4(String str2) {
		return "i m static show4" + str2;
	}
	
	private static String transmitArrayVars1(int...arr) {
		return "transmitArrayVas1 is just for transmitting Array" + Arrays.toString(arr);
	}
	
	protected String transmitArrayVars2(String[] arr1, int[] arr2){
		StringBuilder sb= new StringBuilder(15);
		sb.append("i am transmitArrayVars2 ,...");
		for (String str : arr1) {
			sb.append(str);
		}
		
		for (int i : arr2) {
			sb.append(i);
		}
		
		return sb.toString();
	}
}
