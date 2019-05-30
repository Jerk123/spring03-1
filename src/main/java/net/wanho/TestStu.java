package net.wanho;

import net.wanho.service.StudentServiceI;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Jerk on 2019/5/29.
 */
public class TestStu {

    @Test
    public void testTranscation() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        StudentServiceI studentServiceI = ctx.getBean(StudentServiceI.class);
        studentServiceI.addStu();

    }
}
