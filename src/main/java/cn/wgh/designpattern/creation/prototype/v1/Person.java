package cn.wgh.designpattern.creation.prototype.v1;

/**
 * Created by wgh on 2021/1/30.
 */
public class Person implements Cloneable{
    int age = 8;
    double score = 98.5;
    Location loc = new Location("一环路", 22);
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", loc=" + loc +
                '}';
    }
}
