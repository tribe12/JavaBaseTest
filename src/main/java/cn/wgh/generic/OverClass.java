package cn.wgh.generic;

/**
 * Created by wgh on 2021/1/2.
 */
//定义泛型类型
public class OverClass<T> {
    //定义泛型成员变量
    private T over;

    public T getOver() {
        return over;
    }

    public void setOver(T over) {
        this.over = over;
    }

    public static void main(String[] args) {
        //实例化一个Boolean型的对象
        OverClass<Boolean> over1 = new OverClass<>();
        //实例化一个Float型的对象
        OverClass<Float> over2 = new OverClass<>();

        //不需要进行类型转换
        over1.setOver(true);
        over2.setOver(12.3f);
        //不需要进行类型转换
        Boolean b = over1.getOver();
        Float f = over2.getOver();
        System.out.println(b);
        System.out.println(f);
    }
}
