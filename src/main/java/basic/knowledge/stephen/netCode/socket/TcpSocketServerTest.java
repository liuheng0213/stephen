package basic.knowledge.stephen.netCode.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSocketServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Socket s = ss.accept();
        InetAddress ip = s.getInetAddress();
        System.out.println(ip.getHostAddress());
        InputStream is = s.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        String sFromClient = new String(b, 0, len);
        System.out.println(new String(b, 0, len));

        //给客户端反馈
        OutputStream os = s.getOutputStream();
        String ret = "收到 : " + sFromClient;
        os.write(ret.getBytes());
        s.close();
    }

}
