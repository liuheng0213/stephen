package basic.knowledge.stephen.ThreadRelevant.application.copyTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
    public static void main(String[] args) throws IOException {
        File source = new File("D:" + File.separator + "test" + File.separator + "1.avi");
        File dir = new File("D:" + File.separator + "test" + File.separator + "2.avi");
        long n1 = System.currentTimeMillis();
        RandomAccessFile rAccessFile = new RandomAccessFile(source, "r");
        long item = rAccessFile.length()/4;

        for (int i = 0; i < 4; i++) {
            new ThreadCopy(source,dir,i*item,(i+1)*item).start();;
        }
        long n2 = System.currentTimeMillis();
        System.out.println(n2-n1);
    }
}

class ThreadCopy extends Thread {
    private File source;// 源文件
    private File target;// 目标文件
    private long start;// 当前线程开始位置
    private long end;// 当前线程结束位置


    public ThreadCopy(File source, File target, long start, long end) {
        super();
        this.source = source;
        this.target = target;
        this.start = start;
        this.end = end;
    }


    @Override
    public void run() {
        int count = 0;//统计当前线程拷贝的长度
        RandomAccessFile raf_read = null;
        RandomAccessFile raf_write = null;
        try {
            // 获取文件输入流
            raf_read = new RandomAccessFile(source, "r");
            // 获取文件输出流
            raf_write = new RandomAccessFile(target, "rw");
            //跳过需要读写字节数

            raf_read.seek(start);
            raf_write.seek(start);

            byte[] b = new byte[1024];
            int len = 0;
            while ((len = raf_read.read(b)) != -1 && count <= (end - start)) {
                // 记录当前拷贝的进
                count += len;
                raf_write.write(b, 0, len);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (raf_read != null) {
                    raf_read.close();
                }
                if (raf_write != null) {
                    raf_write.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


}
