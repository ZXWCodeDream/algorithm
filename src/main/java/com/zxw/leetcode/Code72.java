package main.java.com.zxw.leetcode;

/**
 * ClassName: Code72
 * Description:
 *
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * @author zxw
 * @date 2021/3/12 2:56 下午
 * @since JDK 1.8
 */
public class Code72 {

    /**
     * 状态转移方程 dp[i][j] = min(dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]) | word1[i] == word2[j]
     *                      min(dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]+1) | word1[i] != word2[j]
     *
     * dp[i][j]方程含义：word1前i个字符，word2前j个字符的最小编辑距离（最小编辑距离：字符串word1转换word2进行的最小操作数）
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        //有一个值为0，则返回不为0的长度
        if (n * m == 0){
            return n + m;
        }

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n+1;i++){
            dp[i][0] = i;
        }

        for (int j = 0; j < m+1; j++){
            dp[0][j] = j;
        }

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < m+1; j++){
                //word1插入或者word2删除
                int num1 = dp[i][j-1]+1;
                //word1删除或者word2插入
                int num2 = dp[i-1][j]+1;
                //word1修改或者word2修改
                int num3 = word1.charAt(i-1) == word2.charAt(j-1) ? dp[i-1][j-1] : dp[i-1][j-1]+1;
                dp[i][j] = Math.min(Math.min(num1,num2),num3);
            }
        }
        return dp[n][m];
    }

}
