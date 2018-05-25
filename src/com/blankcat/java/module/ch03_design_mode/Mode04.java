package com.blankcat.java.module.ch03_design_mode;

/**
 * @author zjf
 * @Date: 2018/5/25
 * @Desc 接口隔离原则
 *
 * 建立单一接口，
 * 不要建立庞大臃肿的接口，
 * 尽量细化接口，
 * 接口中的方法尽量少。
 *
 * 接口是设计时对外部设定的“契约”，
 * 通过分散定义多个接口，
 * 可以预防外来变更的扩散，
 * 提高系统的灵活性和可维护性。
 */
public class Mode04 {
    /**
     * 1接口尽量小，但是要有限度。
     * 对接口进行细化可以提高程序设计灵活性是不挣的事实，
     * 但是如果过小，则会造成接口数量过多，
     * 使设计复杂化。所以一定要适度。
     *
     * 2为依赖接口的类定制服务，只暴露给调用的类它需要的方法，
     * 它不需要的方法则隐藏起来。只有专注地为一个模块提供定制服务，
     * 才能建立最小的依赖关系。
     *
     * 3提高内聚，减少对外交互。
     * 使接口用最少的方法去完成最多的事情。
     *
     */

    /**
     * 很多人会觉的接口隔离原则跟之前的单一职责原则很相似，其实不然。
     * 其一，单一职责原则原注重的是职责；
     * 而接口隔离原则注重对接口依赖的隔离。
     * 其二，单一职责原则主要是约束类，其次才是接口和方法，它针对的是程序中的实现和细节；
     * 而接口隔离原则主要约束接口接口，主要针对抽象，针对程序整体框架的构建。
     */
    public static void main(String[] args) {
        A a = new A();
        a.depend01(new B());
        a.depend02(new B());
        a.depend03(new B());
        a.depend04(new B());

        C c = new C();
        c.depend01(new D());
        c.depend02(new D());
        c.depend03(new D());

    }
}
//最优设计
interface I1{
    public void method01();
}
interface I2{
    public void method02();
    public void method03();
}
interface I3{
    public void method04();
    public void method05();
}
 class A{
    public void depend01(I1 i){
        i.method01();
    }
    public void depend02(I2 i){
        i.method02();
    }
    public void depend03(I2 i){
        i.method03();
    }
    public void depend04(I3 i){
        i.method04();
    }
}

class B implements I1,I2,I3 {
    @Override
    public void method01() {
        System.out.println("B类对I接口实现method01");
    }
    @Override
    public void method02() {
        System.out.println("B类对I接口实现method02");
    }
    @Override
    public void method03() {
    }
    @Override
    public void method04() {
    }
    @Override
    public void method05() {
    }
}

class C {
    public void depend01(I1 i){
        i.method01();
    }
    public void depend02(I3 i){
        i.method04();
    }
    public void depend03(I3 i){
        i.method05();
    }
}

class D implements I1,I3{
    @Override
    public void method01() {
        System.out.println("D对I1接口实现method01");
    }

    @Override
    public void method04() {
        System.out.println("D对I3接口的实现method04");
    }

    @Override
    public void method05() {
        System.out.println("D对接口I3的实现method05");
    }
}





///**
// * 如果接口过于臃肿，
// * 只要接口中出现的方法，
// * 不管对依赖于它的类有没有用处，
// * 实现类中都必须去实现这些方法，
// * 这显然不是好的设计。
// */
//interface I{
//    public void method01();
//    public void method02();
//    public void method03();
//    public void method04();
//    public void method05();
//}
//
// class A{
//    public void depend01(I i){
//        i.method01();
//    }
//    public void depend02(I i){
//        i.method02();
//    }
//    public void depend03(I i){
//        i.method03();
//    }
//    public void depend04(I i){
//        i.method04();
//    }
//}
//
//class B implements I{
//    @Override
//    public void method01() {
//        System.out.println("B类对I接口实现method01");
//    }
//
//    @Override
//    public void method02() {
//        System.out.println("B类对I接口实现method02");
//
//    }
//
//    @Override
//    public void method03() {
//        System.out.println("B类对I接口实现method03");
//    }
//
//    @Override
//    public void method04() {
//
//    }
//    @Override
//    public void method05() {
//
//    }
//}
//
///**==============================================*/
//
//class C {
//    public void depend01(I i){
//        i.method01();
//    }
//    public void depend02(I i){
//        i.method04();
//    }
//    public void depend03(I i){
//        i.method05();
//    }
//}
//
//class D implements I{
//    @Override
//    public void method01() {
//        System.out.println("D类对I接口实现method01");
//    }
//    @Override
//    public void method02() {
//    }
//    @Override
//    public void method03() {
//    }
//    @Override
//    public void method04() {
//        System.out.println("D类对I接口实现method04");
//    }
//    @Override
//    public void method05() {
//        System.out.println("D类对I接口实现method05");
//    }
//}