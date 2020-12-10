package main.java.com.zxw.leetcode;

/**
 * ClassName: Code240
 * Description:
 *
 *
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 *
 * @author zxw
 * @date 2020/12/10 9:37 上午
 * @since JDK 1.8
 */
public class Code240 {

    /**
     * 找准右上角的点，目标值比它小的往左找，目标值比它大的往下找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        int rNum = matrix.length;
        int cNum = matrix[0].length;
        int r = 0,c = cNum-1;
        Boolean flag = false;
        while (r < rNum && c >= 0) {
            if (matrix[r][c] == target){
                flag = true;
                break;
            }else if (matrix[r][c] > target){
                c--;
            }else{
                r++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix,-1));
    }
}
