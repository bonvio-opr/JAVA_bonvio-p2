package test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ivan on 17.12.2014.
 */
public class TestValuta {



    public static void main(String[] args) {
        Date date = new Date();

        double a = 1.8;
        double b = 0.2;
        double c = a + b;

        System.out.println("c=" + c);
        System.out.println("(a + b)=" + (a + b));

        BigDecimal sum = new BigDecimal(01231233.1);
        BigDecimal sum2 = new BigDecimal(0.1);
        for (int i = 0; i < 10; i++) {
            sum = sum.add(sum2);
        }
        System.out.println("sum="+sum);

        BigDecimal sum3 = new BigDecimal("1.55");
        System.out.println("sum3="+sum3);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("date=" + (new Date().getTime() - date.getTime()));


    }
}
