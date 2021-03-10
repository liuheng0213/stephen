package basic.knowledge.stephen.design_Pattern._01DesignPattern_Decorator.DecortorModeExcercise;

import java.io.FileInputStream;
import java.io.InputStream;

public class LowerCaseDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InputStream in = new LowerCaseInputStream(new FileInputStream("file/123.txt"));
		
		byte[] buffer = new byte[5];
		int len = -1;
		while ((len=in.read(buffer))!=-1) {
			System.out.print(new String(buffer,0,len));
		}
		
		in.close();
	}
	
}
