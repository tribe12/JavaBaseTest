package cn.wgh.array;

import org.junit.Test;

/**
 * @author: tribe
 * @time: 2023/4/20 1:42
 */
public class ArrayTest2 {
    @Test
    public void test1() throws Exception {
        // 声明并赋值
        int[] arr1 = {1, 2, 3, 4, 5};

        //声明数组名开辟空间并且赋值
        int[] arr2;
        arr2 = new int[]{1, 2, 3, 4, 5};

        //声明数组时指定元素个数然后赋值
        int[] arr3= new int[3];
        //注意:最大元素下标为2，并且所有的元素值均为0

        //创建多维数组
        int[][] arr11 = {{1,2,3},{4,5,6},{7,8,9}}; //每个子数组元素个数不要求均相同
        int[][] arr22 = new int[1][2]; //其中n可以省略，在创建的时候可以指定
        int[][][] arr33 = new int[1][2][3]; //同样其中n、q可以省略
    }


    @Test
    public void test2() throws Exception {
        String[] ss = new String[]{"1","2"};
//        System.out.println(ss[0]);
        System.out.println(ss);
        System.out.println(ss[0]);
        System.out.println(ss[1]);
        System.out.println(ss[2]);
    }
}
