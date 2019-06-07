package basic.knowledge.stephen.ThreadRelevant.application.copyTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这里用countdownlatch没必要,反而拖慢速度
 * 只是复制而已, countdownlatch 如果有需求是复制完后做什么事,那才有必要
 */
public class RandomFileCopyTest {


    public static void main(String[] args) throws Exception {
        //withoutMultiThreads();
        withMultiThread("D:" + File.separator + "test" + File.separator + "1.avi", "D:" + File.separator + "test" + File.separator + "2.avi", 20);//15个线程
    }

    private static void withMultiThread(String rPath, String tPath, int threadNum) throws Exception {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        File rFile = new File(rPath);
        File tFile = new File(tPath);
        RandomAccessFile rAccessFile = new RandomAccessFile(rFile, "r");

        long length = rAccessFile.length();

        long copySize =  length / threadNum;
        threadNum = (int) (length % threadNum) == 0 ? threadNum : threadNum + 1;

        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {//保证threadNum个线程
            executorService.execute(new MyThread(rFile, tFile, i,copySize, countDownLatch));//i * copySize * 1024  字节
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,耗时:" + (end - start));
        executorService.shutdown();
    }


    static class MyThread implements Runnable {
        private RandomAccessFile resourceFile;
        private RandomAccessFile targetFile;
        private long startPoint;
        private CountDownLatch countDownLatch;
        private long copySize;
        private int index;

        public MyThread(File rPath, File tPath, int index,long copySize, CountDownLatch countDownLatch) {
            try {
                this.resourceFile = new RandomAccessFile(rPath, "r");
                this.targetFile = new RandomAccessFile(tPath, "rw");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.index= index;
            this.countDownLatch = countDownLatch;
            this.copySize = copySize;
            this.startPoint = index*copySize*1024;
        }


        @Override
        public void run() {
            try {
                if(startPoint<0){
                    System.out.println(startPoint);
                }
                if (startPoint>=0) {
                    resourceFile.seek(startPoint);
                    targetFile.seek(startPoint);
                }
                byte[] by = new byte[1024];
                int len = 0;
                int maxSize = 0;
                while ((len = resourceFile.read(by)) != -1 && maxSize <= this.copySize) {
                    targetFile.write(by, 0, len);
                    maxSize++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    resourceFile.close();
                    targetFile.close();
                    countDownLatch.countDown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }


    private static void withoutMultiThreads() throws IOException {
        RandomAccessFile resourceFile = new RandomAccessFile(new File("D:" + File.separator + "test" + File.separator + "1.avi"), "r");
        RandomAccessFile targetFile = new RandomAccessFile(new File("D:" + File.separator + "test" + File.separator + "2.avi"), "rw");

        long start = System.currentTimeMillis();
        byte[] by = new byte[1024];
        int len = 0;
        while ((len = resourceFile.read(by)) != -1) {
            targetFile.write(by, 0, len);
        }
        resourceFile.close();
        targetFile.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
