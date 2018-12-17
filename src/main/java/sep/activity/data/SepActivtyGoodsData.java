package sep.activity.data;

import mytest.PrintData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/9/20  下午3:46
 */
public class SepActivtyGoodsData {
    /**
     * 生成  活动首页优惠券
     */
    private static List<String> makeGoodsData(String[] dateArr, Integer[] goodsArr, Integer[] couponsArr, Integer[] wxArticleArr) {
        List<String> list = new ArrayList<>();
        try {
            String startTime = dateArr[0]+" 00:00:00";
            String endTime = dateArr[1]+" 23:59:59";
            if (goodsArr.length != couponsArr.length && couponsArr.length != wxArticleArr.length){
                System.out.println("九月份活动赠送课程相关数据  配置数据长度不一样！-- ！");
            }
            int index = 0;
            for (Integer couponId : goodsArr) {
                addCouponData(list,goodsArr[index],couponsArr[index],wxArticleArr[index],index,startTime,endTime);
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
    private static void addCouponData(List<String> list,Integer goodsId,Integer couponId,Integer wxArticleId,Integer sortLoc,String startTime,String endTime){
        String sql =  "INSERT INTO `september_activity_content_manage` (`ID`,`STATUS`,`TYPE`,`GOODS_ID`,`COUPON_ID`,`RELATION_ID`,`SORT_LOC`,`BEGIN_TIME`,`END_TIME`) " +
                "VALUES (NULL,1,4,"+goodsId+","+couponId+","+wxArticleId+","+sortLoc+",'"+startTime+"','"+endTime+"');";
        list.add(sql);
    }

    public static void main(String[] args) {
        String[] dateStr = {"2018-09-22","2018-09-24"};
        Integer[] goodsArr = {1562,1525,1460,1437,1436,1421};
        Integer[] couponsArr = {38752,38753,38754,38755,38756,38757};
        Integer[] wxArticleArr = {287,356,375,310,270,179};
        List<String> list = makeGoodsData(dateStr,goodsArr,couponsArr,wxArticleArr);
        PrintData.printPrizeInsertSqlText(list, "4 获取九月活动的商品 相关数据 "+PrintData.getNows()+".sql");
    }
}
