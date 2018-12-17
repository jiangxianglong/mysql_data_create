package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangxianglong
 * @date 2018/11/9  下午3:06
 */
public class MyTest {

    public static void main(String[] args) {


        List<String> prize = new ArrayList<>();
        List<String> userPrize = new ArrayList<>();


        prize.add("368"); userPrize.add("692");
        prize.add("369"); userPrize.add("693");
        prize.add("373"); userPrize.add("694");
        prize.add("372"); userPrize.add("695");
        prize.add("371"); userPrize.add("696");
        prize.add("370"); userPrize.add("697");
        prize.add("376"); userPrize.add("698");
        prize.add("374"); userPrize.add("699");
        prize.add("381"); userPrize.add("700");
        prize.add("380"); userPrize.add("701");
        prize.add("379"); userPrize.add("702");
        prize.add("402"); userPrize.add("703");
        prize.add("401"); userPrize.add("704");
        prize.add("397"); userPrize.add("705");
        prize.add("395"); userPrize.add("706");
        prize.add("387"); userPrize.add("707");
        prize.add("389"); userPrize.add("708");
        prize.add("399"); userPrize.add("709");
        prize.add("386"); userPrize.add("710");
        prize.add("385"); userPrize.add("711");
        prize.add("400"); userPrize.add("712");
        prize.add("394"); userPrize.add("714");
        prize.add("388"); userPrize.add("715");
        prize.add("391"); userPrize.add("716");
        prize.add("392"); userPrize.add("717");
        prize.add("393"); userPrize.add("718");
        prize.add("390"); userPrize.add("719");
        prize.add("398"); userPrize.add("720");
        prize.add("396"); userPrize.add("721");
        prize.add("382"); userPrize.add("722");
        prize.add("383"); userPrize.add("723");
        prize.add("384"); userPrize.add("724");
        prize.add("378"); userPrize.add("725");
        prize.add("377"); userPrize.add("726");
        prize.add("375"); userPrize.add("727");
        prize.add("267"); userPrize.add("728");
        prize.add("347"); userPrize.add("729");
        prize.add("344"); userPrize.add("730");
        prize.add("324"); userPrize.add("731");
        prize.add("322"); userPrize.add("732");
        prize.add("321"); userPrize.add("733");
        prize.add("312"); userPrize.add("734");
        prize.add("309"); userPrize.add("735");
        prize.add("275"); userPrize.add("736");


        int i=0;
        for (String s : prize) {

            System.out.println("UPDATE  activity_fan_festival_prize set TASK_PRIZE_ID = "+userPrize.get(i)+" WHERE PRIZE_ID = "+prize.get(i)+";");

            i++;
        }

    }
}
