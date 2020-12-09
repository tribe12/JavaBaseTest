package cn.wgh.designpattern.behavioral.strategy;


/**
 * Created by wgh on 2020/12/5.
 */
public class Dog {

    int weight, height, speed;

    public Dog(int weight, int height, int speed) {
        this.weight = weight;
        this.height = height;
        this.speed = speed;
    }


    @Override
    public String toString() {
        return "Dog{weight=" + this.weight + " ,height=" + this.height + " ,speed=" + this.speed + "}";
    }

}

