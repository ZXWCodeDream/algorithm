package main.java.com.zxw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Code1
 * Description:
 *
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * @author zxw
 * @date 2021/3/17 10:10 上午
 * @since JDK 1.8
 */
public class Code1 {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(target-nums[i],i);
        }
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]) && i != map.get(nums[i])){
                result[0] = i;
                result[1] = map.get(nums[i]);
            }
        }
        return result;
    }

    /**
     * 一层循环即可解决
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums,int target){

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(target-nums[i],i);
            }
        }
        return new int[0];
    }


}
