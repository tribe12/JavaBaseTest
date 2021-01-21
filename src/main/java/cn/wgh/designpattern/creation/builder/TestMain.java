package cn.wgh.designpattern.creation.builder;

import org.junit.Test;

/**
 * 建造者模式
 * <p>
 * 分离复杂对象的构建和表式
 * 同样的构建过程可以创建不同的表式
 * <p>
 * 一般是构建一个类参数比较多，可以用这种模式
 * <p>
 * Created by wgh on 2021/1/21.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
//        TerrainBuilder terrainBuilder = new ComplexTerrainBuilder();
        TerrainBuilder terrainBuilder = new SimpleTerrainBuilder();
        Terrain terrain = terrainBuilder.build();

        System.out.println(terrain);
    }


    /**
     * 相对标准的用法
     * 一般是构建一个类参数比较多，可以用这种模式
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Person person = new Person.PersonBuilder().basicInfo(1, "小明", 20)
                .setSex(1)
                .setWeigh(65)
                .setScore(90)
                .setHobby("篮球")
                .setIntroduce("性格开朗，积极向上")
                .setLocation("东大街", "118号")
                .build();
        System.out.println(person);
    }

}
