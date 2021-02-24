package basic.knowledge.stephen.netCode.rpcDemo;

public class ServerTest {
    public static void main(String[] args) {
//        while(true){
//            System.out.println(2);
//        }
        try {
            //服务提供者(服务端)只需要暴露出接口
            AobingService serviceServer = new AobingServiceImpl();
            AobingRpcFramework.export(serviceServer, 2333);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
