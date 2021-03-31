package main.java.com.zxw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Code219
 * Description:
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @author zxw
 * @date 2021/3/31 3:27 下午
 * @since JDK 1.8
 */
public class Code219 {

    /**
     * 寻找相等的就借助hash数据结构
     * 通常为Set和Map
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length;i++){
            int v = nums[i];
            if (map.containsKey(v) && i-map.get(v) <= k){
                return true;
            }else{
                map.put(v,i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(arr,4));
    }
}
