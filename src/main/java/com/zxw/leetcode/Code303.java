package main.java.com.zxw.leetcode;

/**
 * ClassName: Code303
 * Description:
 *
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 *
 * @author zxw
 * @date 2021/1/3 4:29 下午
 * @since JDK 1.8
 */
public class Code303 {

    /**
     * 动态转移方程：
     * f(i,j) = dp[j] - dp[i] + nums[i]
     * dp[i]数组含义：
     * 表示0-i元素之和
     */
    private int[] nums;
    private int[] dp;

    public Code303(int[] nums) {

        this.nums = nums;
        dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++){
            dp[i] = 100001;
        }
    }

    public int sumRange(int i, int j) {
        if (dp[i] > 100000){
            int iSum = 0;
            for (int k = 0; k <= i; k++){
                iSum += nums[k];
            }
            dp[i] = iSum;
        }
        if (dp[j] > 100000){
            int jSum = 0;
            for (int k = 0; k <= j; k++){
                jSum += nums[k];
            }
            dp[j] = jSum;
        }
        return dp[j]-dp[i]+nums[i];
    }

    /**
     * 官方答案
     * 求区间 i ~ j 的和，可以转换为 sum[j + 1] - sum[i]，其中 sum[i] 为 0 ~ i - 1 的和。
     * 在初始化时即可将前i个数组和求解出来
     */
    private int[] sums;

    public void NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange1(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
