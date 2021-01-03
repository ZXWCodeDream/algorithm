package main.java.com.zxw.leetcode;

/**
 * ClassName: Code413
 * Description:
 *
 *
 * 413. 等差数列划分
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 *
 *
 * 示例:
 *
 * A = [1, 2, 3, 4]
 *
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 * @author zxw
 * @date 2021/1/3 9:25 下午
 * @since JDK 1.8
 */
public class Code413 {

    /**
     * 状态转移方程
     *  dp[i] = dp[i-1]+1
     *  解读：如果dp[i-1]等差子数组个数为n,且dp[i]是跟着dp[i-1]的等差数，则数列为n+1()
     * dp[i]数组含义
     *  以A[i]为结尾的等差序列子数组数个数
     * 求解dp[i]过程
     *  根据A[i-2]、A[i-1]、A[i]数进行判断是否是等差数列
     *  若是,则使用状态转移方程计算
     *  若不是，则默认为0
     *
     * dp[2] = 1
     *     [0, 1, 2]
     * dp[3] = dp[2] + 1 = 2
     *     [0, 1, 2, 3], // [0, 1, 2] 之后加一个 3
     *     [1, 2, 3]     // 新的递增子区间
     * dp[4] = dp[3] + 1 = 3
     *     [0, 1, 2, 3, 4], // [0, 1, 2, 3] 之后加一个 4
     *     [1, 2, 3, 4],    // [1, 2, 3] 之后加一个 4
     *     [2, 3, 4]        // 新的递增子区间
     *
     * 综上，在 A[i] - A[i-1] == A[i-1] - A[i-2] 时，dp[i] = dp[i-1] + 1。
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {

        int[] dp = new int[A.length];
        for (int i = 2; i < dp.length; i++){
            if (isSameDif(A[i-2],A[i-1],A[i])){
                    dp[i] = dp[i-1]+1;
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++){
            sum+=dp[i];
        }
        return sum;
    }

    public static boolean isSameDif(int a,int b,int c){
        if (b-a == c-b){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(arr));
    }
}
