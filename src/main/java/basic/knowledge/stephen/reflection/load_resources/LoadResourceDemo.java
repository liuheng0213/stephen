package basic.knowledge.stephen.reflection.load_resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadResourceDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//��ʽһ: ʹ�þ���·���ķ�ʽ����,����properties��,ֻ��ʹ��properties��load����
		//test1();
		
		//��ʽ��: ���·��: �����classpath�ĸ�·��,binĿ¼,�ֽ������Ŀ¼
		test2();			//����õ����
		
		//��ʽ�� ���·��: ����ڵ�ǰ������Դ�ļ����ֽ���·��
		//test3();
	}

	private static void test3() throws Exception {
		// TODO Auto-generated method stub
		
		Properties p = new Properties();
		InputStream is = LoadResourceDemo.class.getResourceAsStream("db.properties");
		//������ôд�����лᱨ��,��Ϊ�����ȥLoadResourceDemo.class���ڵĵ�ǰ·����db.properties
		//���Ҫ��db.properties����oadResourceDemo.class���ڵ��ļ���
		p.load(is);
		System.out.println(p);
	}

	private static void test2() throws Exception {
		// TODO Auto-generated method stub
		//��ʱ��Ҫʹ��ClassLoader(�������),��Ϊ�������Ĭ�ϴ�classpathѰ���ļ�
		Properties p = new Properties();
		//ClassLoader loader = LoadResourceDemo.class.getClassLoader();
		//Ҳ����ͨ���߳����õ�ClassLoader����
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream("db.properties");	//ȥbin·���ҵ���Ҫ���ص��ļ�,Ҳ����sources�ļ�����
		p.load(is);
		System.out.println(p);
	}
     
	private static void test1() throws Exception {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		InputStream is = new FileInputStream("D:/С����Ͽμ�¼/������/��������ҵ/all from" +
				" eclipse/day29-reflection/Sources/db.properties");
		p.load(is);
		System.out.println(p);
		/*
		 * ������������,�����ڱ��˵�����, ���˵�����d��? ���Ͽμ�¼��?
		 * ��������·��,Ҳ����,��Ϊ��������Ŀֻ���ֽ���, ����db.properties
		 * */
	}
}
