package main.java.com.zxw.leetcode;

/**
 * ClassName: Code1004
 * Description:
 *
 * 1004. 最大连续1的个数 III
 *
 *给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 *

 * @author zxw
 * @date 2021/2/24 1:39 下午
 * @since JDK 1.8
 */
public class Code1004 {

    /**
     * 解法：滑动窗口
     * @param A
     * @param K
     * @return
     */
    public static int longestOnes(int[] A, int K) {

        if (A == null || A.length == 0){
            return 0;
        }
        //1个数
        int num1 = 0;
        //滑动窗口左右指针
        int left = 0,right = 0;
        int len = A.length;
        while (right < len){
            if (A[right] == 1){
                num1++;
            }
            //滑动窗口的长度 > 1的个数+K,此时滑动窗口内不满足替换K个值后连续1的最大长度，让左指针右移
            if (right-left+1 > num1 + K){
                if (A[left] == 1){
                    num1--;
                }
                left++;
            }
            right++;
        }
        return right-left;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2; //output:6
        int[] arr1 = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k1 = 3;//output:10
        System.out.println(longestOnes(arr,k));
        System.out.println(longestOnes(arr1,k1));

    }
}
