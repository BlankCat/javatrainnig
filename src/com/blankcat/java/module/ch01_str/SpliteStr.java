package com.blankcat.java.module.ch01_str;

/**
 * @author zjf
 * @Date: 2018/5/25
 * @Desc 字符串分割
 */
public class SpliteStr {
    public static void main(String[] args) {
        splite();
//        splite01();
//        splite02();
//        splite03();
    }

    private static void splite() {
        String line = "aa,bb,cc,dd,,,,";
        String[] strs=line.split(",");
        int i=0;
        for (String str:strs ) {
            System.out.println(i+"--"+str);
            i++;
        }
       // 输出结果为6,limit参数指定几个，输出几个，最多为8个
    }
      private static void splite01() {
        String line = "aa,bb,cc,dd,,,,";
        String[] strs=line.split(",",6);
        int i=0;
        for (String str:strs ) {
            System.out.println(i+"--"+str);
            i++;
        }
       // 输出结果为6,limit参数指定几个，输出几个，最多为8个
    }


      private static void splite02() {
          String line = "aa,bb,cc,dd,,,,";
          String[] strs=line.split(",",0);
          int i=0;
        for (String str:strs ) {
            System.out.println(i+"--"+str);
            i++;
        }
        // 2.当参数为零的时候，和split()一样，
    }
    private static void splite03() {
          String line = "aa,bb,cc,dd,,,,";
          String[] strs=line.split(",",-1);
          int i=0;
        for (String str:strs ) {
            System.out.println(i+"--"+str);
            i++;
        }
        //  3.当参数为负的时候，即使后面有空的串，也会输出到最大
    }



}
