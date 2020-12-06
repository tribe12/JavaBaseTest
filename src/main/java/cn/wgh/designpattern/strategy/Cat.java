package cn.wgh.designpattern.strategy;

/**
 * Created by wgh on 2020/11/18.
 */
public class Cat {

    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }


    @Override
    public String toString() {
        return "Cat{weight=" + this.weight + " ,height=" + this.height + "}";
    }
}
