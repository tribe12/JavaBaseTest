package cn.wgh.enumTest;

import org.junit.Test;

public class EnumTest {
    @Test
    public void testName() throws Exception {
        System.out.println(EnumDomain.MAN);
        System.out.println(EnumDomain.MAN.name());

        System.out.println(AttachmentEnum.LEAVE);
        System.out.println(AttachmentEnum.SIGN_RECORD);
        System.out.println(AttachmentEnum.LEAVE.toString());
        System.out.println(AttachmentEnum.SIGN_RECORD.getValue());
        System.out.println(AttachmentEnum.SIGN_RECORD.getKey());
        System.out.println(AttachmentEnum.valueOf("LEAVE"));


    }

    /**
     * 枚举常用方法values()：可以将枚举类型成员以数组的形式返回
     *
     * @throws Exception
     */
    @Test
    public void valuesTest() throws Exception {
        Constants2[] cc = Constants2.values();
        for (int i = 0; i < cc.length; i++) {
            // 打印枚举成员变量
            System.out.println("枚举成员变量:" + cc[i]);
        }
    }

    /**
     * 枚举常用方法valueOf()：可以实现将普通字符串转换为枚举实例
     *
     * @throws Exception
     */
    @Test
    public void valueOfTest() throws Exception {
//		System.out.println(Constants2.valueOf("BBB"));//错误
//		System.out.println(Constants2.valueOf("Constants2"));//错误
        System.out.println(Constants2.valueOf("CONSTANTS_B"));
        Constants2 aaa = Constants2.valueOf("CONSTANTS_A");
        System.out.println(aaa);
    }


    /**
     * 枚举常用方法compareTo()：比较两个枚举对象在定义时的顺序
     *
     * @throws Exception
     */
    @Test
    public void comTest() throws Exception {
        int i = Constants2.CONSTANTS_A.compareTo(Constants2.CONSTANTS_B);
        System.out.println(i);
        System.out.println(Constants2.CONSTANTS_A.compareTo(Constants2.CONSTANTS_A));
        System.out.println(Constants2.CONSTANTS_B.compareTo(Constants2.CONSTANTS_A));
    }


    /**
     * 枚举常用方法ordinal()：得到枚举成员的位置索引
     *
     * @throws Exception
     */
    @Test
    public void ordinalTest() throws Exception {
        Constants2[] cc = Constants2.values();
        for (int i = 0; i < cc.length; i++) {
            // 打印枚举成员的索引位置
            System.out.println("枚举成员变量" + cc[i] + "的索引位置：" + cc[i].ordinal());
        }
    }

    @Test
    public void constants3Test() throws Exception {
        Constants3[] cc = Constants3.values();
        for (int i = 0; i < cc.length; i++) {
            System.out.println(cc[i] + "调用getDescription()方法为：" + cc[i].getDescription());
            System.out.println(cc[i] + "调用getI()方法为：" + cc[i].getI());
        }
        System.out.println("------");
        System.out.println(Constants3.CONSTANTS_A);
        System.out.println(Constants3.CONSTANTS_B);
        System.out.println(Constants3.CONSTANTS_C);
        System.out.println(Constants3.CONSTANTS_D);

        System.out.println("======");

        Constants3 c1 = Constants3.valueOf("CONSTANTS_A");
        Constants3 c2 = Constants3.valueOf("CONSTANTS_B");
        Constants3 c3 = Constants3.valueOf("CONSTANTS_C");
        Constants3 c4 = Constants3.valueOf("CONSTANTS_D");

        System.out.println(c1 + "调用getDescription()方法为：" + c1.getDescription());
        System.out.println(c2 + "调用getDescription()方法为：" + c2.getDescription());
        System.out.println(c3 + "调用getDescription()方法为：" + c3.getDescription());
        System.out.println(c4 + "调用getDescription()方法为：" + c4.getDescription());

        System.out.println(c1 + "调用getI()方法为：" + c1.getI());
        System.out.println(c2 + "调用getI()方法为：" + c2.getI());
        System.out.println(c3 + "调用getI()方法为：" + c3.getI());
        System.out.println(c4 + "调用getI()方法为：" + c4.getI());

    }

    @Test
    public void diTest() throws Exception {
        DiEnum[] dis = DiEnum.values();
        for (int i = 0; i < dis.length; i++) {
            System.out.println(dis[i] + "调用getDescription()方法为：" + dis[i].getDescription());
            System.out.println(dis[i] + "调用getI()方法为：" + dis[i].getI());
        }
    }

    @Test
    public void di2Test() throws Exception {
        DiEnum2[] dis = DiEnum2.values();
        for (int i = 0; i < dis.length; i++) {
            System.out.println(dis[i] + "调用getDescription()方法为：" + dis[i].getDescription());
            System.out.println(dis[i] + "调用getI()方法为：" + dis[i].getI());
        }
    }
}
