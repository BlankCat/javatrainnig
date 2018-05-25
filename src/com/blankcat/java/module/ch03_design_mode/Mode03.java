package com.blankcat.java.module.ch03_design_mode;

/**
 * @author zjf
 * @Date: 2018/5/25
 * @Desc 依赖倒置原则
 * 核心思想是面向接口编程，
 */
public class Mode03 {

    /**
     * 低层模块尽量都要有抽象类或接口，或者两者都有。
     * 变量的声明类型尽量是抽象类或接口。
     * 使用继承时遵循里氏替换原则。[不要随便重写父类方法]
     */
    public static void main(String[] args) {
        //无论以后怎样扩展Client类(Mode03就是Client类)，都不需要再修改Mother类了
        /**
         * 代表高层模块的Mother类将负责完成主要的业务逻辑，
         * 一旦需要对它进行修改，
         * 引入错误的风险极大。
         * 所以遵循依赖倒置原则可以降低类之间的耦合性，
         * 提高系统的稳定性，
         * 降低修改程序造成的风险。
         */
        Mother mother = new Mother();
        System.out.println("妈妈开始讲故事！");
        mother.narrate(new Book());
        System.out.println("妈妈开始讲新闻！");
        mother.narrate(new News());
    }
}

/**
 *
 */
interface IReader{
    String getContent();
}
class Book implements IReader{
    @Override
    public String getContent() {
        return "这是一个很长很长的故事。。。";
    }
}
class News implements IReader{
    @Override
    public String getContent() {
        return "今天的新闻里面，NBA很精彩";
    }
}

class Mother{
    /**
     * reader 接口可以是任何接口实现News/Book...
     * @param reader
     */
    public void narrate(IReader reader){
        System.out.println(reader.getContent());
    }
    /**
     * 接口回掉
     * 传递依赖关系有三种方式，
     * 1以上的例子中使用的方法是接口传递，
     * 另外还有两种传递方式：2 构造方法传递和 3 setter方法传递，
     */
    //传递依赖关系有三种方式，以上的例子中使用的方法是接口传递，另外还有两种传递方式：构造方法传递和setter方法传递，
}

/**
 * 传递依赖关系有三种方式
 * 方式二
 * 构造函数传递接口
 */
class Mother02{
    private IReader iReader;
    public Mother02(IReader iReader){
        this.iReader = iReader;
    }
    public void narrate(){
        if(iReader!=null){
            System.out.println(iReader.getContent());
        }
    }
}

/**
 * 传递依赖关系有三种方式
 * 方式三
 * setter方法传递，
 */
class Mother03{
    private IReader iReader;

    public void setiReader(IReader reader){
        this.iReader = reader;
    }
    public IReader getiReader(){
        return iReader;
    }
    public void narrate(){
        if(iReader!=null){
            System.out.println(iReader.getContent());
        }
    }
}