package firth.activity.data;

import mytest.PrintData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * https://shimo.im/sheet/jwxlIyyS0hM42WeN/RIDOC/ 《粉丝节奖品清单》，可复制链接后用石墨文档 App 打开
 * @author jiangxianglong
 * @date 2018/10/23  下午3:42
 */
public class FirthActivityData {
    /**
     * 生成奖池数据
     */
    private static List<String> makePrizePoolData(String date) {
        String startDate = date+" 00:00:00";
        String endDate = date+" 23:59:59";
        List<String> sqlList = new ArrayList<>();
        // 金币 24000
        for (int i = 0; i < 19200; i++) {
            String sql = "(NULL, 2, 12, NULL, " + getRandNum() + ", '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        // 哈佛北大STEAM图书包588元现金券:42828        5000
        for (int i = 0; i < 4000; i++) {
            String sql = " (NULL, 3, 1, 42828, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        // 哈佛北大STEAM图书包288元现金券:42826        5000
        for (int i = 0; i < 4000; i++) {
            String sql =" (NULL, 3, 2, 42826, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }
        // 外教1V3 88元现金券 : 42829     5000
        for (int i = 0; i < 4000; i++) {
            String sql = " (NULL, 3, 3, 42829, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        // 小小托福送考团88元现金券  :42825
        for (int i = 0; i <4000; i++) {
            String sql = " (NULL, 3, 4, 42825, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        // 2018暑假游学营88元现金券: 42823
        for (int i = 0; i < 4000; i++) {
            String sql = " (NULL, 3, 5, 42823, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        // 迷你图书包88元现金券 42831
        for (int i = 0; i < 5000; i++) {
            String sql = " (NULL, 3, 6, 42831, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        // 全能宝宝100元现金券  42900
        for (int i = 0; i < 4000; i++) {
            String sql =" (NULL, 3, 7, 42900, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        // 38元现金券  68:  42824
        for (int i = 0; i < 9600; i++) {
            String sql = " (NULL, 3, 8, 42824, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        // 20元现金券  20:42821
        for (int i = 0; i < 9600; i++) {
            String sql = " (NULL, 3, 9, 42821, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        // 10元现金券  42819    12000
        for (int i = 0; i < 9600; i++) {
            String sql =" (NULL, 3, 10, 42819, NULL, '" + startDate + "', '" + endDate + "', 0, NULL, '" + startDate + "'),";
            sqlList.add(sql);
        }

        Collections.shuffle(sqlList);
        List<String> result = new ArrayList<>();
        //sql批处理  添加头文件
        int index = 1;
        //修改顺序以后的奖池数据添加进去
        for (String s : sqlList) {
            if (index == sqlList.size()){
                result.add(s.substring(0,s.length()-1 )+";");
            }else {
                result.add(s);
            }
            index++;
        }
        return result;
    }

    private static Integer getRandNum() {
        Long tempNum = Math.round(Math.random()*20+10);
        return tempNum.intValue();
    }

    public static void main(String[] args) {
        List<String> resultList = new ArrayList<>();
        resultList.add(" INSERT INTO `may_activity_lottery_pool` (`ID`, `TYPE`, `PRIZE`, `COUPONS_ID`, `NUM`, `START_DATE`, `END_DATE`, `STATUS`, `RECEIVE_TIME`, `CREATE_DATE`) VALUES ");




        String date = "2018-11-11";
        List<String> list = makePrizePoolData(date);
        resultList.addAll(list);


        PrintData.printPrizeInsertSqlText(resultList, date+"五月活动奖池数据："+PrintData.getNows()+".sql");



//         int a= new BigDecimal(2799).multiply(new BigDecimal(700)).multiply(new BigDecimal(1)).divide(new BigDecimal(2800), RoundingMode.DOWN).intValue();
//
//        System.out.println(a);
//
//        float c = 1f*2799*700*1/2800;
//        System.out.println(c);
//
//        int b = Math.round(1f*2799*700*1/2800);
//
//        System.out.println(b);

    }
}
