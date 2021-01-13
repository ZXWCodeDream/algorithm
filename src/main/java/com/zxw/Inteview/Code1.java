package main.java.com.zxw.Inteview;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * ClassName: Code1
 * Description:
 *
 *
 *  题目描述：
 *   循环打印矩阵
 *   举例：
 *   1  2  3  4
 *   5  6  7  8
 *   9  10 11 12
 *   13 14 15 16
 *
 *   打印结果为：1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * @author zxw
 * @date 2021/1/13 8:05 下午
 * @since JDK 1.8
 */
public class Code1 {


    /**
     * 思路：
     * 循环打印矩阵可以看成一圈一圈打印
     * 举例：
     *  1  2  3  4
     *  5  6  7  8
     *  9  10 11 12
     *  13 14 15 16
     *
     *  本质就是打印两个圈，（6 7 11 10）为内圈，其余为外圈
     *  所以就找好临界点，一圈一圈遍历打印
     *  临界点其实就是矩阵的四个角
     *  所以创建如下四个变量控制边界
     * @param arr
     * @param sr startRow 开始行
     * @param sc startColumn 开始列
     * @param er endRow 结束行
     * @param ec endColumn 结束列
     */
    public static void printF(int[][] arr,int sr,int sc,int er,int ec){

        int i = sr,j = sc;
        for (;j <= ec;j++){ //打印最上面一行
            System.out.print(arr[i][j] + " ");
        }
        j--; //使得j=ec
        for (i = sr+1; i <= er; i++){ //打印最右面一行
            System.out.print(arr[i][j]+" ");
        }
        i--; //使得i=er
        for (j = ec-1; j >=sc; j-- ){ //打印最下面一行
            System.out.print(arr[i][j] + " ");
        }
        j++; //使得j=sc
        for (i = er-1; i >= sr+1; i--){ //打印最左边一行
            System.out.print(arr[i][j] + " ");
        }
    }

    public static void printA(int[][] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int sr = 0,sc = 0,er = arr.length-1,ec = arr[0].length-1;

        while (sr <= er && sc <= ec) {
            printF(arr, sr, sc, er, ec);
            sr++;
            sc++;
            er--;
            ec--;
        }
    }


//
//    public static void  printC(int[][] arr){
//        if (arr == null || arr.length == 0){
//            return;
//        }
//        int r = arr.length;
//        int c = arr[0].length;
//        int s = 0;
//
//        while (s <= r && s <= c) {
//            int j = s, i = s;
//            for (; j < c; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            i++;
//            j--;
//            for (; i < r; i++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            i--;
//            j--;
//            for (; j >= s; j--) {
//                System.out.print(arr[i][j] + " ");
//            }
//            i--;
//            j++;
//            for (; i > s; i--) {
//                System.out.print(arr[i][j] + " ");
//            }
//            s++;
//            r--;
//            c--;
//        }
//
//
//    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        printC(arr);
        System.out.println();
        printA(arr);

    }
}
