package cn.wgh.object;

/**
 * Created by wgh on 2020/12/22.
 */
public class Student extends Human {
    private double achievement;

    public double getAchievement() {
        return achievement;
    }

    public void setAchievement(double achievement) {
        this.achievement = achievement;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", achievement=" + achievement +
                '}';
    }

}
