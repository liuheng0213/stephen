package basic.knowledge.stephen.netCode.rpcDemo;

public class ClientTest {
    public static void main(String[] args) {
        try {

            //服务调用者(客户端)只需要设置依赖
            AobingService serviceClinet = AobingRpcFramework.refer(AobingService.class, "127.0.0.1", 2333);
            String result = serviceClinet.hello("hello rpc framework");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
