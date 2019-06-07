package basic.knowledge.stephen.reflection._04_loadResource;

import java.io.InputStream;
import java.util.Properties;

public class LoadResourceDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//����Properties����
		Properties p = new Properties();
		//��ȡ�������
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//ͨ�����������ȡ����������: ���ļ����������
		InputStream inputStream = classLoader.getResourceAsStream("db.properties");
		//����
		p.load(inputStream);
		System.out.println(p);
	}

}
