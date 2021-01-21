package cn.wgh.designpattern.creation.builder;

/**
 * 地雷
 * Created by wgh on 2021/1/21.
 */
public class Mine {
    double x;
    double y;
    double z;

    public Mine(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Mine{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
