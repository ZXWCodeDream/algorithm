package main.java.com.zxw.leetcode;

/**
 * ClassName: Code665
 * Description:
 *
 * 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 *
 * 说明：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 * @author zxw
 * @date 2020/11/29 4:58 下午
 * @since JDK 1.8
 */
public class Code665 {

    /**
     * 思路跟680类似
     * 关键需要考虑好当不符合条件时，修改那一个值
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int i = 1;
        for (; i < nums.length && nums[i] >= nums[i-1]; i++);
        if (i >= nums.length){
            return true;
        }
        int now = nums[i];
        nums[i] = nums[i-1];
        if (checkPossibility2(nums)){
            return true;
        }else{
            nums[i] = now;
            nums[i-1] = nums[i];
            return checkPossibility2(nums);
        }
    }

    public boolean checkPossibility2(int[] nums){
        int j = 1;
        for (; j < nums.length && nums[j] >= nums[j-1]; j++);
        return j >= nums.length;
    }
}
