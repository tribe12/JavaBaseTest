package cn.wgh.design-pattern.creation.singletion;

/**
 * 单例模式——懒汉模式
 */
public class Singleton2 {
    private static Singleton2 singleton = null;

    public static synchronized Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
