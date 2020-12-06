package cn.wgh.designpattern.strategy;

/**
 * 猫重量的比较策略
 * Created by dell on 2020/12/6.
 */
public class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        if (c1.weight > c2.weight) {
            return 1;
        } else if (c1.weight < c2.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
