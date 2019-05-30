package net.wanho.service;

import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by Jerk on 2019/5/29.
 */
public interface StudentServiceI {
    void addStu(Student student);

    void delete(int id);

    void update(Student student);

    List<Student> selectAllStudent();
}
