package main.java.com.zxw.leetcode;

/**
 * ClassName: Code583
 * Description:
 *
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 *
 *
 * 示例：
 *
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 *
 * 提示：
 *
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 *
 * @author zxw
 * @date 2021/3/11 2:04 下午
 * @since JDK 1.8
 */
public class Code583 {

    /**
     * 本质就是求最长公共子序列
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {

        if (word1 == null || word2 == null){
            return 0;
        }
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] arr = new int[n1+1][n2+1];
        for (int i = 1; i <= n1; i++){
            for (int j = 1; j <= n2; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1]+1;
                }else{
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return n1+n2-2*arr[n1][n2];
    }

    public static void main(String[] args) {

        String s1 = "eafd";
        String s2 = "eafdf";
        System.out.println(minDistance(s1,s2));
    }
}
