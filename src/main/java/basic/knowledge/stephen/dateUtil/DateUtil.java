package basic.knowledge.stephen.dateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * 日期工具类
 */
public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 日期运算
     *
     * @param date  源
     * @param part  操作部份
     * @param value 改变值
     * @return 计算后的日期
     */
    public static Date add(Date date, int part, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(part, value);
        return calendar.getTime();
    }

    /**
     * 取两个日期的差值
     *
     * @param from 开始时间
     * @param to   结束时间
     * @param part Calendar.SECOND--相关多少秒,Calendar.MINUTE--相关多少分,Calendar.HOUR_OF_DAY-时,other-天
     * @return 差值
     */
    public static long diff(Date from, Date to, int part) {
        if (to == null || from == null)
            return 0;
        long d = to.getTime() - from.getTime();
        switch (part) {
            case Calendar.SECOND:
                return d / 1000;
            case Calendar.MINUTE:
                return d / 1000 / 60;
            case Calendar.HOUR_OF_DAY:
                return d / 1000 / 60 / 60;
            default:
                return d / 1000 / 60 / 60 / 24;
        }

    }

    /**
     * 日期格式化函数,格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss", null);
    }

    /**
     * 日期格式化函数,缺省时区
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        return format(date, format, null);
    }

    /**
     * 日期格式化函数
     *
     * @param date
     * @param format
     * @param timeZone 时区如东八区GMT+8
     * @return
     */
    public static String format(Date date, String format, String timeZone) {
        if (date == null)
            return "";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        if (timeZone != null && !timeZone.trim().equals(""))
            formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
        return formatter.format(date);
    }

    /**
     * 字符转换为日期。
     *
     * @param source
     * @return
     */
    public static Date stringToDate(String source) {
        return stringToDate(source, "yyyy-MM-dd HH:mm:ss", null);
    }

    /**
     * 字符转换为日期。
     *
     * @param source
     * @param pattern 日期格式串如yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date stringToDate(String source, String pattern) {
        return stringToDate(source, pattern, null);
    }

    /**
     * 字符串转换为指定时区时间
     *
     * @param value
     * @param pattern  如yyyy-MM-dd HH:mm:ss
     * @param timeZone 如东八区GMT +8
     * @return
     */
    public static Date stringToDate(String value, String pattern, String timeZone) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        if (value == null)
            return date;
        if (timeZone != null && !timeZone.trim().equals(""))
            format.setTimeZone(TimeZone.getTimeZone(timeZone));
        try {
            date = format.parse(value);
        } catch (java.text.ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return date;
    }

    /**
     * 获取当前日期是一个星期的第几天
     * <br>星期天是0
     */
    public static int getDayOfWeek(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return w;
    }

    /**
     * 获取当前日期是星期几
     *
     * @return
     */
    public static String getWeekOfDate(Date time) {
        if (time == null)
            return "";
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return weekDays[getDayOfWeek(time)];
    }

    /**
     * 两个日期相差的天数，不算时分秒
     *
     * @param from 开始日期
     * @param to   结束日期
     * @return
     */
    public static int daysBetween(Date from, Date to) {
        Date fromL = stringToDate(format(from, "yyyy-MM-dd"), "yyyy-MM-dd");
        Date toL = stringToDate(format(to, "yyyy-MM-dd"), "yyyy-MM-dd");
        if (fromL != null && toL != null) {
            return (int) (toL.getTime() / (1000 * 24 * 60 * 60) - fromL.getTime() / (1000 * 24 * 60 * 60));
        } else {
            return 0;
        }
    }

    /**
     * 两个日期相差的天数，不算时分秒
     *
     * @param from 开始日期
     * @param to   结束日期
     * @return
     */
    public static int daysBetween(String from, String to) {
        Date fromL = stringToDate(from, "yyyy-MM-dd");
        Date toL = stringToDate(to, "yyyy-MM-dd");
        if (fromL != null && toL != null) {
            return (int) (toL.getTime() / (1000 * 24 * 60 * 60) - fromL.getTime() / (1000 * 24 * 60 * 60));
        } else {
            return 0;
        }
    }

    /**
     * 得到两日期相差几个月
     */
    public static int getMonthDiff(String startDate, String endDate) {
        Date startDate1 = stringToDate(startDate, "yyyy-MM-dd");
        Date endDate1 = stringToDate(endDate, "yyyy-MM-dd");
        return getMonthDiff(startDate1, endDate1);
    }

    /**
     * 得到两日期相差几个月
     */
    public static int getMonthDiff(Date startDate, Date endDate) {
        Calendar starCal = Calendar.getInstance();
        starCal.setTime(startDate);
        int sYear = starCal.get(Calendar.YEAR);
        int sMonth = starCal.get(Calendar.MONTH);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int eYear = endCal.get(Calendar.YEAR);
        int eMonth = endCal.get(Calendar.MONTH);

        return ((eYear - sYear) * 12 + (eMonth - sMonth));
    }

    /**
     * 获取当月最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);//把日期设置为当月第一天
        calendar.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        return calendar.getTime();
    }


    /**
     * 获取年份
     */
    public static String getYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
    }

    /**
     * 获取年份
     */
    public static String getMonth() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.MONTH));
        return year;
    }

    public static String timeStampToDateString(String timeStamp){
        String date=null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            Long time=new Long(timeStamp);
            date = format.format(time);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return date;
    }

    public static Date getTodayBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getTodayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取昨天的日期，不包含时间
     * @return
     */
    public static Date getYesterday() {
        LocalDate localDate = LocalDate.now();
        LocalDate yesterday = localDate.minusDays(1);
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = yesterday.atStartOfDay(zoneId).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取上个月的今天，如果没有则取上个月最后一天。
     * @param date
     * @return
     */
    public static Calendar getDateOfLastMonth(Calendar date) {
        Calendar lastDate = (Calendar) date.clone();
        lastDate.add(Calendar.MONTH, -1);
        return lastDate;
    }

    /**
     * 获取上个月的今天，如果没有则取上个月最后一天。
     * @param date
     * @return
     */
    public static Calendar getDateOfLastMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return getDateOfLastMonth(c);
    }

    /**
     * 获取上个月的今天，如果没有则取上个月最后一天。
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Calendar getDateOfLastMonth(String dateStr, String pattern) {
        Date date = stringToDate(dateStr, pattern);
        return getDateOfLastMonth(date);
    }

    /**
     * 获取上个月的今天，如果没有则取上个月最后一天。
     * @param date
     * @return
     */
    public static Calendar getDateOfLastMonth(String date) {
        return getDateOfLastMonth(date, "yyyy-MM-dd");
    }

    /**
     * 获取该时间所在月份的第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    /**
     * 获取某年某月的第一天
     * @param year
     * @param month
     * @param format
     * @return
     */
    public static String getFirstDayOfMonth (int year, int month, String format) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return format(cal.getTime(), format);
    }

    /**
     * localDate 转 date
     * @param localDate
     * @return
     */
    public static Date localDate2Date(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay(zoneId).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取时间所在的日期。
     * @param date
     * @return
     */
    public static Date getDateDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取上个月的第一天
     * @return
     */
    public static Date getLastMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取日期区间的月-日Map,包括起始和结束日期
     * @param start
     * @param end
     * @return
     */
    public static Map<String,Map<String,String>> getMonthDayMap(Date start, Date end){
        start = DateUtil.add(start, Calendar.DAY_OF_MONTH, -1);
        end = DateUtil.add(end, Calendar.DAY_OF_MONTH, +1);
        Map<String,Map<String,String>> monthDayMap = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        Map<String,String> dayMap = null;
        boolean bContinue = true;
        while (bContinue) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            if (end.after(cal.getTime())) {
                String month = DateUtil.format(cal.getTime(), "yyyy-MM");
                String day = DateUtil.format(cal.getTime(), "dd");
                boolean hasMonth = monthDayMap.containsKey(month);
                if(hasMonth){
                    dayMap = monthDayMap.get(month);
                }else {
                    dayMap = new HashMap<>();
                    monthDayMap.put(month,dayMap);
                }
                dayMap.put(day,day);
            } else {
                break;
            }
        }
        return monthDayMap;
    }


}

