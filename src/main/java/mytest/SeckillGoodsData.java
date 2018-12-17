package mytest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    /***
     * 写文件
     * @param list
     * @param path
     */
    private static void printPrizeInsertSqlText(List<String> list, String path) {
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f = new File(path);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        for (String s : list) {
            pw.println(s);
        }
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成秒杀商品数据
     */
    private static List<String> makeSeckillGoodsData(String startStr,String endStr,List<Integer> firstList,List<Integer> secondList) {
        List<String> list = new ArrayList<>();
        try {
            Date beginDate = TimeDateUtil.sdfYYYYMMDD.parse(startStr);
            Date endDate = TimeDateUtil.sdfYYYYMMDD.parse(endStr);
            List<Date> dateList = TimeDateUtil.findDates(beginDate, endDate);

            int seckillGoodNum = 1;

            int normalGoodsNum = 200;

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
                addSeckill(list,startTime,endTime,firstList.get(5),secondList.get(5),normalGoodsNum,normalGoodsNum,5,4,0);
                addSeckill(list,startTime,endTime,firstList.get(6),secondList.get(6),normalGoodsNum,normalGoodsNum,6,4,0);
                addSeckill(list,startTime,endTime,firstList.get(7),secondList.get(7),normalGoodsNum,normalGoodsNum,7,4,0);
                addSeckill(list,startTime,endTime,firstList.get(8),secondList.get(8),normalGoodsNum,normalGoodsNum,8,4,0);


                startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 14:00:00";
                endTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 19:59:59";
                //顶部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(9),secondList.get(9),seckillGoodNum,seckillGoodNum,1,1,1);

                //底部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(10),secondList.get(10),normalGoodsNum,normalGoodsNum,1,4,0);
                addSeckill(list,startTime,endTime,firstList.get(11),secondList.get(11),normalGoodsNum,normalGoodsNum,2,4,0);
                addSeckill(list,startTime,endTime,firstList.get(12),secondList.get(12),normalGoodsNum,normalGoodsNum,3,4,0);
                addSeckill(list,startTime,endTime,firstList.get(13),secondList.get(13),normalGoodsNum,normalGoodsNum,4,4,0);
                addSeckill(list,startTime,endTime,firstList.get(14),secondList.get(14),normalGoodsNum,normalGoodsNum,5,4,0);
                addSeckill(list,startTime,endTime,firstList.get(15),secondList.get(15),normalGoodsNum,normalGoodsNum,6,4,0);
                addSeckill(list,startTime,endTime,firstList.get(16),secondList.get(16),normalGoodsNum,normalGoodsNum,7,4,0);
                addSeckill(list,startTime,endTime,firstList.get(17),secondList.get(17),normalGoodsNum,normalGoodsNum,8,4,0);


                startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 20:00:00";
                endTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 22:59:59";
                //顶部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(18),secondList.get(18),seckillGoodNum,seckillGoodNum,1,1,1);

                //底部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(19),secondList.get(19),normalGoodsNum,normalGoodsNum,1,4,0);
                addSeckill(list,startTime,endTime,firstList.get(20),secondList.get(20),normalGoodsNum,normalGoodsNum,2,4,0);
                addSeckill(list,startTime,endTime,firstList.get(21),secondList.get(21),normalGoodsNum,normalGoodsNum,3,4,0);
                addSeckill(list,startTime,endTime,firstList.get(22),secondList.get(22),normalGoodsNum,normalGoodsNum,4,4,0);
                addSeckill(list,startTime,endTime,firstList.get(23),secondList.get(23),normalGoodsNum,normalGoodsNum,5,4,0);
                addSeckill(list,startTime,endTime,firstList.get(24),secondList.get(24),normalGoodsNum,normalGoodsNum,6,4,0);
                addSeckill(list,startTime,endTime,firstList.get(25),secondList.get(25),normalGoodsNum,normalGoodsNum,7,4,0);
                addSeckill(list,startTime,endTime,firstList.get(26),secondList.get(26),normalGoodsNum,normalGoodsNum,8,4,0);


                startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 23:00:00";
                TimeDateUtil timeDateUtil = new TimeDateUtil(date.getTime());
                timeDateUtil.add(1);
                String yesterDay = timeDateUtil.getStrDate().substring(0, 10);
                endTime = yesterDay+" 07:59:59";
                //顶部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(27),secondList.get(27),seckillGoodNum,seckillGoodNum,1,1,1);

                //底部秒杀商品
                addSeckill(list,startTime,endTime,firstList.get(28),secondList.get(28),normalGoodsNum,normalGoodsNum,1,4,0);
                addSeckill(list,startTime,endTime,firstList.get(29),secondList.get(29),normalGoodsNum,normalGoodsNum,2,4,0);
                addSeckill(list,startTime,endTime,firstList.get(30),secondList.get(30),normalGoodsNum,normalGoodsNum,3,4,0);
                addSeckill(list,startTime,endTime,firstList.get(31),secondList.get(31),normalGoodsNum,normalGoodsNum,4,4,0);
                addSeckill(list,startTime,endTime,firstList.get(32),secondList.get(32),normalGoodsNum,normalGoodsNum,5,4,0);
                addSeckill(list,startTime,endTime,firstList.get(33),secondList.get(33),normalGoodsNum,normalGoodsNum,6,4,0);
                addSeckill(list,startTime,endTime,firstList.get(34),secondList.get(34),normalGoodsNum,normalGoodsNum,7,4,0);
                addSeckill(list,startTime,endTime,firstList.get(35),secondList.get(35),normalGoodsNum,normalGoodsNum,8,4,0);

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
        //正常商品
        List<Integer> firstList = new ArrayList();
        //秒杀商品
        List<Integer> secondList = new ArrayList();

        firstList.add(1499);
        firstList.add(2069);
        firstList.add(1983);
        firstList.add(2017);
        firstList.add(1988);
        firstList.add(1996);
        firstList.add(1824);
        firstList.add(436);
        firstList.add(1560);
        firstList.add(940);
        firstList.add(2007);
        firstList.add(1999);
        firstList.add(2010);
        firstList.add(1979);
        firstList.add(1497);
        firstList.add(1554);
        firstList.add(906);
        firstList.add(1434);
        firstList.add(913);
        firstList.add(2010);
        firstList.add(1945);
        firstList.add(2012);
        firstList.add(1541);
        firstList.add(1766);
        firstList.add(1252);
        firstList.add(1432);
        firstList.add(1592);
        firstList.add(1437);
        firstList.add(908);
        firstList.add(2014);
        firstList.add(1947);
        firstList.add(1977);
        firstList.add(1584);
        firstList.add(1369);
        firstList.add(1596);
        firstList.add(276);


        secondList.add(1722);
        secondList.add(2069);
        secondList.add(2066);
        secondList.add(2047);
        secondList.add(2067);
        secondList.add(2065);
        secondList.add(1836);
        secondList.add(1721);
        secondList.add(1650);
        secondList.add(1688);
        secondList.add(2062);
        secondList.add(2063);
        secondList.add(2060);
        secondList.add(2061);
        secondList.add(1644);
        secondList.add(1620);
        secondList.add(1602);
        secondList.add(1696);
        secondList.add(1746);
        secondList.add(2060);
        secondList.add(2059);
        secondList.add(2057);
        secondList.add(1648);
        secondList.add(1826);
        secondList.add(1693);
        secondList.add(1723);
        secondList.add(1847);
        secondList.add(1698);
        secondList.add(1695);
        secondList.add(2056);
        secondList.add(2054);
        secondList.add(2053);
        secondList.add(1799);
        secondList.add(1692);
        secondList.add(1759);
        secondList.add(1753);




        if (firstList.size() == secondList.size()){
            String date = "2018-11-24";
            List<String> list = makeSeckillGoodsData(date,date,firstList,secondList);
            printPrizeInsertSqlText(list, date +" 秒杀商品数据.sql");
        }
    }

}
