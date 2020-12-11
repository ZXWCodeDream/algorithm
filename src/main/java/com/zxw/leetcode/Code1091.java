package main.java.com.zxw.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Code1091
 * Description:
 *
 * 1091. 二进制矩阵中的最短路径
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,0]]
 *
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 *
 * 输出：4
 *
 *
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 *
 * @author zxw
 * @date 2020/12/11 9:42 上午
 * @since JDK 1.8
 */
public class Code1091 {

    /**
     * 思路：
     * BFS：广度优先搜索，将从当前节点能走一步的所有节点都存入队列中，记录横纵坐标以及步数。
     * 每次都将相同步数的节点遍历出来，寻找下一个能走的节点，都将其放入队列中。哪个节点最先找到目标值就是最短路径。
     * 特别注意：在寻找下一个能走的节点时，需考虑前后左右以及对角的位置，只要值为0，即路畅通状态就放入队列中，放入队列后将该位置赋值为1，表示已经走过，不可再走
     * @param grid
     * @return
     */
    public static int shortestPathBinaryMatrix(int[][] grid) {

        int rl = grid.length;
        int cl = grid[0].length;
        if (grid[0][0] == 1 || grid[rl-1][cl-1] == 1){
            return -1;
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        int r = 0,c = 0,l = 1;
        List<Integer> list = new ArrayList<>();
        queue.add(genList(r,c,l));
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                list.clear();
                list = queue.poll();
                r = list.get(0);
                c = list.get(1);
                l = list.get(2);
                if (r == rl - 1 && c == cl - 1) {
                    return l;
                }
                for (int m = -1; m <= 1; m++){
                    for (int n = -1; n <= 1; n++){
                        int rr = m+r;
                        int cc = n+c;
                        if (rr >= 0 && rr < rl && cc >= 0 && cc < cl && grid[rr][cc] == 0){
                            queue.add(genList(rr,cc,l+1));
                            grid[rr][cc] = 1;
                        }
                    }
                }
            }
        }
        return -1;

    }

    public static List<Integer> genList(int r,int c,int l){
        List<Integer> list = new ArrayList<>(3);
        list.add(r);
        list.add(c);
        list.add(l);
        return list;
    }

    public static void main(String[] args) {

        int[][] arr1 = new int[][]{{0,1},{1,0}};
        int[][] arr2 = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int[][] arr = new int[][]{{0,0,1,0,0,0,0},{0,1,0,0,0,0,1},{0,0,1,0,1,0,0},{0,0,0,1,1,1,0},{1,0,0,1,1,0,0},{1,1,1,1,1,0,1},{0,0,1,0,0,0,0}};
        System.out.println(shortestPathBinaryMatrix(arr));
    }
}
