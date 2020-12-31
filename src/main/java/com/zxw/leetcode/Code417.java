package main.java.com.zxw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Code417
 * Description:
 *
 *
 * 417. 太平洋大西洋水流问题
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 *
 *
 * 提示：
 *
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *
 *
 * 示例：
 *
 *
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 * @author zxw
 * @date 2020/12/31 10:41 上午
 * @since JDK 1.8
 */

public class Code417 {


    /**
     * 思路：
     * 虽然垃圾地过了，效率贼低，也记录下思路过程吧。emmm...
     * 想法很简单，对于每一个点都进行一次dfs，判断能不能到大西洋和太平洋。注意通过全局变量保存是否到达太平洋和是否到达大西洋  以及 记录走过的点，避免死循环。
     * 然后每次dfs之前都初始化false
     */
    private static Boolean lUpFlag = false;
    private static Boolean rDownFlag = false;

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return result;
        }
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                lUpFlag = false;
                rDownFlag = false;
                boolean[][] flag = new boolean[r][c];
                dfs(matrix,i,j,flag);
                if (lUpFlag && rDownFlag){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public static void dfs(int[][] matrix,int i,int j,boolean[][] flag){

        if (lUpFlag && rDownFlag){
            return;
        }
        flag[i][j] = true;
        int r = matrix.length;
        int c = matrix[0].length;

        if ( i == 0 || j == 0){
            lUpFlag = true;
        }
        if (i == r-1 || j == c-1){
            rDownFlag = true;
        }
        int[] moveX = new int[]{1,-1,0,0};
        int[] moveY = new int[]{0,0,1,-1};
        for (int k = 0; k < 4; k++){
            if (i+moveX[k] >= 0 && i+moveX[k] < r && j+moveY[k] >= 0 && j+moveY[k] < c && matrix[i][j] >= matrix[i+moveX[k]][j+moveY[k]] && !flag[i+moveX[k]][j+moveY[k]]){
               dfs(matrix,i+moveX[k],j+moveY[k],flag);
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(matrix));
    }


    /**
     * 官方思路:
     * 从边界出发寻找，借助int[][] grid备注数值。
     * 从太平洋出发（即x=0或y=0）对每一个经过的点grid[i][j]+1,从大西洋出发(即x=r-1或y=c-1)对每一个经过的点grid[i][j]+2
     * 即从太平洋出发经过的点 grid[i][j]等于1，从大西洋出发经过的点 grid[i][j]等于2，要是grid[i][j]等于3，表示即能从大西洋经过又能从太平洋经过
     * 注意若 grid[i][j]已经等于1时不能再+1，已经等于2时不能再+2
     */
    class Solution {

        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> result = this.result;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return result;
            int line = matrix.length, column = matrix[0].length;
            //初始值0
            int[][] grid = new int[line][column];
            //遍历边界节点
            for (int y = 0; y < column; y++) {
                flow(matrix, 0, y, grid, 1);
            }
            for (int y = 0; y < column; y++) {
                flow(matrix,line- 1, y, grid, 2);
            }
            for (int x = 0; x < line; x++) {
                flow(matrix, x, 0, grid, 1);
            }
            for (int x = 0; x < line; x++) {
                flow(matrix, x, column - 1, grid, 2);
            }
            return result;
        }
        private void flow(int[][] matrix,int x, int y, int[][] grid, int flag) {
            //相同方向来的就不用走了，两个方向都走过的也不用走了
            if (grid[x][y] == flag || grid[x][y] == 3)
                return;
            grid[x][y] += flag;
            // 1+2=3,大西洋和太平洋都经过
            if (grid[x][y] == 3) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(y);
                result.add(temp);
            }
            if (x != 0 && matrix[x - 1][y] >= matrix[x][y])
                flow(matrix, x - 1, y, grid, flag);
            if (x != matrix.length - 1 && matrix[x + 1][y] >= matrix[x][y])
                flow(matrix, x + 1, y, grid, flag);
            if (y != 0 && matrix[x][y - 1] >= matrix[x][y])
                flow(matrix, x,y-1, grid, flag);
            if (y != matrix[0].length - 1 && matrix[x][y + 1] >= matrix[x][y])
                flow(matrix, x, y + 1, grid, flag);
        }
    }

}
