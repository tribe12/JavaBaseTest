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
        //int[] a = {27, 8, 9, 57, 25, 82, 3, 7, 100, 4, 86, 23, 10, 36, 85, 90, 34, 1, 75, 18, 21, 15, 87, 2};
        int[] a = {49, 38, 65, 97, 76, 13, 10, 5, 18, 100, 17, 35, 99, 1};

        // 冒泡排序
//        System.out.println(Sort.bubbleSort(a));
        // 快速排序
//        System.out.println(quickSort(a));
        // 插入排序
//        System.out.println(Sort.insertSort(a));
        // 选择排序
//        System.out.println(Sort.selectSort(a));
        // 基数排序
        System.out.println(Sort.radixSort(a));

    }





    private void newList(List<Integer> r0, List<Integer> r1, List<Integer> r2, List<Integer> r3, List<Integer> r4, List<Integer> r5, List<Integer> r6, List<Integer> r7, List<Integer> r8, List<Integer> r9) {
       r0 = new ArrayList<>();
        r0.add(5);
        r1 = new ArrayList<>();
        r2 = new ArrayList<>();
        r3 = new ArrayList<>();
        r4 = new ArrayList<>();
        r5 = new ArrayList<>();
        r6 = new ArrayList<>();
        r7 = new ArrayList<>();
        r8 = new ArrayList<>();
        r9 = new ArrayList<>();
    }

    private void gxList2(List<Integer>... lists) {

        for (int i = 0; i < lists.length; i++) {
            lists[i] =  null;
        }
    }

    private void xxx(int[] a, List<Integer> r0, List<Integer> r1, List<Integer> r2, List<Integer> r3, List<Integer> r4, List<Integer> r5, List<Integer> r6, List<Integer> r7, List<Integer> r8, List<Integer> r9) {
    }

    @Test
    public void test5() throws Exception {
        int[] a = new int[6];
        List<Integer> r0 = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        r0.add(0);
        r0.add(1);
        r0.add(2);
        r1.add(3);
        r1.add(4);
        r2.add(5);
        Sort.addRadixArray(a,r0,r1,r2);
        System.out.println(Arrays.toString(a));
    }


    @Test
    public void test4() throws Exception {
     /*   List<Integer> r0 = null;
        List<Integer> r1 = null;
        List<Integer> r2 = null;
        List<Integer> r3 = null;
        List<Integer> r4 = null;
        List<Integer> r5 = null;
        List<Integer> r6 = null;
        List<Integer> r7 = null;
        List<Integer> r8 = null;
        List<Integer> r9 = null;*/

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

        System.out.println(r0);
        r0.add(0);
        gxList2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        System.out.println(r0);
        newList(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        System.out.println(r0);

      //  r0 = new ArrayList<>();
        r0.add(1);
        System.out.println(r0);
        aaa(r0);
        System.out.println(r0);
    }

    private void aaa(List<Integer> r0) {
        r0.add(2);

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
            System.out.print("i:" + i);
            System.out.println("=====" + a / i);
            a %= i;
        }

        System.out.println("==========");
        System.out.println(Sort.getPlaceNum(12345, 10000));
    }

    @Test
    public void test3() throws Exception {
//        System.out.println(Sort.getPlace(1));
//        System.out.println(Sort.getPlaceNum(12345, 10));
        System.out.println(Sort.getPlaceNum(1, 1000));
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
