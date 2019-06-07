package basic.knowledge.stephen.utilTest;

import basic.knowledge.stephen.dateUtil.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateUtilTest {
    @Test
    public void testDateBegin(){
        Date date = DateUtil.stringToDate("2018-10-31 16:06:09", "yyyy-MM-dd");
        Date dateDate = DateUtil.getDateDate(date);
        String format = DateUtil.format(dateDate);
        System.out.println(format);
    }
}
