package main.java.com.zxw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Code1329
 * Description:
 *
 * 1329. 将矩阵按对角线排序
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 *
 * @author zxw
 * @date 2021/1/16 5:11 下午
 * @since JDK 1.8
 */
public class Code1329 {

    public static int[][] diagonalSort(int[][] mat) {

        if (mat == null || mat.length == 0){
            return mat;
        }
        int r = mat.length;
        int c = mat[0].length;

        for (int i = 0; i < c-1; i++){
            sortArr(mat,0,i,r,c);
        }
        for (int i = 0; i < r-1; i++){
            sortArr(mat,i,0,r,c);
        }
        return mat;
    }

    public  static void sortArr(int[][] mat,int rr,int cc,int r,int c){
        List<Integer> list = new ArrayList<>();
        while (rr < r && cc < c){
            list.add(mat[rr][cc]);
            rr++;
            cc++;
        }
        list.sort((a,b) -> a < b ? 1 :  (a == b ? 0 : -1));
        rr--;cc--;
        int j = 0;
        while (rr >= 0 && cc >= 0){
            mat[rr][cc] = list.get(j);
            j++;rr--;cc--;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] ints = diagonalSort(arr);
        for (int i = 0; i < ints.length ; i++) {
            for (int j = 0; j < ints[0].length; j++){
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();

        }

    }
}
