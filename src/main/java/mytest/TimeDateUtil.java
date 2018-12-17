package mytest;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 公用日期操作类
 */
public class TimeDateUtil {
    public static SimpleDateFormat sdfYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdfCHINESEYYYYMMDD = new SimpleDateFormat("yyyy年MM月dd日");
    public static SimpleDateFormat sdfSLASHYYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");
    public static SimpleDateFormat sdfYYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat sdfYYYYMDD = new SimpleDateFormat("yyyy-M-dd");
    /** 年 */
    private int intYear;

    /** 月 */
    private int intMonth;

    /** 日 */
    private int intDay;

    /** 天数 */
    private int intDayNum;

    /** 小时数 */
    private int intHour;

    /** 分数 */
    private int intMinute;

    /** 秒数 */
    private int intSecond;

    /** 星期几 */
    private int intWeek;

    /** 字符串类型日期，格式：yyyy-MM-dd HH:mm:ss */
    private String strDate;

    /** 日期格式：yyyy-MM-dd HH:mm:ss */
    private SimpleDateFormat sdf;

    /** 当前日期的长整形数 */
    private Long currentTimeMillis;

    private Calendar cal = Calendar.getInstance();

    /**
     * 公用日期操作类以当前日期初始化
     */
    public TimeDateUtil() {
        init();
    }

