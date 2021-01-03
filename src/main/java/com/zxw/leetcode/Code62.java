package main.java.com.zxw.leetcode;

/**
 * ClassName: Code62
 * Description:
 *
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *
 *
 * 提示：
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 *
 * @author zxw
 * @date 2021/1/3 3:30 下午
 * @since JDK 1.8
 */
public class Code62 {

    /**
     * 状态转移方程
     *  dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *  dp[i-1][j]为0时赋值为1
     * dp数组含义
     *  dp[i][j]表示到达坐标(i,j)的不同路径总数
     * @param m
     * @param n
     * @return
     */
    public static  int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }else if (i == 0){
                    dp[i][j] = dp[i][j-1] == 0 ? 1 : dp[i][j-1];
                }else if (j == 0){
                    dp[i][j] = dp[i-1][j] == 0 ? 1 : dp[i-1][j];
                }else{
                    dp[i][j] = (dp[i][j-1] == 0 ? 1 : dp[i][j-1]) + (dp[i-1][j] == 0 ? 1 : dp[i-1][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
    }
}
