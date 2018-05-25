package com.blankcat.java.module.ch03_design_mode;

/**
 * @author zjf
 * @Date: 2018/5/25
 * @Desc 里氏替换原则
 *  子类可以扩展父类的功能，但不能改变父类原有的功能
 *  子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法
 *  子类中可以增加自己特有的方法。
 *  当子类的方法重载父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松
 *  当子类的方法实现父类的抽象方法时，方法的后置条件（即方法的返回值）要比父类更严格。
 */
public class Mode02 {

    /**
     * 默认A提供的功能
     */
    public  static  class  A{

        public int  func01(int a,int b){
            return a-b;
        }

//        public int  func02(int a,int b){
//            return a-b;
//        }
//        public int  func03(int a,int b){
//            return a*b;
//        }
//        public int  func04(int a,int b){
//            return a/b;
//        }
    }

    public  static  class  B extends A{
        public int  func02(int a,int b){
            return a+b;
        }

    }

    public static void main(String[] args) {

    }
}
