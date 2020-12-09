package cn.wgh.designpattern.behavioral.strategy;

/**
 * 狗的比较策略
 * Created by wgh on 2020/12/6.
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog d1, Dog d2) {
        if ((d1.weight * 0.8 + d1.height + d1.speed * 1.2) > (d2.weight * 0.8 + d2.height + d2.speed * 1.2)) {
            return 1;
        } else if ((d1.weight * 0.8 + d1.height + d1.speed * 1.2) < (d2.weight * 0.8 + d2.height + d2.speed * 1.2)) {
            return -1;
        } else {
            return 0;
        }
    }
}
