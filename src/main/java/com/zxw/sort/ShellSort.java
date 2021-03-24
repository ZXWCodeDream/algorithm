package main.java.com.zxw.sort;

import main.java.com.zxw.common.Util;

/**
 * ClassName: ShellSort
 * Description:
 * 希尔排序
 * @author zxw
 * @date 2021/3/23 5:19 下午
 * @since JDK 1.8
 */
public class ShellSort {

    /**
     * 希尔排序
     * 1、确定拆分子序列个数。while(h < len/3){h = h*3+1;}，拆分成h个子序列
     * 2、将各个子序列进行插入排序，确保每个子序列都是有序的
     * 3、缩小子序列个数h=h/3,拆分成h/3个子序列，重复2操作，直到h=1，即对整个序列都进行排序了
     *
     * 举例：
     * {1,2,3,12,1,2,23,5},以下使用下标表示
     * (0,1,2,3,4,5,6,7,8),len=9,h=4
     * 0,4
     * 1,5
     * 2,6
     * 3,7
     * 4,9
     * 本质就是拆分成四个序列：(0,4,9)、（1，5）、（2，6）、（3，7）
     * 2、h=h/3=1
     * 0,1
     * 1,2
     * 1,2,3
     * 1,2,3,4
     * 1,2,3,4,5
     * 1,2,3,4,5,6
     * 1,2,3,4,5,6,7
     * 1,2,3,4,5,6,7,8
     * 本质就是拆分成一个序列：（0，1，2，3，4，5，6，7，8）
     *
     *
     * @param arr
     */
    public static void shellSort(int[] arr){

        int len  = arr.length;
        int h = 1;
        while (h < len/3){
            h = h*3+1;
        }

        while (h >= 1){
            for (int i = h; i < len; i++){
                for (int j = i; j >= h && arr[j] < arr[j-h];j-=h){
                    Util.swap(arr,j,j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,12,1,2,23,5,4};
        shellSort(arr);
        Util.print(arr);
    }
}
