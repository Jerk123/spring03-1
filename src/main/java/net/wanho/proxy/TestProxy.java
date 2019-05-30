package net.wanho.proxy;

import net.wanho.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestProxy {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        Calculator calculator = ctx.getBean(Calculator.class);
//        calculator.add(1,2);
        int minus = calculator.minus(2, 1);
        List<Student> students = calculator.getAllStudents();
        System.out.println(students);
    }
}
