package cn.wgh.designpattern.strategy;

/**
 * 猫身高的比较策略
 * Created by dell on 2020/12/6.
 */
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        if (c1.height > c2.height) {
            return 1;
        } else if (c1.height < c2.height) {
            return -1;
        } else {
            return 0;
        }
    }
}
