package main.java.com.zxw.leetcode;

import java.util.*;

/**
 * ClassName: Code279
 * Description:
 *
 * 279. 完全平方数
 * 给定正整数 n，找到n若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * @author zxw
 * @date 2020/12/12 7:26 下午
 * @since JDK 1.8
 */
public class Code279 {

    /**
     * BFS 广度优先搜索，关键点在于剪枝boolean[] marked = new boolean[n+1];记录每次放入队列的数，要是放过了，就不再放了，不然队列中就会存在诸多的数据，导致超时
     * @param n
     * @return
     */
    public static int numSquares2(int n) {
        List<Integer> list = getNums(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n+1];
        for (Integer num : list){
            queue.add(n-num);
            marked[n-num] = true;
        }

        int count = 0;
        while (!queue.isEmpty()){

            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int value = queue.poll();
                if (value == 0){
                    return count;
                }
                for (Integer num : list){
                    if (num <= value){
                        if (marked[value-num]){
                            continue;
                        }
                        queue.add(value-num);
                        marked[value-num] = true;
                    }
                }

            }
        }
        return count;

    }

    private static int[] dp;
    /**
     * 自顶向下，缺点getNums重复调用，效率低下
     * 状态转移方程
     *  f(n) = Min(f(n-i)+1) | 1 <= i*i <= n
     * dp[n]数组介绍
     *  dp[n]表示数为n时最少完全平方数组成的个数
     * @param n
     * @return
     */
    public static int numSquares3(int n) {
        dp = new int[n+1];
        return calc3(n);
    }

    public static int calc3(int n){
        if (dp[n] != 0){
            return dp[n];
        }
        List<Integer> nums = getNums(n);
        for (Integer num : nums){
            dp[n] = dp[n] == 0 ? calc3(n-num)+1 : Math.min(dp[n],calc3(n-num)+1);
        }
        return dp[n];
    }

    /**
     * 自低向上
     * 状态转移方程
     *  f(n) = Min(f(n-i)+1) | 1 <= i*i <= n
     * dp[n]数组介绍
     *  dp[n]表示数为n时最少完全平方数组成的个数
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        dp = new int[n+1];
        List<Integer> nums = getNums(n);
        for (int i = 1; i <= n; i++){
            Integer min = Integer.MAX_VALUE;
            for (Integer num : nums){
                if (num > i)continue;
                min = Math.min(min,dp[i-num]+1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static List<Integer> getNums(int n){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= n; i++){
            result.add(i*i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSquares2(12));
        System.out.println(numSquares2(13));
        System.out.println(numSquares2(7168));

        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(7168));

    }
}
