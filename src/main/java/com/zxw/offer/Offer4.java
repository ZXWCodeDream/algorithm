package main.java.com.zxw.offer;

import sun.jvm.hotspot.ui.action.FindAction;

/**
 * ClassName: Offer4
 * Description:
 *在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 解题思路：
 * 一定要找好点，每一行从左往右递增，从上到下递增，则右上角的点是判断最好的出发点，因为比它小的数一定在他左边，比它大的数一定在它下面
 * @author zxw
 * @date 2020/9/15 9:34 上午
 * @since JDK 1.8
 */
public class Offer4 {

    public static void main(String[] args) {

        int[][] array = new int[][]{{1,4,7,11,15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int[][] arr = new int[][]{};
        System.out.println(Find(5,array));
    }

    public static boolean Find(int target, int [][] array) {

        if (array == null || array.length == 0 || array[0].length == 0 || target < array[0][0] || target > array[array.length-1][array[0].length-1]){
            return false;
        }
        int rows = array.length,columns = array[0].length;
        int rRow = 0,rCol = columns-1;
        while (rRow < rows && rCol >= 0){
            if (array[rRow][rCol] == target){
                return true;
            }else if (array[rRow][rCol] < target){
                rRow++;
            }else{
                rCol--;
            }
        }
        return false;
    }
}
