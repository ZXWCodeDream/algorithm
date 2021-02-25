package main.java.com.zxw.leetcode;


/**
 * ClassName: Code867
 * Description:
 * 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 * @author zxw
 * @date 2021/2/25 4:37 下午
 * @since JDK 1.8
 */
public class Code867 {

    /**
     * 理清题目意思，不是对角线的值两两交换，而是沿着对角线翻转。
     * @param matrix
     * @return
     */
    public static int[][] transpose(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] result = new int[c][r];
        for (int i = 0; i < c; i++){
            for (int j = 0; j < r; j++){
                result[i][j] = matrix[j][i];
            }
        }
        return result;

    }


    public static void main(String[] args) {
       int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] transpose = transpose(matrix);
        for (int i = 0; i < transpose.length; i++){
            System.out.println();
            for (int j = 0; j < transpose[0].length; j++){
                System.out.print(transpose[i][j]+",");
            }
        }
    }

}
