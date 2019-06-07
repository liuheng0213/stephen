package basic.knowledge.stephen.ThreadRelevant._06ThreadPool.simpleDateFormatToBeSafe.formatError;

import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] datsStrings = new String[]{"2001-01-01","2001-01-02","2001-01-03"
                ,"2001-01-04","2001-01-05","2001-01-06","2001-01-07","2001-01-08","2001-01-09","2001-01-10"};
        MyThread[] myThreads = new MyThread[10];
        for(int i = 0;i<10;i++){
            myThreads[i]= new MyThread(sdf,datsStrings[i]);
        }
        for(int i = 0;i<10;i++){
            myThreads[i].start();
        }
    }
}

