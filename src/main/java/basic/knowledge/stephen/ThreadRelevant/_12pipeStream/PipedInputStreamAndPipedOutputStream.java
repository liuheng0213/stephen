package basic.knowledge.stephen.ThreadRelevant._12pipeStream;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 掩饰管道字节流
 */
class Send implements Runnable{
    private PipedOutputStream pos = null;

    public Send(){
        this.pos = new PipedOutputStream();     //实例化管道输出流
    }
    @Override
    public void run() {
        String str = "zhejianggongshangdaxue";
        try {
            this.pos.write(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.pos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public PipedOutputStream getPos(){   //通过线程类获得管道输出流
        return pos;
    }
}
class Receive implements Runnable{

    private PipedInputStream pis = null;
    public Receive(){
        this.pis = new PipedInputStream();   //实例化管道输入流
    }
    @Override
    public void run() {
        byte b[]=new byte[1024];
        int len= 0;
        try {
            len = this.pis.read(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("接收内容："+new String(b,0,len));
    }
    public PipedInputStream getPis(){         //通过线程类获得管道输入流
        return pis;
    }

}
public class PipedInputStreamAndPipedOutputStream {
    public static void main(String[] args) {
        Send s = new Send();
        Receive r = new Receive();

        try {
            s.getPos().connect(r.getPis());   //连接两个线程的管道流

        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(s).start();
        new Thread(r).start();
    }

}