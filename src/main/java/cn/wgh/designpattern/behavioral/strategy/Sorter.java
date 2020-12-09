package cn.wgh.designpattern.behavioral.strategy;

/**
 * 比较器
 * Created by wgh on 2020/11/18.
 */
public class Sorter<T> {

    /**
     * 比较后并排序
     *
     * @param arr        需要比较的数组
     * @param comparator 比较策略
     * @param sortType   排序方式（1：降序；-1：升序）
     */
    public void sort(T[] arr, Comparator<T> comparator, int sortType) {
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minPos = i;
                for (int j = i + 1; j < arr.length; j++) {
                    minPos = comparator.compare(arr[j], arr[minPos]) == sortType ? j : minPos;
                }
                swap(arr, i, minPos);
            }

        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
