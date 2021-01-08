package main.java.com.zxw.leetcode;

/**
 * ClassName: Code91
 * Description:
 *
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 *
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 *
 * 输入：s = "1"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * @author zxw
 * @date 2021/1/7 11:50 上午
 * @since JDK 1.8
 */
public class Code91 {


    /**
     * 从右向左
     * 动态转移方程
     *  dp[i] += dp[j] | i+1 <= j <= i+2
     * 解释：
     *   假设字符串长度为n,举例从右开始截取的一个子串为xxxx,我们假设dp[x]=n,dp[x+1]=m（dp[x]代表位置x到n的所有解码总数）
     *   现在开始考虑Axxxx的解码总数，只会有以下3种情况：
     *   1、当A='0'时，则dp[x-1] = 0,因为没有以0带头的编码
     *   2、只考虑追加编码，不考虑组合，即A直接转为【0，9】对应编码时，则dp[x-1] += dp[x]。因为xxxx所有组合为n,则在字符串后面拼接一个字符所有组合也为n。
     *   3、不考虑追加编码，考虑组合时，即当子串（Ax）xxx中的Ax能组成<=26的数时，dp[x-1] += dp[x+1]。因为xxx所有组合为m,则再字符串后面拼接固定Ax对应的编码所有组合也为m。
     *
     * dp[i]数组含义
     *  字符串s的子串[i,s.length-1]所有解码总数
     * @param s
     * @return
     */
    public static long numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for (int i = n-1; i >= 0; i--){
            if (s.charAt(i) == '0')continue; //默认为0
            int num = 0;
            for (int j = i; j < n && j-i<2; j++){
                num = num*10+(s.charAt(j)-'0');
                if (num <= 26){
                    dp[i] += dp[j+1];
                }
            }
        }
        return dp[0];
    }


    /**
     * 回溯算法：超时
     * 由于本题并没有要求输出所以的排列组合，只要求输出排列组合的数量，并且数据量n为8位数，则使用回溯算法的时间负责度为O(n!),效率低
     */
    private static long count = 0;
    public static long numDecodings2(String s) {
        backTrack2(s,0);
        return count;
    }

    public static void backTrack2(String s,int index){
        if (index >= s.length()){
            count++;
            return;
        }
        for (int i = 1; i <= 2 && i+index <= s.length(); i++){
            String s1 = s.substring(index, index + i);
            if (s1.charAt(0) == '0')continue;
            int num = Integer.valueOf(s1);
            if (num >= 1 && num <= 26 ){
                backTrack2(s,index+i);
            }
        }
    }

    public static void main(String[] args) {
        String s = "12";
        String s1 = "226";
        String s2 = "11111";
        String s3 = "111111111111111111111111111111111111111111111";

//        System.out.println(numDecodings(s));
//        System.out.println(numDecodings(s1));
//        System.out.println(numDecodings(s2));
        System.out.println(numDecodings(s3));
    }
}
