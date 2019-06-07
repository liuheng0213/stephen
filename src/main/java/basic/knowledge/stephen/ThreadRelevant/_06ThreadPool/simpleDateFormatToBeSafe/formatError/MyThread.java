package basic.knowledge.stephen.ThreadRelevant._06ThreadPool.simpleDateFormatToBeSafe.formatError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread{
    private SimpleDateFormat sdf;
    private String dateString;

    public MyThread(SimpleDateFormat sdf, String dateString) {
        this.sdf = sdf;
        this.dateString = dateString;
    }


    @Override
    public void run() {
        try {
            Date dateRef = sdf.parse(dateString);
            String newDateString = sdf.format(dateRef).toString();
            if(!newDateString.equals(dateString)){
                System.out.println("ThreadName="+this.getName()+"报错了日期字符串:"+ dateString + "转换成日期为:" + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
