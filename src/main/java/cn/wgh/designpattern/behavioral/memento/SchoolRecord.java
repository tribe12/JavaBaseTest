package cn.wgh.designpattern.behavioral.memento;

import java.io.Serializable;

/**
 * Created by wgh on 2021/1/30.
 */
public class SchoolRecord implements Serializable {
    String beginYear;
    String endYear;
    String schoolName;

    public SchoolRecord(String beginYear, String endYear, String schoolName) {
        this.beginYear = beginYear;
        this.endYear = endYear;
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "SchoolRecord{" +
                "beginYear='" + beginYear + '\'' +
                ", endYear='" + endYear + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
