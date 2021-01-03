package main.java.com.zxw.leetcode;


/**
 * ClassName: Code64
 * Description:
 *
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *
 *
 * 示例 1：
 *  1  3  1
 *  1  5  1
 *  4  2  1
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * @author zxw
 * @date 2021/1/3 12:56 下午
 * @since JDK 1.8
 */
public class Code64 {

    /**
     * 动态规划转移方程
     * dp[i][j] = Min(dp[i-1][j],dp[i][j-1])+grid[i][j]
     * dp[][]数组含义
     * 到达(i,j)坐标时移动的最小数之和
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0){
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r+1][c+1];
        for (int i = 0; i < r+1; i++){
            for (int j = 0; j < c+1; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1 ; i < r+1; i++){
            for (int j = 1; j < c+1; j++){
               dp[i][j] = (Math.min(dp[i-1][j],dp[i][j-1]) == Integer.MAX_VALUE ? 0 : Math.min(dp[i-1][j],dp[i][j-1])) +grid[i-1][j-1];
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int[][] arr = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minPathSum(arr));
    }
}
