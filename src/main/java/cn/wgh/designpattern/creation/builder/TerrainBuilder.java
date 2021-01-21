package cn.wgh.designpattern.creation.builder;

/**
 * 地形构建器接口
 * Created by wgh on 2021/1/21.
 */
public interface TerrainBuilder {
    TerrainBuilder buildWall();

    TerrainBuilder buildFort();

    TerrainBuilder buildMine();

    Terrain build();
}
