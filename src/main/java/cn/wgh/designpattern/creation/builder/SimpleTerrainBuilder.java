package cn.wgh.designpattern.creation.builder;

/**
 * 简单地形构建器
 * Created by wgh on 2021/1/21.
 */
public class SimpleTerrainBuilder implements TerrainBuilder {
    Terrain terrain = new Terrain();

    @Override
    public TerrainBuilder buildWall() {
        terrain.wall = new Wall(10, 50, 20);
        return this;
    }

    @Override
    public TerrainBuilder buildFort() {
        terrain.fort = new Fort(20, 30, 10);
        return this;
    }

    @Override
    public TerrainBuilder buildMine() {
        terrain.mine = new Mine(3, 2, 2);
        return this;
    }

    @Override
    public Terrain build() {
        buildWall().buildFort().buildMine();
        return terrain;
    }
}
