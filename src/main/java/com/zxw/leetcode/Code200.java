package main.java.com.zxw.leetcode;

/**
 * ClassName: Code200
 * Description:
 *
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * @author zxw
 * @date 2020/12/16 11:02 上午
 * @since JDK 1.8
 */
public class Code200 {

    /**
     * 思路：
     * 经典的DFS，深度优先搜索
     * 对于二维数组每一个值为1的元素都进行深度优先搜索，将相关联的值都赋值为0.统计次数
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length;i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid,int i,int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        int[] pointx = new int[]{-1,1,0,0};
        int[] pointy = new int[]{0,0,1,-1};
        for (int index = 0; index < 4; index++){
            dfs(grid,i+pointx[index],j+pointy[index]);
        }
     }


    public static void main(String[] args) {

        char[][] grid = new char[][]{
                {'1','1','1','0','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
