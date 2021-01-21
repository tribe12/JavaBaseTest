package cn.wgh.designpattern.creation.builder;

/**
 * Created by wgh on 2021/1/21.
 */
public class Person {
    private int id;
    private String name;
    private int age;
    private int sex;
    private double weigh;
    private double score;
    private String hobby;
    private String introduce;
    private Location loc;

    /**
     * 不让外部创建Person
     */
    private Person() {
    }

    public static class PersonBuilder {
        Person person = new Person();

        /**
         * 创建必要基础信息
         *
         * @param id
         * @param name
         * @param age
         * @return
         */
        public PersonBuilder basicInfo(int id, String name, int age) {
            person.id = id;
            person.name = name;
            person.age = age;
            return this;
        }

        // --- 完善具体信息 ---

        public PersonBuilder setSex(int sex) {
            person.sex = sex;
            return this;
        }

        public PersonBuilder setWeigh(int weigh) {
            person.weigh = weigh;
            return this;
        }


        public PersonBuilder setScore(int score) {
            person.score = score;
            return this;
        }

        public PersonBuilder setHobby(String hobby) {
            person.hobby = hobby;
            return this;
        }

        public PersonBuilder setIntroduce(String introduce) {
            person.introduce = introduce;
            return this;
        }

        public PersonBuilder setLocation(String street, String roomNo) {
            person.loc = new Location(street, roomNo);
            return this;
        }

        public Person build() {
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", weigh=" + weigh +
                ", score=" + score +
                ", hobby='" + hobby + '\'' +
                ", introduce='" + introduce + '\'' +
                ", loc=" + loc +
                '}';
    }
}
