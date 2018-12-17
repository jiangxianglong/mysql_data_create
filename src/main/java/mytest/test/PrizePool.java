package mytest.test;

import mytest.PrintData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/8/3  下午2:02
 */
public class PrizePool {

    private static String title = "";
    /**
     * 生成奖池数据
     */
    private static List<String> makePrizePoolData() {
        //  `PRIZE_TYPE` int(11) DEFAULT NULL COMMENT '类型 1:实体  2:优惠券 3: 虚拟课程 4:金币',

        String startDate = "2018-08-21 00:00:00";
        String endDate = "2018-08-21 23:59:59";
        List<String> sqlList = new ArrayList<>();
        int goldPrizeSize = 0;
        int couponSize = 0;
        int courseSize =0;
        int eneitySeize =0 ;
        /*********************     金币  1          *************************/

        int goldPoolSize = 1;

        //prize: 1 金币
        addGoldPrize(sqlList,goldPoolSize,startDate,endDate,1,4);

        goldPrizeSize = sqlList.size();

        /*********************     优惠券  2-10          *************************/

        //优惠券数量
        int couponSize111= 1;

        //prize: 2  周年庆15元优惠券
        addCouponPrize(sqlList,couponSize111,startDate,endDate,2,2,31310);

        //prize: 3   周年庆20元优惠券
        addCouponPrize(sqlList,couponSize111,startDate,endDate,3,2,31311);


        //prize: 4   周年庆35元优惠券
        addCouponPrize(sqlList,couponSize111,startDate,endDate,4,2,31313);


        //prize: 5   周年庆68元优惠券
        addCouponPrize(sqlList,couponSize111,startDate,endDate,5,2,31314);

        //prize: 6   周年庆288元优惠券
        addCouponPrize(sqlList,couponSize111,startDate,endDate,6,2,31317);


        //prize: 7   周年庆1000元优惠券
        addCouponPrize(sqlList,couponSize111,startDate,endDate,7,2,31356);


        //prize: 8   周年庆100元优惠券
        addCouponPrize(sqlList,couponSize111,startDate,endDate,8,2,31357);


        //prize: 9   周年庆3000元优惠券
        addCouponPrize(sqlList,couponSize111,startDate,endDate,9,2,31358);


        //prize: 10  周年庆3000元优惠券
        addCouponPrize(sqlList,couponSize111,startDate,endDate,10,2,31359);


        couponSize = sqlList.size() - goldPrizeSize;

        /********************************************************     实体  11-21          *******************************************************************/
        //实体数量
        int enentyNum111 = 1;

        int eneityNum22 = 1;

        int eneityNum33 = 1;

        int eneityNum44 = 1;

        int eneityNum55 = 1;

        //prize: 11   488   10   Dior魅惑口红
        addEneityPrize(sqlList,enentyNum111,startDate,endDate,11,1,488);

        //prize: 12   510   5    LANCOME小黑瓶精华液
        addEneityPrize(sqlList,enentyNum111,startDate,endDate,12,1,510);

        //prize: 13   509   5    populele儿童智能尤克里里
        addEneityPrize(sqlList,enentyNum111,startDate,endDate,13,1,509);

        //prize: 14   508   300  全能宝宝梦想盒子
        addEneityPrize(sqlList,eneityNum22,startDate,endDate,14,1,508);

        //prize: 15   507   300   绘本
        addEneityPrize(sqlList,eneityNum33,startDate,endDate,15,1,507);

        //prize: 16   506   100    热血读书上瘾励志大海报
        addEneityPrize(sqlList,eneityNum44,startDate,endDate,16,1,506);

        //prize: 17   505   100      美国哈佛耶鲁牛娃家大海报
        addEneityPrize(sqlList,eneityNum44,startDate,endDate,17,1,505);

        //prize: 18   504   100      藐视凡人全球名人名言大海报
        addEneityPrize(sqlList,eneityNum44,startDate,endDate,18,1,504);

        //prize: 19   503    30      有声英文单词卡豪华礼盒
        addEneityPrize(sqlList,enentyNum111,startDate,endDate,19,1,503);

        //prize: 20   502    300      全家福贴纸
        addEneityPrize(sqlList,eneityNum22,startDate,endDate,20,1,502);

        //prize: 21   501    500       杨易第三季文具盒
        addEneityPrize(sqlList,eneityNum55,startDate,endDate,21,1,501);


        eneitySeize = sqlList.size() - goldPrizeSize - couponSize;
        /*************************************************     虚拟课程  22 - 33  1：音频  2：伴读 3：直播 4：视频       *****************************************************/

        int courseNum111 = 1;

        //prize: 22   超人妈妈必学收纳音频大课    300      500        1
        addCoursePrize(sqlList,courseNum111,startDate,endDate,22,3,500,1);

        //prize: 23   辣妈驻颜术音频课     300             499          1
        addCoursePrize(sqlList,courseNum111,startDate,endDate,23,3,499,1);

        //prize: 24   我的图书馆系列1伴读课    300            498         2
        addCoursePrize(sqlList,courseNum111,startDate,endDate,24,3,498,2);

        //prize: 25    哥哥姐姐们的10大金曲合辑   300          497         1
        addCoursePrize(sqlList,courseNum111,startDate,endDate,25,3,497,1);

        //prize: 26    小学语文文言文精讲音频课   300           496         1
        addCoursePrize(sqlList,courseNum111,startDate,endDate,26,3,496,1);

        //prize: 27     20个超人气动画人物音频故事   300        495         1
        addCoursePrize(sqlList,courseNum111,startDate,endDate,27,3,495,1);

        //prize: 28     科学长高25个小妙招    300           494
        addCoursePrize(sqlList,courseNum111,startDate,endDate,28,3,489,1);

        //prize: 29      斯宾塞快乐教育法6大秘籍   300         493
        addCoursePrize(sqlList,courseNum111,startDate,endDate,29,3,494,1);

        //prize: 30     《阿凡提》 名师精讲音频    300         492         1
        addCoursePrize(sqlList,courseNum111,startDate,endDate,30,3,493,1);

        //prize: 31      《给孩子讲莎士比亚》伴读课  300        491          2
        addCoursePrize(sqlList,courseNum111,startDate,endDate,31,3,492,2);

        //prize: 32       “思考的魅力”新东方名师精讲    300     490
        addCoursePrize(sqlList,courseNum111,startDate,endDate,32,3,491,1);

        //prize: 33      《皮特猫》音频课       300             489             1
        addCoursePrize(sqlList,courseNum111,startDate,endDate,33,3,490,1);

        courseSize = sqlList.size() - goldPrizeSize - couponSize - eneitySeize;

//        Collections.shuffle(sqlList);

        title = "金币:"+goldPrizeSize+";优惠券:"+couponSize+";实体:"+eneitySeize+"课程数据:"+courseSize;
        System.out.println(title);

        return sqlList;
    }


