package mytest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/8/3  下午7:51
 */
public class PrintData {
    /***
     * 写文件
     * @param list
     * @param path
     */
    public static void printPrizeInsertSqlText(List<String> list, String path) {
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f=new File(path);
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

    public static String getNows(){
        TimeDateUtil timeDateUtil = new TimeDateUtil();
        String nowTimes = timeDateUtil.getYYMMDD(new Date())+" "+timeDateUtil.getDateHHMM(new Date());
        return nowTimes;
    }
}
