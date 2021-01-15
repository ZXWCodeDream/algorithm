package main.java.com.zxw.leetcode;

/**
 * ClassName: Code415
 * Description:
 *
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * @author zxw
 * @date 2021/1/14 12:30 下午
 * @since JDK 1.8
 */
public class Code416 {


    /**
     * 本质其实就是0-1背包问题。题目求的是等和子集，其实就是判断数组中是否能组成和为Sum/2的序列。Sum为整个数组所有数字的和。
     *
     * 现在就是转为0-1背包问题，有n个数字，容量为Sum/2,挑选其中几个数字，看能否组成Sum/2。
     *
     * 三步走：
     *
     * 状态：
     *   可选择列表和容量，选择：选择这个数和不选择这个数
     *
     * dp数组含义：
     *  dp[i][j]表示数组前i个数，容量为j时，能否组成和为j的数。dp\[i][j] = true表示前i个数可以组成和为j的序列。
     *  basecase: dp\[i][0]= true。对于要求组成和为0，都为true，我都不选择即可。
     *
     * 根据选择做状态转移逻辑：
     *  该数值大于要求的目标和，则不选择该数，即dp\[i][j] = dp\[i-1][j]。
     *  该数组小于等于要求的目标和，则可以选择该数 dp\[i][j] = dp\[i-1][j-nums[i]],判断结果为前i-1个数，容量为j-nums[i]是否能组成j-nums[i]的序列。
     *  若不选择该数，则为dp\[i][j] = dp\[i-1][j]。
     *  最终结果 dp\[i][j] = dp\[i-1][j-nums[i]] || dp\[i-1][j] 。
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0){
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        boolean[][] dp = new boolean[n+1][sum/2+1];
        for (int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= sum/2; j++){
                if (j < nums[i-1]){ //背包容量不足以装入该数时，
                    dp[i][j] = dp[i-1][j];
                }else{
                    // 装入或者不装入
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum/2];

    }


    /**
     * 状态压缩
     * 二维数组转一维数组
     * 由上述代码可知，对于dp的值都只跟前一个值有关，即dp[i][j]只跟dp[i-1][j]有关，即只跟前一个有关系，那么我们就可以进行状态压缩，将二维数组改为一维数组
     * 代码逻辑不变， dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]; 改为dp[j] = dp[j] || dp[j-nums[i-1]]。
     * dp[j] = dp[j]。 等号左边dp[j]表示对于当前i个数，容量为j是否能组成目标和，等号右边dp[j]其实已经计算过了，即表示对于当前i-1个数，容量为j是否能组成目标和
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {

        if (nums == null || nums.length == 0){
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++){
            for (int j = sum/2; j >= 1; j--){
                if (j < nums[i-1]){ //背包容量不足以装入该数时，
                    dp[j] = dp[j];
                }else{
                    // 装入或者不装入
                    dp[j] = dp[j] || dp[j-nums[i-1]];
                }
            }
        }
        return dp[sum/2];

    }
}
