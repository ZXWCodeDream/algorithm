package main.java.com.zxw.offer;

/**
 * ClassName: Offer42
 * Description:
 *输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 * @author zxw
 * @date 2020/7/1 10:18 上午
 * @since JDK 1.8
 */
public class Offer42 {


    public static void main(String[] args) {
        int[] nums = new int[]{-2};
        System.out.println(maxSubArray2(nums));
    }

//    动态规划
    public  static int  maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1],0)+nums[i];
            res = Math.max(res,dp[i]);
        }
        return res;
    }

//    空间优化，由于dp[i]的值只与dp[i-1]有关，所以只需要定义两个变量保存前一个值和当前值即可
    public static int maxSubArray2(int[] nums){
        int res = nums[0]; // 默认第一个数
        int before = 0;   // 先前值
        int cur = 0; // 当前值
        for (int num : nums){
            cur = num + Math.max(before,0);
            res = Math.max(res,cur);
            before = cur;
        }
        return res;
    }
}
