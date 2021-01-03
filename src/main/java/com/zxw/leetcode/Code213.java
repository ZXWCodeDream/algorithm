package main.java.com.zxw.leetcode;

/**
 * ClassName: Code213
 * Description:
 *
 *
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * @author zxw
 * @date 2021/1/3 12:16 下午
 * @since JDK 1.8
 */
public class Code213 {

    /**
     * 状态转移方程： dp[n] = Max(dp[n-1],dp[n-2]+nums[i])
     * dp[]数组含义： 当强抢劫到第i户时获取的最大利益
     * 本题难点：
     *  所有房屋是围成一个圆形，状态转移方程不适合第一个屋子和最后一个屋子计算
     *  所以细想发现只要分为两个状态即可利用状态转移方程
     *  状态一：抢劫第一个屋子，不抢最后一个屋。所以针对范围[0,n-2]可利用状态转移方程计算
     *  状态二：不抢第一个屋子，抢最后一个屋子。所以针对范围[1,n-1]可利用状态转移方程计算
     *  最后通过比较状态一和状态二的值，即可得出利益最大值
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        return Math.max(fib(nums,0,n-2),fib(nums,1,n-1));

    }

    public static int fib(int[] nums,int start,int end){
        int pre = 0, now = 0;
        for (int i = start; i <= end; i++){
            int max = Math.max(now,pre+nums[i]);
            pre = now;
            now = max;
        }
        return now;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{0};
        System.out.println(rob(arr));
    }
}
