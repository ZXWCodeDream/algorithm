package main.java.com.zxw.sort;

import main.java.com.zxw.common.Util;

/**
 * ClassName: MergeSort
 * Description:
 *
 * @author zxw
 * @date 2021/3/22 8:50 下午
 * @since JDK 1.8
 */
public class MergeSort {

    public static void mergeSort(int[] arr){

        if (arr == null || arr.length == 0)return;
        int[] aux = new int[arr.length];
        mergeSort(arr,aux,0,arr.length-1);
    }

    public static void mergeSort(int[] arr,int[] aux,int l,int r){

        if (l >= r)return;
        int middle = (r-l)/2+l;
        mergeSort(arr,aux,l,middle);
        mergeSort(arr,aux,middle+1,r);
        merge(arr,aux,l,middle,r);

    }

    /**
     * 数组aux的作用就是保存一段区间的数据，
     * @param arr
     * @param aux
     * @param l
     * @param m
     * @param r
     */
    public static void merge(int[] arr,int[] aux,int l,int m,int r){

        /**
         * 将区间[l,r]的值赋予aux
         */
        for (int k = l; k <= r; k++){
            aux[k] = arr[k];
        }
        // 有序子序列区间为[l,m]和[m+1,r]
        int i = l,j = m+1;
        // merge aux数组有序区间[l,m]和[m+1,r]到[l,r]
        for (int k = l; k <= r; k++){
            if (i > m) {arr[k] = aux[j++];}
            else if (j > r){arr[k] = aux[i++];}
            else if (aux[i] < aux[j]){arr[k] = aux[i++];}
            else{arr[k] = aux[j++];}
        }

    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,5,2};
        mergeSort(arr);
        Util.print(arr);
    }
}
