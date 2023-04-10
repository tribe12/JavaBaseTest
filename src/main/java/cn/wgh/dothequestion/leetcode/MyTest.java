package cn.wgh.dothequestion.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: tribe
 * @time: 2023/3/27 17:29
 */
public class MyTest {

    /**
     * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
     * 输入：nums = [1,2,3,1], k = 3
     * 输出：true
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/contains-duplicate-ii
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums != null && nums.length > 1) {
            IntStream distinct = Arrays.stream(nums).distinct();
            long count = distinct.count();
            if (count < nums.length) {
                return true;
            }
        }
        return false;
    }


    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-search
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * <p>
     * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int a = -1;
        int b = -1;
        if (nums != null) {
            int length = nums.length;
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    if (nums[i] == target) {
                        a = i;
                        break;
                    }
                }
                for (int i = length - 1; i >= 0; i--) {
                    if (nums[i] == target) {
                        b = i;
                        return new int[]{a, b};
                    }
                }
            }
        }

        return new int[]{a, b};
    }

}
   