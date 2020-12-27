package cn.wgh.enumTest;

/**
 * Created by wgh on 2020/12/27.
 */
public enum DiEnum implements Di {
    DI_A, DI_B, DI_C, DI_D;

    private int i = 1;

    @Override
    public String getDescription() {
        return "我是枚举DiEnum的getDescription方法";
    }

    @Override
    public int getI() {
        return i;
    }
}
