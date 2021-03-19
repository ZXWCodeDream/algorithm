package main.java.com.zxw.sort;

import main.java.com.zxw.common.Util;

/**
 * ClassName: InsertSort
 * Description:
 *
 * @author zxw
 * @date 2021/3/19 10:39 上午
 * @since JDK 1.8
 */
public class InsertSort {

    /**
     * 插入排序
     * 将未排序序列中的首元素插入到有序序列中应有的位置
     * @param arr
     */
    public static void insertSort(int[] arr){

        for (int i = 1; i < arr.length; i++){
            for (int j = i; j >=0 && arr[j] < arr[j-1];j--){
                Util.swap(arr,j,j-1);
            }
        }
    }



    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,5,43,2};
        insertSort(arr);
        Util.print(arr);
    }
}
