package cn.wgh.Algorithmic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序
 * <p>
 * Created by wgh on 2021/1/31.
 */
public class Sort {


    /**
     * 冒泡排序
     *
     * @throws Exception
     */
    public static SortRecord bubbleSort(int[] a) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swapArray(a, i, j);
                }
            }
        }
        long time2 = System.currentTimeMillis();
        return new SortRecord("冒泡排序", time2 - time1, a);
    }






    /**
     * 插入排序
     *
     *
     * @throws Exception
     */
    public SortRecord insertSort(int[] a) {
        long time1 = System.currentTimeMillis();
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] >= a[j]) {
                    break;
                }
                compareSwap(a, i, j);
            }
        }

        long time2 = System.currentTimeMillis();
        return new SortRecord("插入排序", time2 - time1, a);
    }


    /**
     * 比较后交换
     *
     * @param a
     * @param i
     * @param j
     */
    private static void compareSwap(int[] a, int i, int j) {
        if (a[i] < a[j]) {
            swapArray(a, i, j);
            if (j == 0) {
                return;
            }
            i--;
            j--;
            compareSwap(a, i, j);
        }
    }






    /**
     * 选择排序
     *
     * 每一轮比较后找出最小（大）值的下标位置，
     * 然后将最小（大）值放在每一轮的最前面（起始位置）
     *
     * @param a
     * @return
     */
    public static SortRecord selectSort(int[] a) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            swapArray(a, i, minIndex);
        }

        long time2 = System.currentTimeMillis();
        return new SortRecord("选择排序", time2 - time1, a);
    }







    /**
     * 基数排序
     *
     * @param a
     * @return
     */
    public static SortRecord radixSort(int[] a) {
        long time1 = System.currentTimeMillis();
        List<Integer> r0 = null;
        List<Integer> r1 = null;
        List<Integer> r2 = null;
        List<Integer> r3 = null;
        List<Integer> r4 = null;
        List<Integer> r5 = null;
        List<Integer> r6 = null;
        List<Integer> r7 = null;
        List<Integer> r8 = null;
        List<Integer> r9 = null;

        //获取最大的位数
        int maxPlace = getArrayMaxPlace(a);
        for (int i = 1; i <= maxPlace; i*=10) {
            r0 = new ArrayList<>();
            r1 = new ArrayList<>();
            r2 = new ArrayList<>();
            r3 = new ArrayList<>();
            r4 = new ArrayList<>();
            r5 = new ArrayList<>();
            r6 = new ArrayList<>();
            r7 = new ArrayList<>();
            r8 = new ArrayList<>();
            r9 = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                addRadixList(a[j], getPlaceNum(a[j], i), r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
            }
            addRadixArray(a, r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);

        }
        long time2 = System.currentTimeMillis();
        return new SortRecord("选择排序", time2 - time1, a);
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
     * @param p 位数（1、10、100、1000...）
     * @return
     *
     * 有待改进
     */
    public static int getPlaceNum(int a, int p) {
        int num = 0;
        if (getPlace(a) < getPlace(p)) {
            return num;
        }
        for (int i = getPlace10x(a); i >= 1; i /= 10) {
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
    public static int getPlace(int num) {
        return getPlace10x(num)/10;
    }

    public static int getPlace10x(int num) {
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
    public static int getArrayMaxPlaceNum(int[] a) {
        int maxPlace = 0;
        int num = getArrayMaxNum(a);
        while (num > 0) {
            num = num / 10;
            maxPlace++;
        }
        return maxPlace;
    }

    /**
     * 获取数组中最大值的位数
     *
     * 个位：1
     * 十位：10
     * 百位：100
     * 千位：1000
     * 万位：10000
     * @param a
     * @return
     */
    public static int getArrayMaxPlace(int[] a) {
        return getPlace(getArrayMaxNum(a));
    }


    /**
     * 获取数组中的最大值
     *
     * @param a
     * @return
     */
    public static int getArrayMaxNum(int[] a) {
        int maxNum = 0;
        for (int i = 0; i < a.length; i++) {
            if (maxNum < a[i]) {
                maxNum = a[i];
            }
        }
        return maxNum;
    }

    /**
     *
     * @param a 要添加的数
     * @param radix 某个位置的数
     * @param r0
     * @param r1
     * @param r2
     * @param r3
     * @param r4
     * @param r5
     * @param r6
     * @param r7
     * @param r8
     * @param r9
     */
    public static void addRadixList(int a, int radix, List<Integer> r0, List<Integer> r1, List<Integer> r2, List<Integer> r3, List<Integer> r4, List<Integer> r5, List<Integer> r6, List<Integer> r7, List<Integer> r8, List<Integer> r9) {
        switch (radix) {
            case 0:
                r0.add(a); break;
            case 1:
                r1.add(a); break;
            case 2:
                r2.add(a); break;
            case 3:
                r3.add(a); break;
            case 4:
                r4.add(a); break;
            case 5:
                r5.add(a); break;
            case 6:
                r6.add(a); break;
            case 7:
                r7.add(a); break;
            case 8:
                r8.add(a); break;
            case 9:
                r9.add(a); break;
        }
    }



    /**
     * 把每个list里的数字依次放入数组a中
     * @param a
     * @param lists
     */
    public static void addRadixArray(int[] a, List<Integer>... lists) {
        int index = 0;
        for (List<Integer> list: lists) {
            for (Integer i: list) {
                a[index] = i;
                index++;
            }
        }
    }



    







    /**
     * 交换数组中两个位置的值
     *
     * @param a
     * @param i
     * @param j
     */
    private static void swapArray(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    /**
     * 排序结果记录
     */
    static class SortRecord {
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
