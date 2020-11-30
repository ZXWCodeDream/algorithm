package main.java.com.zxw.leetcode;

/**
 * ClassName: Code53
 * Description:
 *
 *
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 *
 * @author zxw
 * @date 2020/11/30 3:11 下午
 * @since JDK 1.8
 */
public class Code53 {


    /**
     * 超过内存限制
     * 动态规划。二维数组dp[i][j] i表示数组起始坐标，j表示数组结束坐标，value表示nums[i]...+nums[j]的累加和
     * @param nums
     * @return
     */
    public static int maxSubArray_fail(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++){
            for (int j = i; j < len; j++){
                if (i == j){
                    dp[i][j] = nums[j];
                }else{
                    dp[i][j] = dp[i][j-1] + nums[j];
                }
            }
        }
        int sum = dp[0][0];
        for (int i = 0; i < dp.length; i++){
            for (int j = i; j < dp[0].length; j++){
                sum = Math.max(sum,dp[i][j]);
            }
        }
        return sum;
    }

    /**
     * 通过
     * 低效
     * 思路：一维数组dp[i] i表示数组起始坐标，value表示以i为起始坐标的最大值 举例： nums = [a,b,c] dp[0]=max(a,a+b,a+b+c);
     * @param nums
     * @return
     */
    public static int maxSubArray_inefficient(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++){
            // 记录以i为起点的和
            int iSum = nums[i];
            for (int j = i; j < len; j++){
                if (i == j){
                    dp[i] = nums[j];
                }else{
                    iSum += nums[j];
                    dp[i] = Math.max(dp[i],iSum);
                }
            }
        }
        int sum = dp[0];
        for (int i = 0; i < dp.length; i++){
            sum = Math.max(sum,dp[i]);
        }
        return sum;
    }

    /**
     * 真真正正的动态规划解法
     * 使用a[i]代表nums[i],f(i)表示以nums[i]为结尾【连续子数组】最大和    public static int maxSubArray_inefficient(int[] nums) {
     * 很明显 f(i) = max(f(i-1)+nums[i],nums[i]) 要么加前面的值，要么使用当前元素，动态规划转移方程因此得出
     * 因此可以使用一维dp存储值，最终求出dp数组中的最大值
     * 不过我们根据动态规划转移方程可知，每次影响的值都只跟前一个值有关，所以我们可以使用临时变量pre保存
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return  0;
        }
        int pre = 0,maxSum = nums[0];
        for (int i = 1; i < nums.length; i++){
            // pre值表示以nums[i]为结尾的【连续子数组】最大和
            pre = Math.max(pre+nums[i],nums[i]);
            maxSum = Math.max(maxSum,pre);
        }
        return maxSum;

    }


        public static void main(String[] args) {

        int[] arr1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] arr2 = new int[]{-2,-1};
        int[] arr = new int[]{-1,2,-1,3};
        System.out.println(maxSubArray(arr));
    }

}
