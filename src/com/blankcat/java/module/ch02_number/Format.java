package com.blankcat.java.module.ch02_number;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
/**
 * @author zjf
 * @Date: 2018/5/25
 * @Desc 数字格式话
 */
public class Format {
//    double f = 111231.5005;
    double f = 775910000/10000;
    double f2 = 77591%10000;

    public void m1() {
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
    /**
     * DecimalFormat转换最简便
     */
    public void m2() {
        System.out.println(f);

        DecimalFormat df = new DecimalFormat("#.0");
        df.setRoundingMode(RoundingMode.UP);
        f=f+0.1;
        System.out.println(df.format(f));
    }
    /**
     * String.format打印最简便
     */
    public void m3() {
        System.out.println(String.format("%.2f", f));
    }
    public void m4() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));
    }

    private  String removeLast0(String string) {
        if (string==null || string.length() == 0) {
            return "0";}
        try {
            while (string.charAt(string.length() - 1) == '0') {
                string = string.substring(0, string.length() - 1);
            }
            if (string.charAt(string.length() - 1) == '.') {
                string = string.substring(0, string.length() - 1);
            }
        } catch (Exception e) {
            return "";
        }
        return string;
    }

    public static void main(String[] args) {
        Format f = new Format();
//        f.m1();
        f.m2();
//        f.m3();
//        f.m4();
//        System.out.println(f.removeLast0( String.format("%.2f", f))); ;
    }
}
