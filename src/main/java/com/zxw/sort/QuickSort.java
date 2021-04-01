package main.java.com.zxw.sort;

import main.java.com.zxw.common.Util;

/**
 * ClassName: QuickSort
 * Description:
 *
 * @author zxw
 * @date 2021/4/1 9:48 上午
 * @since JDK 1.8
 */
public class QuickSort {

    /**
     * 快速排序：分治算法
     * 分区：确定基准，进行排序，保证基准左边值小于基准值，基准右边值大于基准值
     * 返回基准下标，对基准左边的序列和右边的序列分表进行分区。
     * @param arr
     */
    public static void quickSort(int[] arr){

        if (arr == null || arr.length == 0){
            return;
        }
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr,int l,int r){

        //数组只有一个元素或者没有元素就不需要进行分区了
        if (r <= l)return;
        //对序列进行分区
        int j = partition(arr,l,r);
        sort(arr,l,j-1);
        sort(arr,j+1,r);

    }

    public static int partition(int[] arr,int l,int r){

        int i = l;
        int j = r+1;
        //将序列第一个元素确定为基准
        int v = arr[l];
        while (true){
            //从左边第二个元素开始跟基准值比较，过滤比基准小的值
            while (arr[++i] <= v){
                //判断边界
                if (i == r)break;
            }
            //从右边第一个元素开始跟基准值比较，过滤比基准大的值
            while (arr[--j] >= v){
                //判断边界
                if (j == l)break;
            }
            //左右指针相碰，退出循环
            if (i >= j)break;
            //对于左右分区不满足的元素进行交换
            Util.swap(arr,i,j);
        }
        //将基准值和j所在位置的元素互换（备注：j所在的元素一定是小于等于基准值，所以互换没问题）
        Util.swap(arr,l,j);
        return j;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,4,2,4,2,6,3};
        quickSort(arr);
        Util.print(arr);
    }
}
