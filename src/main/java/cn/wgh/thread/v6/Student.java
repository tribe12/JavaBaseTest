package cn.wgh.thread.v6;

/**
 * Created by wgh on 2021/4/12.
 */
public class Student {
    private String name;
    private int age;
    private double score;

    public Student() {
    }

    private static ThreadLocal<Student> threadLocal = new ThreadLocal<>();

    /**
     * 获取当前线程的实例对象
     * <p>
     * ThreadLocal类及应用技巧（外界直接调用，不必关心内部实现原理，简化代码）
     *
     * @return
     */
    public static Student getThreadInstance() {
        Student instance = threadLocal.get();
        if (instance == null) {
            instance = new Student();
            threadLocal.set(instance);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
