package main.java.com.zxw.sort;

/**
 * ClassName: BubboSort
 * Description:
 *
 * @author zxw
 * @date 2021/3/17 8:28 下午
 * @since JDK 1.8
 */
public class BubboSort {

    /**
     * 冒泡排序
     * 两两比较交换，将最大值或最小值移动到最后。
     *  	1. 从头开始遍历序列，比较相邻的元素，如果前一个元素比后一个元素大，则交换这两个元素的位置
     *  	2. 对每一个相邻的元素都进行步骤一操作，这样序列最后一位元素则一定是最大的。
     *  	3. 对**除了序列最后一位元素**的其他元素进行重复步骤一和步骤二操作
     *  	4. 重复1、2、3，知道排序完成
     * @param arr
     */
    public static  void bubboSort(int[] arr){

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length-1-i; j++){
                if (arr[j] > arr[j+1]){
                    arr[j+1] ^= arr[j];
                    arr[j] ^= arr[j+1];
                    arr[j+1] ^= arr[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,23,1,2};
        bubboSort(arr);
        for (int num : arr){
            System.out.println(num);
        }
    }
}
