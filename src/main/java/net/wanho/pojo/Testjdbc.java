package net.wanho.pojo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Created by Jerk on 2019/5/29.
 */
public class Testjdbc {

    private JdbcTemplate jdbcTemplate;

//    在执行所有的测试方法之前执行
    @Before
    public void getJdbcTemplate() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);

    }

    @Test
    public void testAdd() {
        jdbcTemplate.update("insert into student values(null,?,?,?,?)","java129",11,"男","南京");
    }

    @Test
    public void testUpdate() {
        jdbcTemplate.update("update student set address=? WHERE sname=?", "上海", "java127");
    }

    @Test
    public void testQuertAll() {

        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> students = jdbcTemplate.query("select * from student", rowMapper);
        System.out.println(students);
    }
}
