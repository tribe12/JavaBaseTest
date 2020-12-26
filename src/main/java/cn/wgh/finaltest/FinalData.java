package cn.wgh.finaltest;

import java.util.Random;

/**
 * Created by wgh on 2020/12/23.
 */
public class FinalData {

    static Random rand = new Random();
    private final int VALUE_1 = 9; //声明一个final常量
    private static final int VALUE_2 = 10;//声明一个final、static常量
    private final IntData intData = new IntData(); //声明一个final引用
    private IntData intData2 = new IntData(); //声明一个不是final的引用
    private final int[] a = {1, 2, 3, 4, 5, 6}; //声明一个定义为final的数组
    private final int i4 = rand.nextInt(20);
    private static final int i5 = rand.nextInt(20);


    public String toString() {
        return i4 + " " + i5 + " ";
    }

    public static void main(String[] args) {
        FinalData finalData = new FinalData();
//        finalData.intData = new IntData();
        finalData.intData2 = new IntData();
//        finalData.VALUE_1++;


        for (int i = 0; i < finalData.a.length; i++) {
            //   a[i] =9;
        }
        System.out.println(finalData);
        System.out.println(new FinalData());
        System.out.println(finalData.VALUE_1);
        System.out.println(finalData.VALUE_2);

    }


    public static Random getRand() {
        return rand;
    }

    public static void setRand(Random rand) {
        FinalData.rand = rand;
    }

    public int getVALUE_1() {
        return VALUE_1;
    }

    public static int getValue2() {
        return VALUE_2;
    }

    public IntData getIntData() {
        return intData;
    }

    public IntData getIntData2() {
        return intData2;
    }

    public void setIntData2(IntData intData2) {
        this.intData2 = intData2;
    }

    public int[] getA() {
        return a;
    }

    public int getI4() {
        return i4;
    }

    public static int getI5() {
        return i5;
    }
}
