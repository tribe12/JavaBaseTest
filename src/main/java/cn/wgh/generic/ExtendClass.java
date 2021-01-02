package cn.wgh.generic;

import java.util.List;

/**
 * 继承泛型类与实现泛型接口
 * Created by wgh on 2021/1/2.
 */
public class ExtendClass<T1> {
    class SubClass<T1, T2, T3> extends ExtendClass<T1> {
    }
}
