package main.java.com.zxw.leetcode;

/**
 * ClassName: Code5
 * Description:
 *
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @author zxw
 * @date 2021/3/10 11:00 下午
 * @since JDK 1.8
 */
public class Code5 {

    /**
     * 解题思路：动态规划
     * 动态规划状态转移方程寻找：寻找满足条件状态子集之间的关系
     * abcba 符合回文字符串
     * bcb 符合回文字符串
     * 回文字符串去除左右两个字符依旧是回文
     * 状态转移方程则出来了：arr[l][r] = arr[l+1][r-1],s.charAt(l) == s.charAt(r)
     * dp数组arr[l][r]表示左边界为l，右边界为r的子串是否是回文字符串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        if (s == null || s.length() == 0 || s.length() == 1){
            return s;
        }
        int len = s.length();
        boolean[][] arr = new boolean[len][len];
        for (int i = 0; i < len; i++){
            arr[i][i] = true;
        }
        int start = 0,end = 1;
        int max = 0;

        // 注意从右往左遍历。若是从左往右遍历，arr[0][3]依赖于arr[1][2],此时arr[1][2]都还没计算，所以无效
        //小范围扩展到大范围
        for (int i = len-1; i >= 0; i--){
            for (int j = i; j < len; j++){
                if (i == j) continue;
                if (j - i == 1){
                    if (s.charAt(i) == s.charAt(j)){
                        arr[i][j] = true;
                        if (j-i > max){
                            max = j-i;
                            start = i;
                            end = j+1;
                        }
                    }
                }else{
                    if (s.charAt(i) == s.charAt(j)){
                        arr[i][j] = arr[i+1][j-1];
                        if (arr[i][j] && j-i > max){
                            max = j-i;
                            start = i;
                            end = j+1;
                        }
                    }
                }
            }
        }
        return s.substring(start,end);
    }

    public static void main(String[] args) {
        String s  = "aaaa";
        System.out.println(longestPalindrome(s));
    }
}
