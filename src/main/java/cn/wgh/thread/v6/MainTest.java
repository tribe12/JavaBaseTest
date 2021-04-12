package cn.wgh.thread.v6;

import java.util.Random;

/**
 * ThreadLocal类及应用技巧
 *
 * Created by wgh on 2021/4/12.
 */
public class MainTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String name = "姓名_" + new Random().nextInt();
                    int age = new Random().nextInt(100);
                    double score = new Random().nextDouble();

                    Student.getThreadInstance().setName(name);
                    Student.getThreadInstance().setAge(age);
                    Student.getThreadInstance().setScore(score);

                    System.out.println(Thread.currentThread().getName() + " put name:" + name + " age:" + age + " score:" + score);

                    new A().getData();
                    new B().getData();
                }
            }).start();
        }
    }


    static class A {
        public void getData() {
            System.out.println("A from " + Thread.currentThread().getName() + " get data:" + Student.getThreadInstance().toString());

        }
    }

    static class B {
        public void getData() {
            System.out.println("B from " + Thread.currentThread().getName() + " get data:" + Student.getThreadInstance().toString());
        }
    }
}
