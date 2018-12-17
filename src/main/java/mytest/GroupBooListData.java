package mytest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/8/3  下午7:50
 */
public class GroupBooListData {
    /**
     * 生成拼团数据 数据
     */
    private static List<String> makeGroupBookData(String[] datesStr,Integer[] goodId) {
        List<String> list = new ArrayList<>();
        try {
            //创建数据的开始时间
            Date beginDate = TimeDateUtil.sdfYYYYMMDD.parse(datesStr[0]);
            //创建数据的结束时间
            Date endDate = TimeDateUtil.sdfYYYYMMDD.parse(datesStr[1]);
            List<Date> dateList = TimeDateUtil.findDates(beginDate, endDate);

            for (Date date : dateList) {
                String startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 00:00:00";
                String endTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 23:59:59";

                addGroupBook(list,startTime,endTime,goodId[0],1);

                addGroupBook(list,startTime,endTime,goodId[1],2);

                addGroupBook(list,startTime,endTime,goodId[2],3);

                addGroupBook(list,startTime,endTime,goodId[3],4);

                addGroupBook(list,startTime,endTime,goodId[4],5);

                addGroupBook(list,startTime,endTime,goodId[5],6);

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
    private static void addGroupBook(List<String> list,String startTime,String endTime,Integer groupBookId,Integer sortLoc){
        String sql = "INSERT INTO `activity_anniversary_content_manage` (`ID`,`STATUS`,`NORMAL_GOODS_ID`,`SECKILL_GOODS_ID`,`SECKILL_GOODS_NUM`,`RESIDUE_NUM`,`SORT_LOC`,`RELATION_ID`,`GOODS_TYPE`,`BEGIN_TIME`,`END_TIME`)" +
                " VALUES" +
                " (NULL,1,0,0,0,0,"+sortLoc+","+groupBookId+",2,'"+startTime+"','"+endTime+"');";

        list.add(sql);
    }
    public static void main(String[] args) {
        /**
         * 拼团商品数据
         * 8.7   dateStr：{"2018-08-07","2018-08-08"}   {102,99,105,108}
         */
        try {
            String date = "2018-09-25";
            String[] dateStr = {date,date};
            Integer[] goodId = {206,238,212,207,209,138};
            List<String> list = makeGroupBookData(dateStr,goodId);
            PrintData.printPrizeInsertSqlText(list, date+" 拼团列表数据 "+PrintData.getNows()+".sql");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
