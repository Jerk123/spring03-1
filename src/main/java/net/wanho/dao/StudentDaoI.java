package net.wanho.dao;

import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by Jerk on 2019/5/29.
 */
public interface StudentDaoI {
    void addStu(Student student);

    void delete(int id);

    void update(Student student);

    List<Student> selectAllStudent();
}
