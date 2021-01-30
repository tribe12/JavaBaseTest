package cn.wgh.designpattern.behavioral.memento;

import java.io.Serializable;

/**
 * Created by wgh on 2021/1/30.
 */
public class Location implements Serializable {
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo='" + roomNo + '\'' +
                '}';
    }
}
