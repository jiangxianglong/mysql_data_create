package mytest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author jiangxianglong
 * @date 2018/8/30  下午8:09
 */
public class Test {
    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal(100033);
        System.out.println(bigDecimal.divide(new BigDecimal(100),2,RoundingMode.HALF_UP));
    }
}
