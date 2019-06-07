package basic.knowledge.stephen.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {
    public static void main(String[] args) throws Exception {
        //普通写入
        //write();
        //writeUTF();

        testPointerLoc();
    }

    private static void writeUTF() throws IOException {
        RandomAccessFile ra = new RandomAccessFile("d:/data.txt", "rw");
        ra.seek(0);
        ra.write("小二月是个小傻瓜".getBytes());
        ra.seek(0);//有将指针设置为初始状态开始读
        System.out.println(new String(ra.readLine().getBytes("ISO-8859-1"),"utf-8"));//需要重新转码才能正常显示

        ra.close();
    }

    //如果没有用writeUTF写入数据,读的时候如果用readUTF会报错
    private static void write() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("d:/data.txt","rw");
        raf.write("hi,heng, hope you find a decent job\r\n".getBytes());
        raf.write("hi,heng, hope you find a decent job\r\n".getBytes());
        raf.write("hi,heng, hope you find a decent job\r\n".getBytes());
        raf.write("hi,heng, hope you find a decent job\r\n".getBytes());
        raf.write("hi,heng, hope you find a decent job\r\n".getBytes());
        raf.seek(raf.length());//跳到最后
        raf.write("\r\n".getBytes());
        raf.write("Ok".getBytes());
        raf.close();
    }

    private static void testPointerLoc() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("d:/data.txt","rw");
        System.out.println("随机流文件指针位置:"+raf.getFilePointer());
        byte b = raf.readByte();//读一个字节,指针后移1位
        System.out.println("随机流文件指针位置:"+raf.getFilePointer());
        raf.read();
        System.out.println("随机流文件指针位置:"+raf.getFilePointer());
        raf.skipBytes(12);//往前跳12个字节
        System.out.println("随机流文件指针位置:"+raf.getFilePointer());
        //raf.readInt();//往前跳4个字节
        System.out.println("随机流文件指针位置:"+raf.getFilePointer());
        raf.seek(1000);
        System.out.println("随机流文件指针位置:"+raf.getFilePointer());
        raf.close();
    }
}
