package net.wanho.proxy;

import net.wanho.pojo.Student;

import java.util.List;

public interface Calculator {

    Integer add(int a, int b);

    Integer minus(int a, int b);

    List<Student> getAllStudents();
}