    /**
     * 公用日期操作类以长整形数日期初始化
     * @param lTime
     */
    public TimeDateUtil(Long lTime) {
        try {
            sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String strDate = this.long2StrDate(lTime);

            Date date =sdf.parse(strDate);
            cal.setTime(date);

            intYear=cal.get(Calendar.YEAR);
            intMonth=cal.get(Calendar.MONTH)+1;
            intDay=cal.get(Calendar.DATE);
            intHour=cal.get(Calendar.HOUR_OF_DAY);
            intMinute=cal.get(Calendar.MINUTE);
            intSecond=cal.get(Calendar.SECOND);
            intWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
            intDayNum = cal.getActualMaximum(Calendar.DATE);
            currentTimeMillis = cal.getTimeInMillis();

            if(0 == intWeek)
                intWeek = 7;

            this.strDate = strDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 公用日期操作类以strDate日期初始化
     * @param strDate		日期，格式：yyyy-MM-dd HH:mm:dd
     * @throws ParseException
     */
    public TimeDateUtil(String strDate) {
        try {
            sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date =sdf.parse(strDate);
            cal.setTime(date);

            intYear=cal.get(Calendar.YEAR);
            intMonth=cal.get(Calendar.MONTH)+1;
            intDay=cal.get(Calendar.DATE);
            intHour=cal.get(Calendar.HOUR_OF_DAY);
            intMinute=cal.get(Calendar.MINUTE);
            intSecond=cal.get(Calendar.SECOND);
            intWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
            intDayNum = cal.getActualMaximum(Calendar.DATE);
            currentTimeMillis = cal.getTimeInMillis();

            if(0 == intWeek)
                intWeek = 7;

            this.strDate = strDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 公用日期操作类以strDate日期初始化
     * @param strDate		日期
     * @param dateFormat	日期格式 eg：yyyy-MM-dd HH:mm:dd
     * @throws ParseException
     */
    public TimeDateUtil(String strDate, String dateFormat) throws ParseException {
        sdf=new SimpleDateFormat(dateFormat);
        Date date =sdf.parse(strDate);
        cal.setTime(date);

        intYear=cal.get(Calendar.YEAR);
        intMonth=cal.get(Calendar.MONTH)+1;
        intDay=cal.get(Calendar.DATE);
        intHour=cal.get(Calendar.HOUR_OF_DAY);
        intMinute=cal.get(Calendar.MINUTE);
        intSecond=cal.get(Calendar.SECOND);
        intWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        intDayNum = cal.getActualMaximum(Calendar.DATE);
        currentTimeMillis = cal.getTimeInMillis();

        if(0 == intWeek)
            intWeek = 7;

        this.strDate = strDate;
    }

    public static int daysBetween(long stime, long etime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date smdate = sdf.parse(sdf.format(stime));
            Date bdate = sdf.parse(sdf.format(etime));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取某个时间段内的所有日期
     * @param dBegin 开始时间
     * @param dEnd 结束时间
     * @return
     */
    public static List<Date> findDates(Date dBegin, Date dEnd)
    {
        List lDate = new ArrayList();
        // 若开始与结束日期为同一天,即直接添加当天
            Calendar calBegin = Calendar.getInstance();
            // 使用给定的 Date 设置此 Calendar 的时间
            calBegin.setTime(dBegin);
            Calendar calEnd = Calendar.getInstance();
            // 使用给定的 Date 设置此 Calendar 的时间
            calEnd.setTime(dEnd);
            // 测试此日期是否在指定日期之后
            while (dEnd.after(calBegin.getTime()))
            {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                lDate.add(calBegin.getTime());
                calBegin.add(Calendar.DAY_OF_MONTH, 1);
            }
            lDate.add(dEnd);

        return lDate;
    }

    public static int getMondayPlus(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = calendar.get(Calendar.DAY_OF_WEEK);
        if (num == 1) {
            num = -6;
        } else {
            num = 2 - num;
        }
        return Math.abs(num);
    }

    public static Date getMonday() {
        TimeDateUtil timeDateUtil = new TimeDateUtil();
        int num =TimeDateUtil.getMondayPlus(new Date());
        Calendar monday = Calendar.getInstance();
        monday.setTime(new Date());
        monday.add(Calendar.DAY_OF_WEEK, - num);
        monday.set(Calendar.HOUR_OF_DAY, 0);
        monday.set(Calendar.MINUTE, 0);
        monday.set(Calendar.SECOND, 0);
        monday.set(Calendar.MILLISECOND, 0);
        return monday.getTime();
    }

    public static Date[] getMondayAndSunday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date monday = calendar.getTime();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date sunday = calendar.getTime();
        return new Date[]{monday, sunday};
    }

    /**
     * 获取两个日期之间的年数
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int getYearSpace(Date startDate, Date endDate) throws ParseException {
        int result = 0;
        if (startDate == null || endDate == null) {
            return result;
        }
        if (startDate.after(endDate)) {
            return result;
        }

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(startDate);
        c2.setTime(endDate);

        result = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);

        return result == 0 ? 0 : Math.abs(result);
    }

    /**
     * 获取两个日期之间的月数
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int getMonthSpace(Date startDate, Date endDate) throws ParseException {
        int result = 0;
        if (startDate == null || endDate == null) {
            return result;
        }
        if (startDate.after(endDate)) {
            return result;
        }

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(startDate);
        c2.setTime(endDate);

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int getDaySpace(Date startDate, Date endDate) throws ParseException {
        int result = 0;
        if (startDate == null || endDate == null) {
            return result;
        }
        if (startDate.after(endDate)) {
            return result;
        }

        Calendar c1 = Calendar.getInstance();
        c1.setTime(startDate);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(endDate);

        int day1 = c1.get(Calendar.DAY_OF_YEAR);
        int day2 = c2.get(Calendar.DAY_OF_YEAR);

        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);

        if (year1 != year2) { //不同年
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) { //闰年
                    timeDistance += 366;
                } else { //不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else { //同一年
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }

    /**
     * @param startDate 需要比较的时间 不能为空(null),需要正确的日期格式
     * @param endDate 被比较的时间  为空(null)则为当前时间
     * @param type 返回值类型   0为多少天，1为多少个月，2为多少年
     * @return
     */
    public static int compareDate(String startDate, String endDate, int type) {
        int n = 0;
        if (startDate == null) {
            return n;
        }

        String formatStyle = "yyyy-MM-dd";
        SimpleDateFormat simple = new SimpleDateFormat(formatStyle);
        String[] u = {"天", "月", "年"};

        endDate = endDate == null ? simple.format(new Date()) : endDate;

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(startDate));
            c2.setTime(df.parse(endDate));
        } catch (Exception e3) {
            System.out.println("wrong occured");
        }
        while (!c1.after(c2)) {                     // 循环对比，直到相等，n 就是所要的结果
            n++;
            if (type == 1) {
                c1.add(Calendar.MONTH, 1);          // 比较月份，月份+1
            } else {
                c1.add(Calendar.DATE, 1);           // 比较天数，日期+1
            }
        }

        n = n - 1;

        if (type == 2) {
            n = (int) n / 365;
        }

        System.out.println(startDate + " -- " + endDate + " 相差多少" + u[type] + ":" + n);
        return n;
    }

    public static boolean isThisWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(date);
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        return paramWeek == currentWeek;
    }

    /**
     * 获取今天的日期
     * @return
     */
    public static String getToday() {
        Calendar yesterdayC = Calendar.getInstance();
        yesterdayC.setTime(new Date());
        SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
        // 昨天
        String yesterday = sdfD.format(yesterdayC.getTime());
        return yesterday;
    }

    /**
     * 将日期格式化为yyyy年MM月dd日
     * @param date
     * @return
     */
    public static String getDateYYYYMMDD(Date date) {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    /**
     * 将日期格式化为HH:mm
     * @param date
     * @return
     */
    public static String getDateHHMM(Date date) {


        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    /**
     * 获取周几
     * @param date
     * @return
     */
    public static String getWeekDate(Date date) {

        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String strWeek = "周";
        switch(cal.get(Calendar.DAY_OF_WEEK) - 1) {
            case 1:
                strWeek += "一";
                break;
            case 2:
                strWeek += "二";
                break;
            case 3:
                strWeek += "三";
                break;
            case 4:
                strWeek += "四";
                break;
            case 5:
                strWeek += "五";
                break;
            case 6:
                strWeek += "六";
                break;
            case 0:
                strWeek += "日";
                break;
        }
        return strWeek;
    }

//    /**
//     * 获取当月最后一天日期
//     * @param month (yyyy-mm)
//     * @return
//     */
//    public static Date getMonthLastDay(String month) throws ParseException {
//
//        if(StringUtils.isEmpty(month)) {
//            return null;
//        }
//        // 拼接成第一天日期
//        String firstDayStr = month + "-01";
//        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
//        Date firstDay = simple.parse(firstDayStr);
//
//        Calendar c = Calendar.getInstance();
//        c.setTime(firstDay);
//        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
//        return c.getTime();
//    }

//    /**
//     * 获取当月第一天日期
//     * @param month (yyyy-mm)
//     * @return
//     */
//    public static Date getMonthFirstDay(String month) throws ParseException {
//
//        if(StringUtils.isEmpty(month)) {
//            return null;
//        }
//        // 拼接成第一天日期
//        String firstDayStr = month + "-01";
//        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
//        return simple.parse(firstDayStr);
//    }
//
//    /**
//     * 获取今天的日期
//     * @return
//     */
//    public static String getTodayDate() {
//        SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        // 昨天
//        String today = sdfD.format(date.getTime());
//        return today;
//    }

    /**
     * 获取n天前的日期
     * @return
     */
    public static String getNDay(int days) {
        Calendar dayC = Calendar.getInstance();
        dayC.setTime(new Date());
        dayC.add(Calendar.DAY_OF_YEAR, -days);
        SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");

        // 昨天
        String day = sdfD.format(dayC.getTime());
        return day;
    }

    // 测试主函数
    public static void main(String[] argc) throws ParseException {
        TimeDateUtil tdu = new TimeDateUtil();
//		System.out.println(tdu.long2StrYmdHm(1480589851000L));
//		System.out.println(tdu.getIntYear());
//		System.out.println(tdu.getIntMonth());
//		System.out.println(tdu.getIntDay());
//		System.out.println(tdu.getIntHour());
//		System.out.println(tdu.getIntMinute());
//		System.out.println(tdu.getIntSecond());
//		System.out.println(tdu.getIntWeek());
//		System.out.println(tdu.getStrDate());
//		System.out.println(tdu.getCurrentTimeMillis());
//		System.out.println(tdu.getIntDayNum());
//		Long l = System.currentTimeMillis();
//		System.out.println(l%(1000*60*60*24));
//		System.out.println(tdu.strDate2Long("2016-09-03 00:00:00"));

//		System.out.println(tdu.long2StrDate(1456373842000L));
//		System.out.println(tdu.long2StrYTDHMS(1456373842000L));

        System.out.println(tdu.strDate2Long(tdu.getStrDate().split(" ")[0]+" 23:59:59"));
    }

    /**
     * 将日期格式化为yyyy-MM-dd
     * @param date
     * @return
     */
    public static String getYYMMDD(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    /**
     * 是否最近七天
     *
     * @param date
     * @return
     */
    public static boolean getNewFlag(Date date) {
        long time = System.currentTimeMillis() - date.getTime();
        return time > 0 && time < 7 * 24 * 60 * 60 * 1000;
    }

    /**
     * 秒转时分秒字符串
     *
     * @param time
     * @return
     */
    public static String secToTime(int time) {
        if (time <= 0)
            return "0'0\"";
        else {
            int hour = time / 3600;
            int minute = time % 3600 / 60;
            int second = time % 3600 % 60;
            if (hour > 0) {
                return hour + "h " + minute + "'" + second + "\"";
            } else {
                return minute + "'" + second + "\"";
            }
        }
    }

    /**
     * 获取两个月份之间的所有月份
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 获取今天的月份
     * @return
     */
    public static String getTodayMonth() {
        Calendar todayM = Calendar.getInstance();
        todayM.setTime(new Date());
        SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM");
        // 昨天
        String todayMonth = sdfD.format(todayM.getTime());
        return todayMonth;
    }

    /**
     * 获取用户年龄字符串
     *
     * @param age
     * @return
     */
    public static String getUserAgeStr(Date age) {
        String ageStr = "";
        if (age != null) {
            int months = compareDate(sdfYYYYMMDD.format(age), null, 1);
            if (months >= 12) {
                ageStr = months / 12 + "岁";
                int month = months % 12;
                if (month > 0) {
                    ageStr += month + "个月";
                }
            } else if (months < 0) {
                ageStr = "未出生";
            } else if (months > 0 && months < 12) {
                ageStr = months + "个月";
            } else {
                int days = TimeDateUtil.compareDate(sdfYYYYMMDD.format(age), null, 0);
                if (days >= 0) {
                    days = days == 0 ? 1 : days;
                    ageStr = days + "天";
                } else {
                    ageStr = "未出生";
                }
            }
        }
        return ageStr;
    }

    /**
     * 将日期格式化为yyyy/MM/dd
     * @param date
     * @return
     */
    public static String getDateYMD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    private void init() {
        intYear=cal.get(Calendar.YEAR);
        intMonth=cal.get(Calendar.MONTH)+1;
        intDay=cal.get(Calendar.DATE);
        intHour=cal.get(Calendar.HOUR_OF_DAY);
        intMinute=cal.get(Calendar.MINUTE);
        intSecond=cal.get(Calendar.SECOND);
        intWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        currentTimeMillis = cal.getTimeInMillis();
        intDayNum = cal.getActualMaximum(Calendar.DATE);

        if(0 == intWeek)
            intWeek = 7;

        sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        strDate = sdf.format(cal.getTime());
    }

    /**
     * 获取当前年份
     * @return		得到当前年份
     */
    public int getIntYear() {
        return intYear;
    }

    /**
     * 获取当前月份
     * @return		得到当前月份
     */
    public int getIntMonth() {
        return intMonth;
    }

    /**
     * 获取2位当前月份
     * @return		得到2位当前月份
     */
    public String getStrMonth() {
        String strMonth = String.valueOf(intMonth);
        return strMonth.length()==1 ? "0"+strMonth : strMonth;
    }

    /**
     * 获取当前天数
     * @return		得到当前天数
     */
    public int getIntDay() {
        return intDay;
    }

    /**
     * 获取当前天数
     * @return		得到当前天数
     */
    public String getStrDay() {
        String strDay = String.valueOf(intDay);
        return strDay.length()==1 ? "0"+strDay : strDay;
    }

    /**
     * 获取当前小时数
     * @return		得到当前小时数
     */
    public int getIntHour() {
        return intHour;
    }

    /**
     * 获取当前小时数
     * @return		得到当前小时数
     */
    public String getStrHour() {
        return this.intHour>9?String.valueOf(this.intHour):("0"+this.intHour);
    }

    /**
     * 获取当前分钟数
     * @return		得到当前分钟数
     */
    public int getIntMinute() {
        return intMinute;
    }

    public String getStrMinute() {
        return this.intMinute>9?String.valueOf(this.intMinute):("0"+this.intMinute);
    }

    /**
     * 获取当前秒数
     * @return		得到当前秒数
     */
    public int getIntSecond() {
        return intSecond;
    }

    public String getStrSecond() {
        return this.intSecond>9?String.valueOf(this.intSecond):("0"+this.intSecond);
    }

    /**
     * 获取当前周数
     * @return		得到当前周数
     */
    public int getIntWeek() {
        return intWeek;
    }

    public String getStrWeek() {
        String strWeek="日";
        switch(this.intWeek) {
            case 1:
                strWeek = "一";
                break;
            case 2:
                strWeek = "二";
                break;
            case 3:
                strWeek = "三";
                break;
            case 4:
                strWeek = "四";
                break;
            case 5:
                strWeek = "五";
                break;
            case 6:
                strWeek = "六";
                break;
        }
        return strWeek;
    }

    /**
     * 获取字符串型当前日期(格式：yyyy-MM-dd HH:mm:dd)
     * @return		得到当前日期(格式：yyyy-MM-dd HH:mm:dd)
     */
    public String getStrDate() {
        return strDate;
    }

    /**
     * 获取字符串型当前日期(格式：yyyyMMddHHmm)
     * @return		得到当前日期(格式：yyyyMMddHHmm)
     */
    public String getStrYMDHM() {
        return this.getIntYear()+this.getStrMonth()+this.getStrDay()+this.getStrHour()+this.getStrMinute();
    }

    /**
     * 获取字符串型当前日期(格式：yyyyMMdd)
     * @return		得到当前日期(格式：yyyyMMdd)
     */
    public String getStrYMD() {
        return this.getIntYear()+this.getStrMonth()+this.getStrDay();
    }

    /**
     * 日期，格式：yyyy-MM-dd HH:mm:dd
     * @return		得到日期，格式：yyyy-MM-dd HH:mm:dd
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    /**
     * 当前日期的长整形数
     * @return		得到当前日期的长整形数
     */
    public Long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    /**
     * java.util.Date类型转换成Long类型
     * @param date	待转型的日期
     * @return		得到毫秒数
     */
    public Long date2Long(Date date) {
        return date.getTime();
    }

    /**
     * 格式(yyyy-MM-dd HH:mm:ss)日期类型转换成Long类型
     * @param strDate		待转型的日期
     * @return				得到毫秒数
     * @throws ParseException
     */
    public Long strDate2Long(String strDate) throws ParseException {
        Date date = sdf.parse(strDate);
        return date2Long(date);
    }

    /**
     * 长整形数(毫秒级)转换成字符串日期，格式(yyyy-MM-dd HH:mm:ss)
     * @param lTime		长整形数(毫秒级)
     * @return 			得到日期，格式(yyyy-MM-dd HH:mm:ss)
     */
    public String long2StrDate(Long lTime) {
        Date dt = new Date(lTime);
        return sdf.format(dt);
    }

    /**
     * 获取本月一共多少天
     * @return the intDayNum
     */
    public int getIntDayNum() {
        return intDayNum;
    }

    /**
     *
     * @return		年/月/日/
     */
    public String getPath() {
        return this.getIntYear()+"/"+this.getStrMonth()+"/"+this.getStrDay()+"/";
    }

    /**
     * @return 年/月/日/
     */
    public String getPath(String dir) {
        return dir + this.getIntYear() + "/" + this.getStrMonth() + "/" + this.getStrDay() + "/";
    }

    /**
     * 目前天数+-
     * @param day
     */
    public void add(int day) {
        cal.add(Calendar.DAY_OF_YEAR, day);

        this.init();
    }

    public void addMonth(int month) {
        cal.add(Calendar.MONTH, month);

        this.init();
    }

    /**
     * 长整形数(毫秒级)转换成字符串日期，格式(HH:mm)
     * @param lTime		长整形数(毫秒级)
     * @return 			得到日期，格式(HH:mm)
     */
    public String long2StrHm (Long lTime) {
        SimpleDateFormat sdfHm = new SimpleDateFormat("HH:mm");
        Date dt = new Date(lTime);
        return sdfHm.format(dt);
    }

    /**
     * 长整形数(毫秒级)转换成字符串日期，格式(yyyy/MM/dd)
     * @param lTime		长整形数(毫秒级)
     * @return 			得到日期，格式(yyyy/MM/dd)
     */
    public String long2StrYmd (Long lTime) {
        SimpleDateFormat sdfHm = new SimpleDateFormat("yyyy/MM/dd");
        Date dt = new Date(lTime);
        return sdfHm.format(dt);
    }

    /**
     * 长整形数(毫秒级)转换成字符串日期，格式(yyyy年MM月dd日)
     * @param lTime		长整形数(毫秒级)
     * @return 			得到日期，格式(yyyy年MM月dd日)
     */
    public String long2StrYTD (Long lTime) {
        SimpleDateFormat sdfHm = new SimpleDateFormat("yyyy年MM月dd日");
        Date dt = new Date(lTime);
        return sdfHm.format(dt);
    }

    /**
     * 长整形数(毫秒级)转换成字符串日期，格式(yyyy-MM-dd HH:mm)
     * @param lTime		长整形数(毫秒级)
     * @return 			得到日期，格式(yyyy年MM月dd日)
     */
    public String long2StrYmdHm (Long lTime) {
        SimpleDateFormat sdfHm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dt = new Date(lTime);
        return sdfHm.format(dt);
    }

    /**
     * 长整形数(毫秒级)转换成字符串日期，格式(yyyy年MM月dd日)
     * @param lTime		长整形数(毫秒级)
     * @return 			得到日期，格式(yyyy年MM月dd日)
     */
    public String long2StrYTDHMS (Long lTime) {
        SimpleDateFormat sdfHm = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date dt = new Date(lTime);
        return sdfHm.format(dt);
    }

    /**
     * 长整形数(毫秒级)转换成字符串日期，格式(yyyy年MM月dd日 HH:mm)
     * @param lTime		长整形数(毫秒级)
     * @return 			得到日期，格式(yyyy年MM月dd日)
     */
    public String long2StrYTDHM (Long lTime) {
        SimpleDateFormat sdfHm = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        Date dt = new Date(lTime);
        return sdfHm.format(dt);
    }

    /**
     * 获取昨天的日期
     * @return
     */
    public String getYesterday() {
        Calendar yesterdayC = Calendar.getInstance();
        yesterdayC.setTime(new Date());
        yesterdayC.add(Calendar.DAY_OF_YEAR, -1);
        SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
        // 昨天
        return sdfD.format(yesterdayC.getTime());
    }

    /*
     * MM月dd日
     *
     * */
    public String getMMdd(Date date){
        return new SimpleDateFormat("MM月dd日").format(date);
    }

    /*
     * HH:mm
     *
     * */
    public String getHHmm(Date date){

        return new SimpleDateFormat("HH:mm").format(date);
    }

    /**
     * 根据字符日期 获取Date dayStr : YYYY-MM-dd
     * @param dayStr
     * @return
     */
    public Date getDateByDayStr(String dayStr) throws ParseException {
        SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
        return sdfD.parse(dayStr);
    }

    /**
     * 获取今日开始的毫秒值
     * @return
     */
    public long getTodayStartTimestamp(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        long timeInMillis = calendar.getTimeInMillis();

        return timeInMillis;
    }

    /**
     * 获取今日结束的毫秒值
     * @return
     */
    public long getTodayEndTimestamp(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.add(Calendar.DATE,1);
        calendar.add(Calendar.MILLISECOND,-1);
        long timeInMillis = calendar.getTimeInMillis();

        return timeInMillis;
    }

}
