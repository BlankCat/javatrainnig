package com.blankcat.java.module.ch03_design_mode;

/**
 * @author zjf
 * @Date: 2018/5/25
 * @Desc 单一职责原则
 */
public class Mode01 {


    public static class Anim01{
        public  void breathe(String anim){
            System.out.println(anim+"呼吸空气");
        }
    }

    public static class Anim02{
        public  void breathe(String anim){
            if("鱼".equals(anim)){
                System.out.println(anim+"呼吸水");
            }else {
                System.out.println(anim+"呼吸空气");
            }

        }
    }

    /**
     *  方法级别的单一职责
     *  可以降低类的复杂度
     *  提高可读性
     */
    public static class Anim03{
        public  void breathe(String anim){
                System.out.println(anim+"呼吸空气");
        }
        public  void breathe2(String anim){
                System.out.println(anim+"呼吸水");
        }

    }


    public static void main(String[] args) {
//        Anim01 anim= new Anim01();
//        Anim02 anim= new Anim02();
        Anim03 anim= new Anim03();
        anim.breathe("羊");
        anim.breathe("牛");
        anim.breathe2("鱼");
    }
}
