package main.java.com.zxw.leetcode;

/**
 * ClassName: Code343
 * Description:
 *
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * @author zxw
 * @date 2021/1/3 10:05 下午
 * @since JDK 1.8
 */
public class Code343 {


    /**
     * 状态转移方程：
     *  f(n) = Max(dp[n-i]*dp[i]) | 1 <= i <= n/2;
     * dp[i]数组的含义
     *  正整数i拆分成至少两个整数的乘积的最大值
     * 考虑特殊情况：
     *  当i <= 4时，拆分的乘积小于等于自身。当本身给定的正整数小于4时，单独求解。作拆分时，使用自身数据
     */

    private static int[] dp;
    public static int integerBreak(int n) {

        dp = new int[n+1];
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        return calc(n);
    }

    /**
     * 自顶向下 使用递归求解
     * 若自底向上，可以使用for循环代替 （i = 2; i <= n; i++）
     * @param n
     * @return
     */
    public static int calc(int n){

        if (dp[n] != 0){
            return dp[n];
        }
        if (n <= 4){
            return n;
        }
        for (int i = 1; i <= n/2; i++){
            dp[n] = Math.max(calc(i)*calc(n-i),dp[n]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(3));
    }
}
