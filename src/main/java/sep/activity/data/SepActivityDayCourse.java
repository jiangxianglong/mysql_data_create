package sep.activity.data;

import mytest.PrintData;
import mytest.TimeDateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/9/19  下午7:42
 */
public class SepActivityDayCourse {
    /**
     * 生成拼团数据 数据
     */
    private static List<String> makeDaySepActivityCourse(String[] datesStr, Integer[] goodId) {
        List<String> list = new ArrayList<>();
        try {
            //创建数据的开始时间
            Date beginDate = TimeDateUtil.sdfYYYYMMDD.parse(datesStr[0]);
            //创建数据的结束时间
            Date endDate = TimeDateUtil.sdfYYYYMMDD.parse(datesStr[1]);
            List<Date> dateList = TimeDateUtil.findDates(beginDate, endDate);

            if (dateList.size() != goodId.length){
                System.out.println("***********         生成数据长度不一致        *************");
                return null;
            }
            int index = 0;
            for (Date date : dateList) {
                String startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 00:00:00";
                String endTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 23:59:59";
                //生成sql数据
                addDaySepActivityCourse(list,startTime,endTime,goodId[index],index);
                index++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    /**
     * 添加图书包数据
     * @param list
     * @param startTime
     * @param endTime
     * @param sortLoc
     */
    private static void addDaySepActivityCourse(List<String> list,String startTime,String endTime,Integer goodsId,Integer sortLoc){
        String sql = "INSERT INTO `september_activity_content_manage` (`ID`,`STATUS`,`TYPE`,`GOODS_ID`,`COUPON_ID`,`RELATION_ID`,`SORT_LOC`,`BEGIN_TIME`,`END_TIME`) VALUES " +
                "(NULL,1,1,"+goodsId+",NULL,NULL,"+sortLoc+",'"+startTime+"','"+endTime+"');";
        list.add(sql);
    }
    public static void main(String[] args) {

        try {
            String[] dateStr = {"2018-09-19","2018-09-23"};
            Integer[] goodId = {31792,31791};
            List<String> list = makeDaySepActivityCourse(dateStr,goodId);
            if (list != null){
                PrintData.printPrizeInsertSqlText(list, " 九月活动数据 "+PrintData.getNows()+".sql");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
