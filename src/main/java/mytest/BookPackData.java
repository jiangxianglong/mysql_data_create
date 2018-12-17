package mytest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/8/3  下午7:50
 */
public class BookPackData {
    /**
     * 生成图书包数据 数据
     */
    private static List<String> makeBookPackData() {
        List<String> list = new ArrayList<>();
        try {
            Date beginDate = TimeDateUtil.sdfYYYYMMDD.parse("2018-08-09");
            Date endDate = TimeDateUtil.sdfYYYYMMDD.parse("2018-09-08");
            List<Date> dateList = TimeDateUtil.findDates(beginDate, endDate);


            for (Date date : dateList) {
                String startTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 00:00:00";
                String endTime = TimeDateUtil.sdfYYYYMMDD.format(date)+" 23:59:59";


                /**
                 非图书包用户
                 【1】购买即送iPhone X
                 哈佛妈妈+北大妈妈+美国麻省STEAM三旗舰图书包

                 【2】购买即送iPhone 8
                 哈佛妈妈+北大妈妈双旗舰图书包

                 【3】购买即送iPad
                 哈佛妈妈、北大妈妈、美国麻省STEAM任一旗舰图书包

                 【4】购买即送Kindle
                 哈佛妈妈、北大妈妈、美国麻省STEAM任一标准旗舰包


                 图书包用户

                 【1】升级即送iPhone X
                 哈佛、北大标准包升级三旗舰图书包

                 【2】升级即送iPhone 8
                 哈佛、北大标准包升级双旗舰图书包

                 【3】升级即送iPad
                 哈佛、北大妈妈标准包升级旗舰包

                 测试地址
                 【1】升级即送iPhone X  ：2018/08/05/1533459074071.png
                 【2】升级即送iPhone 8  ：2018/08/07/1533616297198.png
                 【3】升级即送iPad      ：2018/08/05/1533459132046.png
                 【4】购买即送Kindle    : 2018/08/05/1533459143894.png

                 线上地址
                 String iphonX = "2018/08/07/1533635444770.png";
                 String iphone8 = "2018/08/07/1533643391643.png";
                 String ipad = "2018/08/07/1533635482220.png";
                 String kindle = "2018/08/07/1533643364582.png";
                 */
                String iphonX = "2018/08/07/1533647994143.png";//     2018/08/10/1533909190747.png
                String iphone8 = "2018/08/07/1533648015021.png";//    2018/08/10/1533909212068.png
                String ipad = "2018/08/07/1533648044835.png"; //    2018/08/10/1533909246034.png
                String kindle = "2018/08/07/1533648066415.png";//   2018/08/10/1533909258333.png

                //图书包用户
                addBookPack(list,1,"升级即送iPhone X","哈佛、北大标准包升级三旗舰图书包",iphonX,startTime,endTime,30,30,2);
                addBookPack(list,1,"升级即送iPhone 8","哈佛、北大标准包升级双旗舰图书包",iphone8,startTime,endTime,30,30,3);
                addBookPack(list,1,"升级即送iPad","哈佛、北大妈妈标准包升级旗舰包",ipad,startTime,endTime,30,30,4);

                //非图书包用户
                addBookPack(list,2,"购买即送iPhone X","哈佛妈妈+北大妈妈+美国麻省STEAM\n三旗舰图书包",iphonX,startTime,endTime,30,30,1);
                addBookPack(list,2,"购买即送iPhone 8","哈佛妈妈+北大妈妈\n双旗舰图书包",iphone8,startTime,endTime,30,30,2);
                addBookPack(list,2,"购买即送iPad","哈佛妈妈、北大妈妈、美国麻省STEAM\n任一旗舰图书包",ipad,startTime,endTime,30,30,3);
                addBookPack(list,2,"购买即送Kindle","哈佛妈妈、北大妈妈、美国麻省STEAM\n任一标准图书包",kindle,startTime,endTime,30,30,4);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    /**
     * 添加图书包数据
     * @param list
     * @param bookPackName
     * @param bookPackImg
     * @param startTime
     * @param endTime
     * @param num
     * @param residueNum
     * @param sortLoc
     */
    private static void addBookPack(List<String> list,Integer type,String bookPackName,String desc,String bookPackImg,String startTime,String endTime,Integer num,Integer residueNum,Integer sortLoc){
        String sql= "INSERT INTO `activity_anniversary_book_pack` (`ID`,`STATUS`,`TYPE`,`BOOK_PACK_NAME`,`DESC`,`NUM`,`IMG`,`RESIDUE_NUM`,`BEGIN_TIME`,`END_TIME`,`SORT_LOC`)" +
                " VALUES" +
                " (NULL,1,"+type+",'"+bookPackName+"','"+desc+"',"+num+",'"+bookPackImg+"',"+residueNum+",'"+startTime+"','"+endTime+"',"+sortLoc+");";
        list.add(sql);
    }

    public static void main(String[] args) {
        List<String> list = makeBookPackData();
        PrintData.printPrizeInsertSqlText(list, "8.9-9.8图书包数据"+PrintData.getNows()+".sql");
    }
}
