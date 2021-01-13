package main.java.com.zxw.leetcode;

/**
 * ClassName: Code1143
 * Description:
 *1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 *
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符
 * @author zxw
 * @date 2021/1/13 10:04 上午
 * @since JDK 1.8
 */
public class Code1143 {

    /**
     * 思路:
     *
     * 利用最长公共子序列常用算法，定义dp\[i][j]数组表示字符串text1前i个字符和字符串text2前j个字符的最长公共子序列的长度。考虑两种情况
     *
     * - 当text1[i] == text2[j]时，即可在字符串text1前i-1个字符和字符串text2前j-1个字符的最长公共子序列基础 上加上当前字符，即长度=1。dp\[i][j] = dp\[i-1][j-1]+1。
     * - 当text1[i] != text2[j]时，最长公共子序列长度可能为dp\[i-1][j],也可能为dp\[i][j-1],所以取最大值
     *
     * 总结状态转移方程为:
     * dp[i][j] = dp[i-1][j-1] + 1 | text1[i] = text2[j]
     * dp[i][j] = Max(dp[i-1][j],dp[i][j-1]) | text1[i] != text2[j]
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
        System.out.println(longestCommonSubsequence("ace","ace"));
        System.out.println(longestCommonSubsequence("ace","dgf"));
    }
}
