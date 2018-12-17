package sep.activity.data;

import mytest.PrintData;

import java.util.ArrayList;
import java.util.List;

/**
 * 图书包用户首页优惠券显示
 * @author jiangxianglong
 * @date 2018/9/19  下午7:29
 */
public class BookPackCouponData {

    /**
     * 生成  活动首页优惠券
     */
    private static List<String> makeCouponData(String[] dateArr,Integer[] couponArr) {
        List<String> list = new ArrayList<>();
        try {
            String startTime = dateArr[0]+" 00:00:00";
            String endTime = dateArr[1]+" 23:59:59";
            int index = 0;
            for (Integer couponId : couponArr) {
                addCouponData(list,startTime,endTime,couponId,index);
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
    private static void addCouponData(List<String> list,String startTime,String endTime,Integer couponId,Integer sortLoc){
        String sql = "INSERT INTO `september_activity_content_manage`(`ID`, `STATUS`, `TYPE`, `GOODS_ID`, `COUPON_ID`, `RELATION_ID`, `SORT_LOC`, `BEGIN_TIME`, `END_TIME`) VALUES" +
                " (NULL, 1, 2, NULL, "+couponId+", NULL, "+sortLoc+", '"+startTime+"', '"+endTime+"');";

        list.add(sql);
    }

    public static void main(String[] args) {
        String[] dateStr = {"2018-09-24","2018-10-26"};
        Integer[] goodId = {39018,39036,39021,39041};
        List<String> list = makeCouponData(dateStr,goodId);
        PrintData.printPrizeInsertSqlText(list, "24-26 图书包用户首页优惠券数据 "+PrintData.getNows()+".sql");
    }

}
