package cn.wgh.finaltest;

import java.util.Random;

/**
 * 从本例可以看出，定义为final的常量不是恒定不变的，将随机数赋予定
 * 义为final的常量，可以做到每次运行程序时改变a1的值。但是a2与a1不
 * 同，由于它被声明为static final形式，所以在内存中为a2开辟了一个
 * 恒定不变的区域，当再次实例化一个FinalStaticData对象时，仍然指向
 * a2这块内存区域，所以a2的值保持不变。
 * a2是在装载时被初始化，而不是每次创建新对象时都被初始化；
 * 而a1会在重新实例化对象时被更改。
 * <p>
 * Created by wgh on 2020/12/23.
 */
public class FinalStaticData {
    private static Random random = new Random();
    private final int a1 = random.nextInt(10);
    private static final int a2 = random.nextInt(10);

    public static void main(String[] args) {
        FinalStaticData fsData = new FinalStaticData();
        System.out.println("重新实例化对象调用a1的值：" + fsData.a1);
        System.out.println("重新实例化对象调用a2的值：" + fsData.a2);
        FinalStaticData fsdata2 = new FinalStaticData();
        System.out.println("重新实例化对象调用a1的值：" + fsdata2.a1);
        System.out.println("重新实例化对象调用a2的值：" + fsdata2.a2);
    }

}
