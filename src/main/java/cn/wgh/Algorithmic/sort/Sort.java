package cn.wgh.Algorithmic.sort;

import org.junit.Test;

import java.util.Arrays;

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
