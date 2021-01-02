package cn.wgh.generic;

/**
 * Created by wgh on 2021/1/2.
 */
public class ArrayClass<T> {
    //定义泛型数组，只能声明
    private T[] array;

    //不能创建数组实例
    //private T[] array2 = new T[10];


    //设置SetXXX()方法为成员数组赋值
    public void SetT(T[] array) {
        this.array = array;
    }

    //获取成员数组
    public T[] getT() {
        return array;
    }

    public static void main(String[] args) {
        ArrayClass<String> a = new ArrayClass<String>();
        String[] aa = {"No.1", "No.2", "No.3", "No.4", "No.5",};
        a.SetT(aa);
        for (int i = 0; i < a.getT().length; i++) {
            System.out.println(a.getT()[i]);
        }
    }
}
