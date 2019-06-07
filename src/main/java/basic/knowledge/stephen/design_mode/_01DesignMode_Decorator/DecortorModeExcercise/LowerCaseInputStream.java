package basic.knowledge.stephen.design_mode._01DesignMode_Decorator.DecortorModeExcercise;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream{

	//InputStream is like MyCar;FilterInputStream is like Decorator; cloneable is like ICarshowable
	protected LowerCaseInputStream(InputStream in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return super.read();
	}

	@Override
	public int read(byte[] b) throws IOException {
		// TODO Auto-generated method stub
		int c =  super.read(b);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte)Character.toLowerCase((char)b[i]);
		}
		return c;
	}
}
