package net.wanho.proxy;

import net.wanho.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorImpl implements Calculator {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer add(int a, int b) {

        System.out.println(a+b);
        return a + b;

    }

    @Override
    public Integer minus(int a, int b) {

        System.out.println(a-b);
        return a - b;
    }

    @Override
    public List<Student> getAllStudents() {
        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> students = jdbcTemplate.query("select * from student", rowMapper);
        return students;
    }


}
