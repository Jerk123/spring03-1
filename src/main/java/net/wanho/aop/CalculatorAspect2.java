package net.wanho.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * Created by Jerk on 2019/5/29.
 */
@Aspect//声明切面
//@Component
//@Order(1)
public class CalculatorAspect2 {
    private Logger logger=Logger.getLogger(CalculatorAspect2.class);


    //连接点 前置
//    @Before(value = "execution(* net.wanho.proxy.Calculator.add(int,int ))")
    @Before(value = "execution(* net.wanho.proxy.*.*(..))")
    public void  before(JoinPoint joinPoint){

        System.out.println("切面2");
        String methodName=joinPoint.getSignature().getName();
        logger.debug(methodName+"执行前通知，运算的参数为:"+ Arrays.toString(joinPoint.getArgs()));
    }

    //连接点后置
    @After(value = "execution(* net.wanho.proxy.Calculator.*(int,int ))")
    public void after(JoinPoint joinPoint) {
        String methodName=joinPoint.getSignature().getName();
        logger.debug(methodName+"执行后通知");
    }

    @AfterReturning(value = "execution(* net.wanho.proxy.*.*(..))",returning = "result")
    public  void AfterReturning(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.debug(methodName+"执行返回通知，结果为"+result);
    }

    @AfterThrowing(value = "execution(* net.wanho.proxy.*.*(..))",throwing = "e")
    public  void AfterThrowing(JoinPoint joinPoint,Throwable e) {
        String methodName = joinPoint.getSignature().getName();
        logger.debug(methodName+"执行异常通知，异常为"+e);
    }

    /*@Around(value = "execution(* net.wanho.proxy.*.*(..))")
    public Object Around(ProceedingJoinPoint pjp) {

        String menthodName = pjp.getSignature().getName();

        Object result = null;
        try {
            System.out.println("执行前置通知---环绕");
            //执行核心方法
            result = pjp.proceed();
            System.out.println("执行返回通知---环绕---返回的结果为" + result);
        } catch (Throwable throwable) {
            System.out.println("执行异常通知---环绕---返回的异常为" + throwable);
        }
        System.out.println("执行后通知---环绕");
        return result;
    }*/

}
