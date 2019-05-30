package net.wanho.proxy;


import net.wanho.pojo.Student;
import org.apache.log4j.Logger;

import java.util.List;

public class StaticCalculatorProxy implements Calculator {

    private Logger logger = Logger.getLogger(StaticCalculatorProxy.class);


    private Calculator calculatorImpl;

    public StaticCalculatorProxy(Calculator calculatorImpl) {
        this.calculatorImpl = calculatorImpl;
    }

    @Override
    public Integer add(int a, int b) {

        logger.debug("参加运算的两个数为"+a+","+b);
        calculatorImpl.add(a,b);
        logger.debug("运算结果为:"+(a+b));

        return a + b;
    }

    @Override
    public Integer minus(int a, int b) {
        logger.debug("参加运算的两个数为"+a+","+b);
        calculatorImpl.minus(a,b);
        logger.debug("运算结果为:"+(a-b));
        return a - b;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }
}
