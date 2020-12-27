package cn.wgh.enumTest;

/**
 * Created by wgh on 2020/12/27.
 */
public enum Constants3 {
    CONSTANTS_A("我是枚举成员A"),
    CONSTANTS_B("我是枚举成员B"),
    CONSTANTS_C("我是枚举成员C"),
    CONSTANTS_D(3);

    private String description;
    private int i = 1;

    private Constants3() {
    }

    private Constants3(String description) {
        this.description = description;
    }

    private Constants3(int i) {
        this.i = i;
    }

    public String getDescription() {
        return description;
    }

    public int getI() {
        return i;
    }

    public static void main(){
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
}
