package basic.knowledge.stephen.utilTest;

import basic.knowledge.stephen.dateUtil.DateUtil;
import org.junit.Test;

import java.util.Date;

public class DateUtilTest {
    @Test
    public void testDateBegin() {
     /*   Date date = DateUtil.stringToDate("2018-10-31 16:06:09", "yyyy-MM-dd");
        Date dateDate = DateUtil.getDateDate(date);
        String format = DateUtil.format(dateDate);
        System.out.println(format);*/
        Date date = DateUtil.stringToDate("2019/03/04", "yyyy/MM/dd");
        System.out.println(date);
    }

    @Test
    public void test1() {
        // 39  12  28  15  42  44   6  25  －  －   36   －   38
        System.out.println(54 % 7);
        System.out.println(12 % 13);
        System.out.println(28 % 13);
        System.out.println(15 % 13);
        System.out.println(42 % 13);
        System.out.println(44 % 13);
        System.out.println(6 % 13);
        System.out.println(25 % 13);
        System.out.println(36 % 13);
        System.out.println(38 % 13);
    }
}
