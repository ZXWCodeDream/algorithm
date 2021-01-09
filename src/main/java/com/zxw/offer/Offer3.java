package main.java.com.zxw.offer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ClassName: Offer3
 * Description:
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * @author zxw
 * @date 2020/9/14 10:06 上午
 * @since JDK 1.8
 */
public class Offer3 {

    public static void main(String[] args) {

        int[] numbers = new int[]{2,3,1,0,2,5,3};
        int[] duplication = new int[1];
        duplicateStandard(numbers,numbers.length,duplication);
        System.out.println(duplication[0]);
    }

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {

            int[] index = new int[length];
            for (int i = 0; i < length; i++){
                if (index[numbers[i]] == 0){
                    index[numbers[i]] = 1;
                }else{
                    duplication[0] = numbers[i];
                    return true;
                }
            }
            return false;
    }


    /**
     * 标准答案思路：
     * 时间复杂度O(n),空间复杂度O(1)，所以不应该借助任何标记数组
     * 对于数字大小范围在（0，n）之间的数组，可以让值为i的元素调整到第i个位置上进行求解
     */
    public static boolean duplicateStandard(int numbers[],int length,int [] duplication) {

        if (numbers == null || numbers.length == 0){
            return false;
        }
        for (int i = 0; i < length; i++){
            if (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers,i,numbers[i]);
            }
        }
        return false;
    }

    public static void swap1(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

}


