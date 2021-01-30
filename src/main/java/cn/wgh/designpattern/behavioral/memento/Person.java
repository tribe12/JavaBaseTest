package cn.wgh.designpattern.behavioral.memento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgh on 2021/1/30.
 */
public class Person implements Serializable {
    int age;
    double score;
    Location loc;
    String savePath;
    List<SchoolRecord> schoolRecords = new ArrayList<>();

    public Person(int age, double score, String street, int roomNo, List<SchoolRecord> schoolRecords, String savePath) {
        this.age = age;
        this.score = score;
        this.savePath = savePath;
        this.loc = new Location(street, roomNo);
        this.schoolRecords = schoolRecords;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", loc=" + loc +
                ", schoolRecords=" + schoolRecords +
                '}';
    }

    /**
     * 存档
     */
    public void save() {
        System.out.println("存档中...");
        File f = new File(savePath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复存档
     */
    public void load() {
        System.out.println("恢复存档中...");
        File f = new File(savePath);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Person person = (Person) ois.readObject();
            this.age = person.age;
            this.score = person.score;
            this.savePath = person.savePath;
            this.loc = person.loc;
            this.schoolRecords = person.schoolRecords;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 存档部分属性
     * 只存loc和schoolRecords
     */
    public void savePart() {
        System.out.println("部分属性存档中...");
        File f = new File(savePath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(loc);
            oos.writeObject(schoolRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复部分属性存档
     * 只恢复loc和schoolRecords
     */
    public void loadPart() {
        System.out.println("恢复部分属性存档中...");
        File f = new File(savePath);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            this.loc = (Location) ois.readObject();
            this.schoolRecords = (List) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
