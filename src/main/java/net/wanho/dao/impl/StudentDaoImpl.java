package net.wanho.dao.impl;

import net.wanho.dao.StudentDaoI;
import net.wanho.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jerk on 2019/5/29.
 */
@Repository
public class StudentDaoImpl implements StudentDaoI{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);


    @Override
    public void addStu(Student student) {
        jdbcTemplate.update("insert into student values(null,?,?,?,?)", student.getSname(), student.getAge(),
                student.getAge(), student.getGender(), student.getAddress());
        System.out.println("add----Success");
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from student where id=?",id);
        System.out.println("delete----Success");
    }

    @Override
    public void update(Student student) {
            jdbcTemplate.update("update student set sname=?,age=?,gender=?,address=? WHERE id=?",
                    student.getSname(), student.getAge(),
                    student.getAge(), student.getGender(), student.getAddress(),student.getId());
        System.out.println("update----Success");
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = jdbcTemplate.query("select * from student", rowMapper);
        System.out.println("select----Success");
        return students;

    }
}
