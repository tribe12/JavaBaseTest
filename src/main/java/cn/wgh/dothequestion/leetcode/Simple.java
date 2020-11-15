package cn.wgh.dothequestion.leetcode;


import org.junit.Test;

import java.util.*;

/**
 * Created by wgh on 2020/2/18.
 */
public class Simple {
    /**
     * 1. 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        List<Integer> indexList = new ArrayList<>();
        if (nums != null && nums.length > 1) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        indexList.add(i);
                        indexList.add(j);
                    }
                }
            }
        }

        int[] index = new int[indexList.size()];
        for (int i = 0; i < indexList.size(); i++) {
            index[i] = indexList.get(i);
        }
        return index;
    }

    @Test
    public void twoSumTest() throws Exception {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;

//        int[] nums = {3,2,3};
//        int target = 6;


        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] index = twoSum(nums, target);
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }
        System.out.println(-3<= 0);
        System.out.println(-3 + 3 == 0);
    }


    /**
     * 20. 有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        boolean r = false;
        List<String> list = new ArrayList<>();
        List<String> valid = Arrays.asList("(", ")","[", "]","{", "}");
        String v = null;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;
        for (int i = 0; i < s.length(); i++) {
            String t = String.valueOf(s.charAt(i));
            if(valid.contains(t)){
                list.add(t);
                switch (t){
                    case "(": c1++; break;
                    case ")": c2++; break;
                    case "[": c3++; break;
                    case "]": c4++; break;
                    case "{": c5++; break;
                    case "}": c6++; break;
                    default: break;
                }
               /* if("(".equals(v)){

                }else



                if(v == null){
                    v = t;
                }else if(("(".equals(v) && ")".equals(t))
                        ||("[".equals(v) && "]".equals(t))
                        ||("{".equals(v) && "}".equals(t))
                            ){
                    v = t;
                    r = true;
//                }else{
//                    return false;
                }*/
            }

//            if (list.isEmpty() || list.size() % 2 != 0
//                    || c1 != c2 || c3 != c4 || c5 != c6) {
//                return false;
//            }
//

        }
        for (String ss:list
             ) {
            System.out.println(ss);
        }

        return r;
    }


    @Test
    public void isValidTest() throws Exception {
      String s = "()";
        s = "()[]{}";
//        s = "(]";
        System.out.println(isValid(s));
    }


    /**
     * 26. 删除排序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i: nums) {
            if(!list.contains(i)){
                list.add(i);
            }
        }

        nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    @Test
    public void removeDuplicatesTest() throws Exception {
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }


    /**
     * 27. 移除元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        if (nums != null && nums.length > 0) {
            for (int n : nums) {
                if (val != n) {
                    nums[count] = n;
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test27() throws Exception {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    /**
     * 100. 相同的树
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag = false;
        if (p != null && q != null) {
            if (p.val == q.val && p.left.val == q.left.val && p.right.val == q.right.val) {
                if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
    }


    /**
     * 181. 超过经理收入的员工
     * @throws Exception
     */
    @Test
    public void sqlTest_Employee() throws Exception {
        String s1 = "SELECT t1. NAME AS 'Employee'\n" +
                "FROM Employee t1, Employee t2\n" +
                "WHERE t1.ManagerId = t2.Id\n" +
                "AND t1.Salary > t2.Salary;";

        String s2 = "SELECT t1. NAME AS 'Employee'\n" +
                "FROM Employee t1\n" +
                "LEFT JOIN Employee t2 on t1.ManagerId = t2.Id\n" +
                "WHERE t1.Salary > t2.Salary;";
    }


    /**
     * 182. 查找重复的电子邮箱
     */
    @Test
    public void sqlTest_Person() throws Exception {
        String s1 = "SELECT t1. NAME AS 'Employee' " +
                "FROM Employee t1 " +
                "LEFT JOIN Employee t2 on t1.ManagerId = t2.Id " +
                "WHERE t1.Salary > t2.Salary;";
    }
}
