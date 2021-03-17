package main.java.com.zxw.leetcode;

import java.util.Arrays;

/**
 * ClassName: Code66
 * Description:
 *
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author zxw
 * @date 2021/3/17 4:08 下午
 * @since JDK 1.8
 */
public class Code66 {

    public static int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0){
            return digits;
        }
        int n = digits.length;
        int pre = 1;
        for (int i = n-1; i >= 0; i--){
            if (digits[i] == 9 && pre == 1){
                digits[i] = 0;
                continue;
            }else{
                digits[i] = digits[i]+pre;
                pre = 0;
                break;
            }

        }
        if (pre == 0){
            return digits;
        }else{
            int[] result = Arrays.copyOf(digits, n + 1);
            result[0] = 1;
            result[n] = 0;
            return  result;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,9,9};
        int[] ints = plusOne(arr);
        for (int num : ints){
            System.out.println(num);
        }

    }
}
