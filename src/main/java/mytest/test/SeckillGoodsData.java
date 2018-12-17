package mytest.test;

import mytest.PrintData;
import mytest.TimeDateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/8/3  下午7:50
 */
public class SeckillGoodsData {
    /****
     *
     */


    /**
     * 生成秒杀商品数据
     */
    private static List<String> makeSeckillGoodsData(List<Integer> firstList,List<Integer> secondList) {
        List<String> list = new ArrayList<>();
        try {
            Date beginDate = TimeDateUtil.sdfYYYYMMDD.parse("2018-08-10");
            Date endDate = TimeDateUtil.sdfYYYYMMDD.parse("2018-08-12");
            List<Date> dateList = TimeDateUtil.findDates(beginDate, endDate);

            int seckillGoodNum = 3;

            int normalGoodsNum = 100;

            String startTime = "";
            String endTime = "";
            for (Date date : dateList) {
                startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 08:00:00";
                endTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 13:59:59";
                //顶部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(0),secondList.get(0),seckillGoodNum,seckillGoodNum,1,1,1);

                //底部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(1),secondList.get(1),normalGoodsNum,normalGoodsNum,1,4,0);
                addSeckill(list,startTime,endTime,firstList.get(2),secondList.get(2),normalGoodsNum,normalGoodsNum,2,4,0);
                addSeckill(list,startTime,endTime,firstList.get(3),secondList.get(3),normalGoodsNum,normalGoodsNum,3,4,0);
                addSeckill(list,startTime,endTime,firstList.get(4),secondList.get(4),normalGoodsNum,normalGoodsNum,4,4,0);


                startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 14:00:00";
                endTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 19:59:59";
                //顶部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(5),secondList.get(5),seckillGoodNum,seckillGoodNum,1,1,1);

                //底部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(6),secondList.get(6),normalGoodsNum,normalGoodsNum,1,4,0);
                addSeckill(list,startTime,endTime,firstList.get(7),secondList.get(7),normalGoodsNum,normalGoodsNum,2,4,0);
                addSeckill(list,startTime,endTime,firstList.get(8),secondList.get(8),normalGoodsNum,normalGoodsNum,3,4,0);
                addSeckill(list,startTime,endTime,firstList.get(9),secondList.get(9),normalGoodsNum,normalGoodsNum,4,4,0);


                startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 20:00:00";
                endTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 22:59:59";
                //顶部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(10),secondList.get(10),seckillGoodNum,seckillGoodNum,1,1,1);

                //底部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(11),secondList.get(11),normalGoodsNum,normalGoodsNum,1,4,0);
                addSeckill(list,startTime,endTime,firstList.get(12),secondList.get(12),normalGoodsNum,normalGoodsNum,2,4,0);
                addSeckill(list,startTime,endTime,firstList.get(13),secondList.get(13),normalGoodsNum,normalGoodsNum,3,4,0);
                addSeckill(list,startTime,endTime,firstList.get(14),secondList.get(14),normalGoodsNum,normalGoodsNum,4,4,0);


                startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 23:00:00";
                TimeDateUtil timeDateUtil = new TimeDateUtil(date.getTime());
                timeDateUtil.add(1);
                String yesterDay = timeDateUtil.getStrDate().substring(0, 10);
                endTime = yesterDay+" 07:59:59";
                //顶部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(15),secondList.get(15),seckillGoodNum,seckillGoodNum,1,1,1);

                //底部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(16),secondList.get(16),normalGoodsNum,normalGoodsNum,1,4,0);
                addSeckill(list,startTime,endTime,firstList.get(17),secondList.get(17),normalGoodsNum,normalGoodsNum,2,4,0);
                addSeckill(list,startTime,endTime,firstList.get(18),secondList.get(18),normalGoodsNum,normalGoodsNum,3,4,0);
                addSeckill(list,startTime,endTime,firstList.get(19),secondList.get(19),normalGoodsNum,normalGoodsNum,4,4,0);
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
    private static void addSeckill(List<String> list,String startTime,String endTime,Integer normalGoodId,Integer seckillGoodId,Integer seckillGoodsNum,Integer residueNum,Integer sortLoc,Integer goodsType,Integer whetherUpdate){

        String sql = "INSERT INTO `activity_anniversary_content_manage` (`ID`,`STATUS`,`NORMAL_GOODS_ID`,`SECKILL_GOODS_ID`,`SECKILL_GOODS_NUM`,`RESIDUE_NUM`,`SORT_LOC`,`RELATION_ID`,`GOODS_TYPE`,`WHETHER_UPDATE`,`BEGIN_TIME`,`END_TIME`)" +
                " VALUES" +
                "(NULL,1,"+normalGoodId+","+seckillGoodId+","+seckillGoodsNum+","+residueNum+","+sortLoc+",0,"+goodsType+","+whetherUpdate+",'"+startTime+"','"+endTime+"');";

        list.add(sql);
    }

    public static void main(String[] args) {
        List<Integer> firstList = new ArrayList();
        List<Integer> secondList = new ArrayList();
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);
        firstList.add(2015);


        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        secondList.add(2017);
        if (firstList.size() == secondList.size()){
            List<String> list = makeSeckillGoodsData(firstList,secondList);
            PrintData.printPrizeInsertSqlText(list, "测试8.12秒杀商品数据"+PrintData.getNows()+".sql");
        }
    }

}
