package cn.wgh.Algorithmic.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wgh on 2021/1/31.
 */
public class SortAlgorithmTest {


    @Test
    public void test1() throws Exception {
        int[] a = {27, 8, 9, 57, 25, 82, 3, 7, 100, 4, 86, 23, 10, 36, 85, 90, 34, 1, 75, 18, 21, 15, 87, 2};
//        int[] a = {49, 38, 65, 97, 76, 13, 18, 17, 35, 1};

        // 冒泡排序
//        System.out.println(Sort.bubbleSort(a));
        // 快速排序
//        System.out.println(quickSort(a));
        // 插入排序
//        System.out.println(Sort.insertSort(a));
        // 选择排序
        System.out.println(Sort.selectSort(a));
        // 基数排序
        System.out.println(radixSort(a));

    }

    /**
     * 基数排序
     *
     * @param a
     * @return
     */
    private SortRecord radixSort(int[] a) {
        long time1 = System.currentTimeMillis();
        List<Integer> r0 = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        List<Integer> r3 = new ArrayList<>();
        List<Integer> r4 = new ArrayList<>();
        List<Integer> r5 = new ArrayList<>();
        List<Integer> r6 = new ArrayList<>();
        List<Integer> r7 = new ArrayList<>();
        List<Integer> r8 = new ArrayList<>();
        List<Integer> r9 = new ArrayList<>();

        int maxPlace = getArrayMaxPlace(a);
        for (int i = 0; i < maxPlace; i++) {
            for (int j = 0; j < a.length; i++) {



                rrr(getPlaceNum(a), r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
            }
        }



        long time2 = System.currentTimeMillis();
        return new SortRecord("选择排序", time2 - time1, a);

    }

    private void xxx(int[] a, List<Integer> r0, List<Integer> r1, List<Integer> r2, List<Integer> r3, List<Integer> r4, List<Integer> r5, List<Integer> r6, List<Integer> r7, List<Integer> r8, List<Integer> r9) {
    }

    @Test
    public void test2() throws Exception {


        int a = 12345;
        System.out.println(a / 10000);
        System.out.println(a % 10000 / 1000);
        System.out.println(a % 10000 % 1000 / 100);
        System.out.println(a % 10000 % 1000 % 100 / 10);
        System.out.println(a % 10000 % 1000 % 100 % 10 / 1);
        System.out.println("------------");


        for (int i = 10000; i >= 1; i /= 10) {
            System.out.println("i:" + i);
            System.out.println("=====" + a / i);
            a %= i;
        }

        System.out.println("==========");
        System.out.println(getPlaceNum(12345, 10000));
    }

    @Test
    public void test3() throws Exception {
        System.out.println(getPlaceNum(12345, 10));
    }

    /**
     * 获取一个数某个位的值
     * <p>
     * 个位：1
     * 十位：10
     * 百位：100
     * 千位：1000
     * 万位：10000
     *
     * @param a
     * @param p
     * @return
     */
    public int getPlaceNum(int a, int p) {
        int num = 0;
        for (int i = getPlace(a); i >= 1; i /= 10) {
            num = a / i;
            if (i == p) {
                return num;
            }
            a %= i;
        }
        return num;
    }


    /**
     * 判断某个数有什么位数
     * <p>
     * 个位：1
     * 十位：10
     * 百位：100
     * 千位：1000
     * 万位：10000
     *
     * @param num
     * @return
     */
    private int getPlace(int num) {
        int place = 1;
        while (num > 0) {
            num = num / 10;
            place *= 10;
        }
        return place;
    }


    /**
     * 获取数组中最大值的位数
     *
     * @param a
     * @return
     */
    private int getArrayMaxPlace(int[] a) {
        int maxPlace = 0;
        int num = getArrayMaxNum(a);
        while (num > 0) {
            num = num / 10;
            maxPlace++;
        }
        return maxPlace;
    }

    /**
     * 获取数组中的最大值
     *
     * @param a
     * @return
     */
    private int getArrayMaxNum(int[] a) {
        int maxNum = 0;
        for (int i = 0; i < a.length; i++) {
            if (maxNum < a[i]) {
                maxNum = a[i];
            }
        }
        return maxNum;
    }

    private void rrr(int i, List<Integer> r0, List<Integer> r1, List<Integer> r2, List<Integer> r3, List<Integer> r4, List<Integer> r5, List<Integer> r6, List<Integer> r7, List<Integer> r8, List<Integer> r9) {
        switch (i) {
            case 0:
                r0.add(i);
            case 1:
                r1.add(i);
            case 2:
                r2.add(i);
            case 3:
                r3.add(i);
            case 4:
                r4.add(i);
            case 5:
                r5.add(i);
            case 6:
                r6.add(i);
            case 7:
                r7.add(i);
            case 8:
                r8.add(i);
            case 9:
                r9.add(i);
        }
    }


    /**
     * 快速排序
     *
     * @throws Exception
     */
    public SortRecord quickSort(int[] a) {
        long time1 = System.currentTimeMillis();
        int leftIndex = 0;
        int rightIndex = a.length - 1;


        for (int i = 0; i < a.length - 1; i++) {


            int temp = a[i];
            compareRight(a, temp, leftIndex, rightIndex);
        }


        long time2 = System.currentTimeMillis();
        return new SortRecord("快速排序", time2 - time1, a);
    }

    private void compareRight(int[] a, int temp, int leftIndex, int rightIndex) {

        System.out.println("compareRight");
        if (temp > a[rightIndex]) {
            a[leftIndex] = a[rightIndex];
            compareLeft(a, temp, leftIndex, rightIndex);
        } else {
            rightIndex--;
            if (leftIndex == rightIndex) {
                a[leftIndex] = temp;
            }
        }

    }

    private void compareLeft(int[] a, int temp, int leftIndex, int rightIndex) {
        System.out.println("compareLeft");
        if (temp < a[leftIndex]) {
            a[rightIndex] = a[leftIndex];
            compareRight(a, temp, leftIndex, rightIndex);
        } else {
            leftIndex++;
            if (leftIndex == rightIndex) {
                a[leftIndex] = temp;
            }
        }
    }


    private static void swapArray(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }


    /**
     * 排序结果记录
     */
    class SortRecord {
        private String name;
        private long time;
        private int[] result;

        public SortRecord(String name, long time, int[] result) {
            this.name = name;
            this.time = time;
            this.result = result;
        }


        @Override
        public String toString() {
            return name + ": " + "(" + time + ")" + "\n"
                    + Arrays.toString(result) + "\n";
        }

    }
}
