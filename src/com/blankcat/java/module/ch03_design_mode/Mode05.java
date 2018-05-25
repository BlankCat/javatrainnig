package com.blankcat.java.module.ch03_design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjf
 * @Date: 2018/5/25
 * @Desc 迪米特法则---低耦合，高内聚
 *
 * 迪米特法则时要反复权衡，既做到结构清晰，又要高内聚低耦合
 * 类与类之间的关系越密切，耦合度越大，当一个类发生改变时，对另一个类的影响也越大。
 *
 * 尽量降低类与类之间的耦
 * 低耦合，高内聚
 *
 * 对于被依赖的类来说，无论逻辑多么复杂，
 * 都尽量地的将逻辑封装在类的内部，
 * 对外除了提供的public方法，不对外泄漏任何信息
 *
 *
 * 什么是直接的朋友：每个对象都会与其他对象有耦合关系，
 * 只要两个对象之间有耦合关系，我们就说这两个对象之间是朋友关系
 *
 * 耦合的方式很多，依赖、关联、组合、聚合等
 *
 * 我们称出现成员变量、方法参数、方法返回值中的类为直接的朋友
 * 而出现在局部变量中的类则不是直接的朋友。
 * 也就是说，
 * 陌生的类最好不要作为局部变量的形式出现在类的内部
 *
 */
public class Mode05 {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.printAllEmployee(new SubEmployeeManager());
    }
}

//总公司员工
class Employee{
    private int id;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
//分公司员工
class SubEmployee{
    private int id;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}

class SubEmployeeManager{
    public List<SubEmployee> getSubEmployee(){
        List<SubEmployee> list = new ArrayList<>();
        for (int i=0;i<100;i++){
            SubEmployee employee = new SubEmployee();
            employee.setId(i);
            list.add(employee);
        }
        return list;
    }
    public void printAllEmployee(){
        List<SubEmployee> subEmployeeList = this.getSubEmployee();
        for (SubEmployee item: subEmployeeList) {
            System.out.println("分公司"+item.getId());
        }
    }

}

class EmployeeManager{
    public List<Employee> getEmployee(){
        List<Employee> list = new ArrayList<>();
        for (int i=0;i<100;i++){
            Employee employee = new Employee();
            employee.setId(i);
            list.add(employee);
        }
        return list;
    }

    public void printAllEmployee(SubEmployeeManager sub){
        sub.printAllEmployee();
        List<Employee> employeeList = this.getEmployee();
        for (Employee item: employeeList) {
            System.out.println("总公司"+item.getId());
        }
    }
}
/*
下面的写法违反耦合性
class SubEmployeeManager{
    public List<SubEmployee> getSubEmployee(){
        List<SubEmployee> list = new ArrayList<>();
        for (int i=0;i<100;i++){
            SubEmployee employee = new SubEmployee();
            employee.setId(i);
            list.add(employee);
        }
        return list;
    }
}

class EmployeeManager{
    public List<Employee> getEmployee(){
        List<Employee> list = new ArrayList<>();
        for (int i=0;i<100;i++){
            Employee employee = new Employee();
            employee.setId(i);
            list.add(employee);
        }
        return list;
    }

    public void printAllEmployee(SubEmployeeManager sub){
        List<SubEmployee> subEmployeeList = sub.getSubEmployee();
        for (SubEmployee item: subEmployeeList) {
            System.out.println("分公司"+item.getId());
        }

        List<Employee> employeeList = this.getEmployee();
        for (Employee item: employeeList) {
            System.out.println("总公司"+item.getId());
        }
    }
}
*/
