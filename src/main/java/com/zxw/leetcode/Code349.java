package main.java.com.zxw.leetcode;

import main.java.com.zxw.common.Util;

import java.util.*;

/**
 * ClassName: Code349
 * Description:
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author zxw
 * @date 2021/4/2 10:24 上午
 * @since JDK 1.8
 */
public class Code349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1){
            set1.add(num);
        }
        for (int num : nums2){
            if (set1.contains(num)){
                set2.add(num);
            }
        }

        return set2.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        int[] arr1= new int[]{1,2,2,1};
        int[] arr2 = new int[]{2,2};
        Util.print(intersection(arr1,arr2));
    }
}
