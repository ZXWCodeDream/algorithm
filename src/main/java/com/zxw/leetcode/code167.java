package main.java.com.zxw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: code167
 * title:167. 两数之和 II - 输入有序数组
 * Description:
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zxw
 * @date 2020/11/10 7:31 下午
 * @since JDK 1.8
 */
public class code167 {

    /**
     * 一看到求和就自然想到使用map存储差值，通过hash码查找
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int[] arr = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            map.put(target-numbers[i],i+1);
        }
        for (int i = 0,j = numbers.length-1; i < numbers.length && j >= 0; i++,j--){
            if (map.containsKey(numbers[i]) && i+1 != map.get(numbers[i])){
                arr[0] = i+1;
                arr[1] = map.get(numbers[i]);
            }
            if (map.containsKey(numbers[j]) && j+1 != map.get(numbers[j])){
                arr[0] = map.get(numbers[j]);
                arr[1] = j+1;
            }
        }
        if (arr[0] > arr[1]){
            int tmp = arr[0];
            arr[0] = arr[1];
            arr[1] = tmp;
        }
        return arr;

    }

    /**
     * 最优解
     * 解法:
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     *
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int head = 0,tail = numbers.length-1;
        while (numbers[head] + numbers[tail] != target){
            if (numbers[head] + numbers[tail] > target){
                tail--;
            }else{
                head++;
            }
        }
        arr[0] = head+1;
        arr[1] = tail+1;
        return arr;

    }


    public static void main(String[] args) {

        int[] arr = new int[]{2,7,11,15};
        int[] result = twoSum(arr,9);
        System.out.println(result[0]+"\n"+result[1]);
    }

}
