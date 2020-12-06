package cn.wgh.designpattern.strategy;

/**
 * 比较器
 * Created by wgh on 2020/11/18.
 */
public class IntSorter {

    public static void sort(int[] arr){
        if(arr!=null && arr.length > 0){
            for (int i = 0; i < arr.length - 1; i++) {
                int minPos = i;
                for (int j = i+1; j < arr.length; j++) {
                    minPos = arr[j] < arr[minPos] ? j : minPos;
                }

                swap(arr,i,minPos);
            }
            
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
