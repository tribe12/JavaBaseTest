package cn.wgh.designpattern.creation.builder;

/**
 * 堡垒
 * Created by wgh on 2021/1/21.
 */
public class Fort {
    double x;
    double y;
    double z;

    public Fort(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Fort{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
