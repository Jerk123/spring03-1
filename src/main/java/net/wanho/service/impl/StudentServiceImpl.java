package net.wanho.service.impl;

import net.wanho.dao.StudentDaoI;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jerk on 2019/5/29.
 */
@Service
public class StudentServiceImpl implements StudentServiceI {

    @Autowired
    private StudentDaoI studentDaoI;

    @Override
    public void addStu(Student student) {
        studentDaoI.addStu(student);
    }

    @Override
    public void delete(int id) {
        studentDaoI.delete(id);
    }

    @Override
    public void update(Student student) {
        studentDaoI.update(student);
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = studentDaoI.selectAllStudent();
        return students;
    }
}
