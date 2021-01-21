package cn.wgh.designpattern.creation.builder;

/**
 * 墙
 * Created by wgh on 2021/1/21.
 */
public class Wall {
    double x;
    double y;
    double z;

    public Wall(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}