    /**
     * 添加优惠券奖品
     * @param sqlList
     * @param forEach  添加奖品个数
     * @param startDate  开始时间
     * @param endDate   结束时间
     * @param prize     prize ID
     * @param prizeType  奖励类型
     */
    public static void addGoldPrize(List<String> sqlList,Integer forEach,String startDate,String endDate,Integer prize,Integer prizeType){
        for (int i = 0; i < forEach; i++) {
            String sql = " INSERT INTO `activity_third_anniversary_lottery_pool` (`ID`,`START_DATE`,`END_DATE`,`RECEIVE_TIME`,`PRIZE`,`PRIZE_TYPE`,`RELATION_ID`,`COURSE_TYPE`,`NUM`,`STATUS`)  " +
                    "VALUES " +
                    "  (NULL, '"+startDate+"', '"+endDate+"', NULL, "+prize+", "+prizeType+",0, 0, 0, 0); ";
            sqlList.add(sql);
        }

    }


    /**
     * 添加优惠券奖品
     * @param sqlList
     * @param forEach  添加奖品个数
     * @param startDate  开始时间
     * @param endDate   结束时间
     * @param prize     prize ID
     * @param prizeType  奖励类型
     * @param couponsId    优惠券ID
     */
    public static void addCouponPrize(List<String> sqlList,Integer forEach,String startDate,String endDate,Integer prize,Integer prizeType,Integer couponsId){
        for (int i = 0; i < forEach; i++) {
            String sql = " INSERT INTO `activity_third_anniversary_lottery_pool` (`ID`,`START_DATE`,`END_DATE`,`RECEIVE_TIME`,`PRIZE`,`PRIZE_TYPE`,`RELATION_ID`,`COURSE_TYPE`,`NUM`,`STATUS`)  " +
                    "VALUES " +
                    "  (NULL, '"+startDate+"', '"+endDate+"', NULL, "+prize+", "+prizeType+","+couponsId+", 0, 0, 0); ";
            sqlList.add(sql);
        }

    }

    /**
     * 添加实体  奖品
     * @param sqlList
     * @param forEach  添加奖品个数
     * @param startDate  开始时间
     * @param endDate   结束时间
     * @param prize     prize ID
     * @param prizeType  奖励类型
     * @param taskPrizeId    奖项ID
     */
    public static void addEneityPrize(List<String> sqlList,Integer forEach,String startDate,String endDate,Integer prize,Integer prizeType,Integer taskPrizeId){
        for (int i = 0; i < forEach; i++) {
            String sql = " INSERT INTO `activity_third_anniversary_lottery_pool` (`ID`,`START_DATE`,`END_DATE`,`RECEIVE_TIME`,`PRIZE`,`PRIZE_TYPE`,`RELATION_ID`,`COURSE_TYPE`,`NUM`,`STATUS`)  " +
                    "VALUES " +
                    "  (NULL, '"+startDate+"', '"+endDate+"', NULL, "+prize+", "+prizeType+","+taskPrizeId+", 0, 0, 0); ";
            sqlList.add(sql);
        }

    }

    /**
     * 添加  虚拟课程
     * @param sqlList
     * @param forEach  添加奖品个数
     * @param startDate  开始时间
     * @param endDate   结束时间
     * @param prize     prize ID
     * @param prizeType  奖励类型
     * @param taskPrizeId    服务ID
     * @param courseType    虚拟课程类型
     */
    public static void addCoursePrize(List<String> sqlList,Integer forEach,String startDate,String endDate,Integer prize,Integer prizeType,Integer taskPrizeId,Integer courseType){
        for (int i = 0; i < forEach; i++) {
            String sql = " INSERT INTO `activity_third_anniversary_lottery_pool` (`ID`,`START_DATE`,`END_DATE`,`RECEIVE_TIME`,`PRIZE`,`PRIZE_TYPE`,`RELATION_ID`,`COURSE_TYPE`,`NUM`,`STATUS`)  " +
                    "VALUES " +
                    "  (NULL, '"+startDate+"', '"+endDate+"', NULL, "+prize+", "+prizeType+","+taskPrizeId+","+courseType+", 0, 0); ";
            sqlList.add(sql);
        }

    }



    public static void main(String[] args) {

        List<String> list = makePrizePoolData();
        PrintData.printPrizeInsertSqlText(list, "测试  16 "+PrintData.getNows()+title+".sql");
    }
}
