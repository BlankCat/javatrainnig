package com.blankcat.java.module.ch05_ser;

import java.io.*;

/**
 * @author zjf
 * @Date: 2018/5/30
 * @Desc 序列化
 * http://developer.51cto.com/art/201202/317181.htm
 */
public class SimpleSerial {
    public static void main(String[] args) throws Exception {
//        File file = new File("person.out");
//        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(file));
//        Person person = new Person("zjf",25,Gender.MALE);
//        out.writeObject(person);
//        out.close();
//        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
//        Object newPerson = oin.readObject(); // 没有强制转换到Person类型
//        oin.close();
//        System.out.println(newPerson);


        File file = new File("person.out");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        oout.writeObject(Person.getInstance()); // 保存单例对象
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject();
        oin.close();
        System.out.println(newPerson);

        System.out.println(Person.getInstance() == newPerson); // 将获取的对象与Person类中的单例对象进行相等性比较

    }
}
//Externalizable
class Person implements Serializable  {
    private static class InstanceHolder {
        private static final Person instatnce = new Person("John", 31, Gender.MALE);
    }

    public static Person getInstance() {
        return InstanceHolder.instatnce;
    }

    private String name;
    transient  private int age;
    private Gender gender;
    private Person(){
        System.out.println("call 无参构造");
    }
    private Person(String name,int age,Gender gender){
        System.out.println("call 有参构造");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public Gender getGender(){
        return this.gender;
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(age);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        age = in.readInt();
    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//
//    }

    @Override
    public String toString() {
        return "["+name+","+age+","+gender+"]";
    }
}
enum Gender{
    MALE,FEMALE;
}