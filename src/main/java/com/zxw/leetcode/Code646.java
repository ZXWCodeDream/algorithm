package main.java.com.zxw.leetcode;

import java.util.Arrays;

/**
 * ClassName: Code646
 * Description:
 *
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 *
 * 提示：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 *
 * @author zxw
 * @date 2021/1/9 8:25 下午
 * @since JDK 1.8
 */
public class Code646 {

    /**
     * 动态规划大部分的本质其实就是穷举找到目标值
     * 动态规划转移方程： dp[i] = Max(dp[j])+1 | j < i && pairs[j][1] < pairs[i][0] pairs以pairs[n][0]从小到大排序
     * dp[i]数组含义： 以pairs[i]为结尾的最长数对链的长度
     * 思路：在一个长度为k，并且以pairs[j]结尾的对链中，如果pairs[j][1] < pairs[i][0],则将该点加入对链中，对链长度+1
     *      首先根据数对的第一个数进行排序，这样就能保证每一个节点都不能拼接在之前对链的前面，只可能拼接在对链的后面。
     *      其次开始遍历排序后的数组pairs,每当遍历一个点时，都要对之前的点进行pairs[j][1] < pairs[i][0]判断以及获取dp[j]的最大值
     *      最后将该点拼接到之前满足pairs[j][1] < pairs[i][0]条件且最长的对链的后面，即dp[i] = Max(dp[j])+1
     * @param pairs
     * @return
     */
    public  static int findLongestChain(int[][] pairs) {

        if (pairs == null || pairs.length == 0){
            return 0;
        }
        int n = pairs.length;
        int[] dp = new int[n];
        int maxLen = 0;
        Arrays.sort(pairs,(a,b) -> a[0] < b[0] ? -1 : 1);

        for (int i = 0; i < n; i++){
            int max = 0;
            for (int j = i-1; j >= 0; j--){
               if (pairs[j][1] < pairs[i][0]){
                   max = Math.max(max,dp[j]);
               }
            }
            dp[i] = max+1;
            maxLen = Math.max(maxLen,dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1,2}, {2,3}, {3,4}};
        int[][] arr2 = new int[][]{{3,4}, {2,3}, {1,2}};
        int[][] arr3 = new int[][]{{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};




        System.out.println(findLongestChain(arr));
        System.out.println(findLongestChain(arr2));
        System.out.println(findLongestChain(arr3));
    }
}
