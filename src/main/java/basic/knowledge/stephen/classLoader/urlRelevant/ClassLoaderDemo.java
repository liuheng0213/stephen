package basic.knowledge.stephen.classLoader.urlRelevant;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoaderDemo cl = new ClassLoaderDemo();
        System.out.println(cl.getClass());
        System.out.println(cl.getClass().getClassLoader());
        System.out.println(cl.getClass().getClassLoader().getResource(""));//output:file:/D:/data%20structure%20and%20interviewTest/fundamental_plus_dataStructure/target/classes/
        System.out.println(cl.getClass().getClassLoader().getResource("/"));//null
    }
}
