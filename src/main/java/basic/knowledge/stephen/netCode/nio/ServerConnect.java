package basic.knowledge.stephen.netCode.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 1. 学校(ServerSocketChannel)
 2。 学校教务处（Selector）
 3。 老师 (ServerSocket )
 4。 学生 (SocketChannel)
 5。 员工号/学生号（SelectionKey）
 */
public class ServerConnect {
    private static final int BUF_SIZE=1024;
    private static final int PORT = 8080;
    private static final int TIMEOUT = 3000;


    private static final long PAUSE_BETWEEEN_MSGS = 10; // millisecs
    private static ByteBuffer echoBuffer = ByteBuffer.allocate(4);
    private static ByteBuffer sendBuffer = ByteBuffer.allocate(256);
    private static ConcurrentHashMap<Integer, SocketChannel> chm
            = new ConcurrentHashMap<Integer, SocketChannel>();
    private static int msg = 0;
    public static void main(String[] args)
    {
        selector();
    }
    public static void handleAccept(SelectionKey key) throws IOException {
        //先找到招生老师，再由招生老师找到新生，就可以给新生注册学号了
        //通过key把学校和老师找到了
        ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
        //从serverSocketChannel中创建出与客户端的连接socketChannel 有了老师才有学生，
        // 不可能我教计算机的，来一个想学李小龙的都让他报名
        SocketChannel sc = ssChannel.accept();//学生报名成功
        sc.configureBlocking(false);
        // 把新连接注册到选择器,新生被接收后给注册个新学号
        //注册学号成功，并分配学生的权限 OP_READ
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
    }
    public static void handleRead(SelectionKey key) throws IOException{
        // 读取数据 ，接受学生的问题
        SocketChannel sc = (SocketChannel)key.channel();
        ByteBuffer buf = (ByteBuffer)key.attachment();
        long bytesRead = sc.read(buf);
        while(bytesRead>0){
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        if(bytesRead == -1){
            sc.close();
        }
    }
    public static void handleWrite(SelectionKey key) throws IOException{
        ByteBuffer buf = (ByteBuffer)key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        buf.compact();
    }
    public static void selector() {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try{

            selector = Selector.open();
            //学校：相当于我们的网络应用程序，一旦学校启动，学校就不停止，不断运行，直到学期结束；
            //要启动学校就要：
            ssc= ServerSocketChannel.open();//新建NIO通道
            ssc.configureBlocking(false);//使通道为非阻塞

            //老师： 相当于服务端的Socket，一个老师对应多个学生，多个学生向老师请教，
            // 老师会一一做出回答。而学校要正常运营当然当不了老师，所以在开学之前，必须先聘请专业的老师来任教
            //新建socket通道的端口
            ssc.socket().bind(new InetSocketAddress(PORT));

            //学校教务处： 老师都有了，但是需要有部门对老师和学生做统一的管理，
            // 如果你去一个学校找一个人，实在是找不到，你可以告诉教务处，那个人是学生还是老师，
            // 是老师的话员工编号老师姓名的多少，是学生的话学号和姓名是多少，教务处就会找到告诉你他在哪里。
            //将NIO通道选绑定到择器,当然绑定后分配的主键为skey
            SelectionKey skey  = ssc.register(selector, SelectionKey.OP_ACCEPT);



            System.out.println("Going to listen on " + PORT);
            //ssc注册了选择器后，其下的老师ServerSocket就也入了员工册了。所以老师的编号就是skey
            //学生： 学校、老师、教务处都有了，现在就可以招生了

            //如果有学生来报名：
            while(true){ //除非学期结束，否则一直等待学生


               /* if(selector.select(TIMEOUT) == 0){
                    System.out.println("==");
                    continue;
                }*/

                //获取通道内关心事件的集合 ，这里的集合就是老师和学生的编号集合，
                // 如果key是学生的，那就是老学生来问问题，
                // 如果key是老师的，那就是招生办的老师带着一个新生来注册
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iter = selectionKeys.iterator();
                while(iter.hasNext()){//遍历每个key （学生key和老师key）
                    String msg = new String();
                    SelectionKey key = (SelectionKey) iter.next();//先得到这个学生的编号key

                    if(key.isAcceptable()){//这是招生老师的Key说明是新生注册，先找到招生老师，再由招生老师找到新生，就可以给新生注册学号了
                        ServerSocketChannel sscNew = (ServerSocketChannel) key
                                .channel();
                        SocketChannel sc = sscNew.accept();
                        sc.configureBlocking(false);
                        // Add the new connection to the selector //注册学号成功，并分配学生的权限
                        sc.register(selector, SelectionKey.OP_READ);
                        // Add the socket channel to the list
                        chm.put(sc.hashCode(), sc);
                        iter.remove();
                    }
                    //读客户端数据的事件,此时有客户端发数据过来,客户端事件 这是老学生来问问题了。
                    else if(key.isReadable())
                    {

                        // 读取数据 ，接受学生的问题  //通过学号知道是谁问的问题
                        SocketChannel sc = (SocketChannel) key.channel();
                        int code = 0;
                        while ((code = sc.read(echoBuffer)) > 0) {
                            byte b[] = new byte[echoBuffer.position()];
                            echoBuffer.flip();
                            echoBuffer.get(b);
                            msg+=new String(b, "UTF-8");
                        }
//                    if(msg.length()>1)
//                        msg = msg.substring(0, msg.length()-2);

                        //client关闭时，收到可读事件，code = -1
                        if (code == -1 ||
                                msg.toUpperCase().indexOf("BYE")>-1){
                            chm.remove(sc.hashCode());
                            sc.close();
                        } else {
                            //code=0，消息读完或者echoBuffer空间不够时，部分消息内容下一次select后收到
                            echoBuffer.clear();
                        }
                        System.out.println("msg: " + msg  + " from: " + sc + "code:  " + code );
                        iter.remove();

                        //注册可写通知
                        sc.register(selector,SelectionKey.OP_WRITE);
                    }else if(key.isWritable()){
                        SocketChannel client = (SocketChannel) key.channel();
                        String sendTxt = "Message from Server";
                        sendBuffer.put(sendTxt.getBytes());
                        sendBuffer.flip();
                        int code = 0;

                        //如果sendBuffer内容一次没有写完，会在下一次事件中处理吗？
                        while (client.write(sendBuffer) != 0){
                        }
                        if (code == -1 ){
                            chm.remove(client.hashCode());
                            client.close();
                        } else {
                            //code=0，消息写完
                            sendBuffer.clear();
                        }
                        iter.remove();
                        System.out.println("Send message to client ");

                        //在读通知里面注册为写事件，所以这里还需要注册为读，否则不在接受客户端消息
                        client.register(selector,SelectionKey.OP_READ);
                    }
                }
                Thread.sleep(5000);
            }
        }catch(IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            try{
                if(selector!=null){
                    selector.close();
                }
                if(ssc!=null){
                    ssc.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}
