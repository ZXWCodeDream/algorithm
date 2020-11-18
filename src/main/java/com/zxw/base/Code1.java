package main.java.com.zxw.base;

/**
 *
 * @author: zhengxingwang
 * @date: 2020/4/22 7:17 上午
 */

import java.util.HashMap;

/**
 *  题目：给定一个整数数列，找出其中和为特定值的那两个数。
 *  你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 *
 *  解题思路：
 *  第一种：时间复杂度为O(n2)
 *  暴力解法，遍历
 *  第二种：时间复杂度为O(2n)
 *  1、遍历整数数组arr[]，将target-arr[i]作为key，i作为value存入一个hashMap中
 *  2、遍历整数数组arr[], 查找HashMap中是否存在arr[i]的key，若存在，则需要先判断这两个值是否是同一个值
 *  (恰巧这个值的两倍是target，但这没有意义)，通过i!=hashMap.get(arr[i])，若两者坐标不相同，
 *  则其中和为特定值得那两个数为arr[i],arr[hashMap.get(arr[i])]
 *
 */
public class Code1 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,9,5,20};
        int target = 11;
        int[] result = twoSum(arr, target);
        System.out.println(result[0]+","+result[1]);
    }

//    返回坐标
    public static int[] twoSum(int[] arr,int target){

        HashMap<Integer,Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++){
            map.put(target-arr[i],i);
        }
        for (int i = 0; i < arr.length; i++){
            if (map.containsKey(arr[i]) && i != map.get(arr[i])){
                result[0] = i < map.get(arr[i]) ? i : map.get(arr[i]);
                result[1] = i < map.get(arr[i]) ? map.get(arr[i]) : i;
                break;
            }
        }
        return result;
    }
}
