package main.java.com.zxw.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: Code695
 * Description:
 *
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 *
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * @author zxw
 * @date 2020/12/15 9:39 上午
 * @since JDK 1.8
 */
public class Code695 {

    /**
     * DFS:深度优先搜索
     * 思路：
     * 遍历二维数组，一旦碰到1，则开始寻找其相连的所有1的范围
     * 具体操作：
     * 1、将值为1的坐标放入栈中，并将该坐标值赋值为0，标识已经走过
     * 2、拿到栈顶元素（不弹出），寻找其横纵相连的点。
     *    若存在值为1的点，则放入队列中，并将该点赋值为0
     *    若对于栈顶元素不存在横纵相连值为1的点，则弹出栈顶元素，长度len++（只要弹出元素一次，len长度就加一）
     * 3、继续拿栈顶元素，重复2操作。直到栈中元素为空，len的长度即为这片区域相连的面积
     * 4、赋值maxLen为maxLen和len的最大值
     * 5、返回maxLen
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0){
            return 0;
        }
        int rl = grid.length;
        int cl = grid[0].length;
        int maxLen = 0;
        List<Pair<Integer,Integer>> moveList = Arrays.asList(new Pair<>(-1,0),new Pair<>(1,0),new Pair<>(0,-1),new Pair<>(0,1));
        for (int i = 0; i < rl; i++){
            for (int j = 0; j < cl; j++){
                if (grid[i][j] == 1){
                    grid[i][j] = 0;
                    Pair<Integer,Integer> pair = new Pair<>(i,j);
                    Stack<Pair<Integer,Integer>> stack = new Stack<>();
                    stack.push(pair);
                    int len = 0;
                    while (!stack.isEmpty()){
                        int size = stack.size();
                        Pair<Integer,Integer> state = stack.peek();
                        int x = state.getKey();
                        int y = state.getValue();
                        for (Pair<Integer,Integer> move : moveList){
                                int m = move.getKey();
                                int n = move.getValue();
                                if (x+m >= 0 && x+m < rl && y+n >= 0 && y+n < cl && grid[x+m][y+n] == 1){
                                    stack.push(new Pair<>(x+m,y+n));
                                    grid[x+m][y+n] = 0;
                                }
                        }
                        if (size == stack.size()){
                            stack.pop();
                            len++;
                        }
                    }
                    maxLen = Math.max(len,maxLen);
                }
            }
        }
        return maxLen;
    }

    /**
     * 官方DFS
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland2(int[][] grid) {

        int maxLen = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                maxLen = Math.max(maxLen,dfs(grid,i,j));
            }
        }
        return maxLen;
    }

    public static int dfs(int[][] grid,int i,int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int[] pointX = new int[]{-1,1,0,0};
        int[] pointY = new int[]{0,0,-1,1};
        int ans = 1;
        for (int index = 0; index < 4; index++){
            int x = i+pointX[index];
            int y = j+pointY[index];
            ans += dfs(grid,x,y);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] grid2 = new int[][]{{0,1,1,0,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
