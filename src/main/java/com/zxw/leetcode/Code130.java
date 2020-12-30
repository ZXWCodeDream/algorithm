package main.java.com.zxw.leetcode;

/**
 * ClassName: Code130
 * Description:
 *
 *
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * @author zxw
 * @date 2020/12/30 3:58 下午
 * @since JDK 1.8
 */
public class Code130 {


    /**
     * 思路:
     * 解释中其实描述地很清楚了，只要在边界上的'O'还有与其相连的'O'都将保留，其余'O'都替换成
     * DFS：深度优先搜索，将边界的'O'并且与其相连的'O'都作标记，其余'O'都替换为'X'
     * 是否为边界判断条件: 横坐标为0或者board.length或者纵坐标为0或者纵坐标为board[0].length。通俗说第一行或最后一行或第一列或最后一列
     * @param board
     */
    public static void solve(char[][] board) {

        if (board == null || board.length == 0){
            return;
        }
        int r = board.length;
        int c = board[0].length;
        boolean[][] boardFlag = new boolean[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if ((i == 0 || i == r-1 || j == 0 || j == c-1) && board[i][j] == 'O'){
                    dfs(board,i,j,boardFlag);
                }
            }
        }

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (board[i][j] == 'O' && !boardFlag[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board,int i, int j,boolean[][] boardFlag){

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || boardFlag[i][j] || board[i][j] != 'O'){
            return;
        }
        boardFlag[i][j] = true;
        int[] moveX = new int[]{-1,1,0,0};
        int[] moveY = new int[]{0,0,-1,1};
        for (int k = 0; k < 4; k++){
            dfs(board,i+moveX[k],j+moveY[k],boardFlag);
        }
    }


    public static void main(String[] args) {

        char[][] board = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};

    }
}
