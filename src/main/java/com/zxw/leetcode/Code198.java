package main.java.com.zxw.leetcode;

/**
 * ClassName: Code198
 * Description:
 *
 *
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * @author zxw
 * @date 2021/1/2 10:42 下午
 * @since JDK 1.8
 */
public class Code198 {


    /**
     * dp数组含义:
     *   当抢劫到第i户时获取的最大利益
     * 状态转移方程：
     *   db[n] = Max(dp[n-2]+nums[n],dp[n-1])
     *
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums){

        int pre = 0;
        int now = 0;
        for (int i = 0; i < nums.length; i++){
            int max = Math.max(pre+nums[i],now);
            pre = now;
            now = max;
        }
        return now;
    }


    /**
     * 错误代码
     * 状态转移方程： F(n) = Max(F(n-1),F(n-2)+f(n))
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {

        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){return nums[0];}
        if (nums.length == 2){return Math.max(nums[0],nums[1]);}

        //dp[i]=v的含义： 偷第i家的钱获取的最大利益
        int[] dp = new int[nums.length+1];
        /**
         * 初始值设置错误，应该从头判断。
         * 当第一户人家的钱比第二户人家的钱多时，dp[1]的值应该是nums[0]
         * dp含义： 当偷到第i户时获取的最大利益
         */
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }


    public static void main(String[] args) {

        int[] arr = new int[]{2,1,1,2};
        System.out.println(rob(arr));
    }
}
