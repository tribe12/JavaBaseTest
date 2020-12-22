package cn.wgh.object;

/**
 * Created by wgh on 2020/12/22.
 */
public class Teacher extends Human {
    private double workeAge;

    public double getWorkeAge() {
        return workeAge;
    }

    public void setWorkeAge(double workeAge) {
        this.workeAge = workeAge;
    }

    @Override
    public String toString() {
        return "Teacher{" + "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", workeAge=" + workeAge +
                '}';
    }
}
