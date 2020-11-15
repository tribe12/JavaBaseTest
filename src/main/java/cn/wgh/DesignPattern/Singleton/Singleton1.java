package cn.wgh.DesignPattern.Singleton;

/**
 * 饿汉模式
 */
public class Singleton1 {
    private static Singleton1 singleton = new Singleton1();

    private Singleton1() {
    }

    public Singleton1 getInstance() {
        return singleton;
    }
}



