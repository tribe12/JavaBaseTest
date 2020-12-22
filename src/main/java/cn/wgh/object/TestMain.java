package cn.wgh.object;

import org.junit.Test;

/**
 * Created by wgh on 2020/12/22.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
        Human human = new Student();
//        human = new Teacher();
//        human = new Human();

        human.setName("XiaoMing");
        human.setAge(20);

        if (human instanceof Student) {
            Student s = (Student) human;
            s.setAchievement(90);
            System.out.println(s.toString());
        } else if (human instanceof Teacher) {
            Teacher t = (Teacher) human;
            t.setWorkeAge(3.5);
            System.out.println(t.toString());
        } else if (human instanceof Human) {
            System.out.println(human.toString());
        }
    }

}
