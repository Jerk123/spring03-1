package net.wanho.proxy;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicCalculatorProxy {

    private Logger logger = Logger.getLogger(DynamicCalculatorProxy.class);


    //    委托类
    private Object target;


    public DynamicCalculatorProxy(Object target) {
        this.target = target;
    }

    public DynamicCalculatorProxy() {
    }


    public Object createProxy() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

            /**
             *
             * @param proxy  代理类
             * @param method  方法
             * @param args   方法中的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                logger.debug("参加运算的两个数为" + args[0] + "," + args[1]);

                Object res = method.invoke(target, args);

                logger.debug("运算结果为:");


                return res;
            }
        });


    }


}
