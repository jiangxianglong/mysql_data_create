package mytest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/8/3  下午7:51
 */
public class CouponData {

    /**
     * 生成  活动首页优惠券
     */
    private static List<String> makeCouponData() {
        List<String> list = new ArrayList<>();
        try {
            Date beginDate = TimeDateUtil.sdfYYYYMMDD.parse("2018-09-25");
            Date endDate = TimeDateUtil.sdfYYYYMMDD.parse("2018-09-26");
            List<Date> dateList = TimeDateUtil.findDates(beginDate, endDate);

            for (Date date : dateList) {
                String startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 00:00:00";
                String endTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 23:59:59";

                addCouponData(list,startTime,endTime,39074,1);

                addCouponData(list,startTime,endTime,39076,2);
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
    private static void addCouponData(List<String> list,String startTime,String endTime,Integer couponId,Integer sortLoc){

        String sql = "INSERT INTO `activity_anniversary_content_manage` (`ID`,`STATUS`,`NORMAL_GOODS_ID`,`SECKILL_GOODS_ID`,`SECKILL_GOODS_NUM`,`RESIDUE_NUM`,`SORT_LOC`,`RELATION_ID`,`GOODS_TYPE`,`BEGIN_TIME`,`END_TIME`)" +
                " VALUES" +
                " (NULL,1,0,0,0,0,"+sortLoc+","+couponId+",3,'"+startTime+"','"+endTime+"');";

        list.add(sql);
    }

    public static void main(String[] args) {
        List<String> list = makeCouponData();
        PrintData.printPrizeInsertSqlText(list, "9.25 首页优惠券数据 "+PrintData.getNows()+".sql");
    }
}
