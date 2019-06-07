package basic.knowledge.stephen.DateAndCalendar;

import java.util.Calendar;

public class DateTimeTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.DATE));
        System.out.println(instance.get(Calendar.MONTH)+1);
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));

        System.out.println("-------------------------");
        System.out.println(instance.getTimeInMillis());
        System.out.println(instance.getTime());     // got a Date
        System.out.println(System.currentTimeMillis());

        //get yesterdays's current time
        instance.add(Calendar.DATE,-1);
        System.out.println(instance.getTime());

    }


}
