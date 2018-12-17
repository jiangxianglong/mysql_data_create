package mytest;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/8/4  上午10:02
 */
public class ActivityDate {

    /**
     * 生成活动日期
     */
    private static List<String> makeDateData(Date beginDate,Date endDate) {
        List<String> list = new ArrayList<>();
        try {
            List<Date> dateList = TimeDateUtil.findDates(beginDate, endDate);

            for (Date date : dateList) {
                String   sql = "INSERT INTO `activity_third_anniversary_date` (`ID`, `START_DATE`, `END_DATE`) " +
                        "VALUES" +
                        "  (NULL, '" + TimeDateUtil.sdfYYYYMMDD.format(date) + " 08:00:00', '" + TimeDateUtil.sdfYYYYMMDD.format(date) + " 13:59:59');";
                list.add(sql);
                sql = "INSERT INTO `activity_third_anniversary_date` (`ID`, `START_DATE`, `END_DATE`) " +
                        "VALUES" +
                        "  (NULL, '" + TimeDateUtil.sdfYYYYMMDD.format(date) + " 14:00:00', '" + TimeDateUtil.sdfYYYYMMDD.format(date) + " 19:59:59');";
                list.add(sql);
                sql = "INSERT INTO `activity_third_anniversary_date` (`ID`, `START_DATE`, `END_DATE`) " +
                        "VALUES" +
                        "  (NULL, '" + TimeDateUtil.sdfYYYYMMDD.format(date) + " 20:00:00', '" + TimeDateUtil.sdfYYYYMMDD.format(date) + " 22:59:59');";
                list.add(sql);
                TimeDateUtil tdu = new TimeDateUtil(date.getTime());
                tdu.add(1);
                String yesterDay = tdu.getStrDate().substring(0, 10);
                sql = "INSERT INTO `activity_third_anniversary_date` (`ID`, `START_DATE`, `END_DATE`) " +
                        "VALUES" +
                        "  (NULL, '" + TimeDateUtil.sdfYYYYMMDD.format(date) + " 23:00:00', '" + yesterDay + " 07:59:59');";
                list.add(sql);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }


    public static void main(String[] args) {
        try {
//            Date beginDate = TimeDateUtil.sdfYYYYMMDD.parse("2018-11-05");
//            Date endDate = TimeDateUtil.sdfYYYYMMDD.parse("2018-12-05");
//            List<String> list = makeDateData(beginDate,endDate);
//
//            PrintData.printPrizeInsertSqlText(list, "五月活动奖池数据:"+PrintData.getNows()+".sql");
//字符串含有中文求字节数：
            String temp="蒋向龙。。askf.,.";
            System.out.println("temp长度："+temp.getBytes(Charset.defaultCharset()).length);
            System.out.println(temp.getBytes().length);

            System.out.println(temp.getBytes().length);

            System.out.println("蒋向12312312.，ax,.就爱那个大了开发商的开发阿斯蒂芬记录是否12312312321龙".substring(0, 20));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
