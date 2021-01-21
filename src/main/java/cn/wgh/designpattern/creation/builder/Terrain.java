package cn.wgh.designpattern.creation.builder;

/**
 * Created by wgh on 2021/1/21.
 */
public class Terrain {
    Wall wall;
    Fort fort;
    Mine mine;

    @Override
    public String toString() {
        return "Terrain{" +
                "wall=" + wall +
                ", fort=" + fort +
                ", mine=" + mine +
                '}';
    }
}
