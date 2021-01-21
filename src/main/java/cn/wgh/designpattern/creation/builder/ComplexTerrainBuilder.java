package cn.wgh.designpattern.creation.builder;

/**
 * 复杂地形构建器
 * Created by wgh on 2021/1/21.
 */
public class ComplexTerrainBuilder implements TerrainBuilder {
    Terrain terrain = new Terrain();

    @Override
    public TerrainBuilder buildWall() {
        terrain.wall = new Wall(12.34, 53.61, 26.37);
        return this;
    }

    @Override
    public TerrainBuilder buildFort() {
        terrain.fort = new Fort(27.32, 31.66, 12.99);
        return this;
    }

    @Override
    public TerrainBuilder buildMine() {
        terrain.mine = new Mine(34.12, 2.77, 2.31);
        return this;
    }

    @Override
    public Terrain build() {
        buildWall().buildFort().buildMine();
        return terrain;
    }
}
