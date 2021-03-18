package main.java.com.zxw.sort;

/**
 * ClassName: SelectSort
 * Description:
 *
 * @author zxw
 * @date 2021/3/18 5:03 下午
 * @since JDK 1.8
 */
public class SelectSort {

    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int j = i; j < arr.length; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
            /**
             * 不可使用异或位运算做两两交换，就对于同一个值进行交换，该值会变为0
             */
//            arr[minIndex] ^= arr[i];  //arr[minIndex] = arr[minIndex] ^ arr[i]
//            arr[i] ^= arr[minIndex];  //arr[i] = arr[i] ^ arr[minIndex] ^ arr[i]=arr[minIndex]
//            arr[minIndex] ^= arr[i];  //arr[minIndex] = arr[minIndex] ^ arr[i] = arr[minIndex] ^ arr[i] ^ arr[minIndex] = arr[i]
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{3,23,1,2};
//        selectSort(arr);
//        for (int num : arr){
//            System.out.println(num);
//        }
        int a = 1;
        a ^= a;  // a = a ^ b = 0
        a ^= a; // b = a=b^0 = b
        a ^= a;
        System.out.println(a);
//        System.out.println(b);


    }
}
