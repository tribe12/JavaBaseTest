package cn.wgh.designpattern.structural.proxy.spring.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wgh on 2021/3/19.
 */
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-aop-test-1.xml");
        Tank tank = (Tank)applicationContext.getBean("tank");
        tank.move();
    }


}
