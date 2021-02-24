package basic.knowledge.stephen.netCode.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpSocketClientTest {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("127.0.0.1", 8080);
        String str = "客户端发送测试数据";
        OutputStream os = s.getOutputStream();
        os.write(str.getBytes());

        //接收服务器端反馈
        InputStream is = s.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b, 0, len));
        os.close();
        s.close();
    }

}
