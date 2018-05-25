package com.blankcat.java.module.ch02_number;

import java.text.DecimalFormat;

/**
 * @author zjf
 * @Date: 2018/5/25
 * @Desc
 */
public class Number {
    public static void main(String[] args) {
//        int num = 21001;
        double num = 20000001001l;
        double i = num/10000;
        System.out.println(m2(i)+"万");
    }
    public static String m2(double f) {
//      DecimalFormat df = new DecimalFormat("#.00");
      DecimalFormat df = new DecimalFormat("#.0");
      System.out.println(df.format(f));
      return df.format(f);
    }
}
