package main.java.com.zxw.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * ClassName: CodeM17
 * Description:
 *
 * 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * @author zxw
 * @date 2020/12/10 9:57 上午
 * @since JDK 1.8
 */
public class CodeM17 {

    /**
     * 排序
     * @param arr
     * @param k
     * @return
     */
    public static  int[] smallestK2(int[] arr, int k) {

        Arrays.sort(arr);
        return Arrays.stream(arr).limit(k).toArray();
    }

    /**
     * 借助优先队列
     * @param arr
     * @param k
     * @return
     */
    public static  int[] smallestK(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x,y)-> x > y ? -1 : 1);
        for (int i = 0; i < arr.length; i++){
            if (queue.size() != k){
                queue.add(arr[i]);
            }else if (arr[i] < queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] result = new int[k];
        int j = 0;
        while (!queue.isEmpty()){
            result[j++] = queue.poll();
        }
        return result;

    }


        public static void main(String[] args) {

        int[] arr = new int[]{1,3,5,7,2,4,6,8};
        int[] ints = smallestK(arr, 4);
        for (int i : ints){
            System.out.println(i);
        }
    }
}
