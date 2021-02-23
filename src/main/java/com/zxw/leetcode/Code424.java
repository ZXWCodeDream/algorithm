package main.java.com.zxw.leetcode;

import java.util.*;

/**
 * ClassName: Code424
 * Description:
 * 424. 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * @author zxw
 * @date 2021/2/2 5:49 下午
 * @since JDK 1.8
 */
public class Code424 {

    public static int characterReplacement(String s, int k) {

        if (s == null || s.length() == 0){
            return 0;
        }

        int len = s.length();
        if (len < 2){
            return len;
        }
        //滑动窗口左右指针
        int left = 0,right = 0;
        int[] charNum = new int[26];
        //字符最大重复数
        int max = 0;
        char[] chars = s.toCharArray();

        while (right < len){
            charNum[chars[right]-'A']++;
            max = Math.max(max, charNum[chars[right]-'A']);
            //此时窗口内无法满足替换k个字符而达到最长连续重复数，则让左指针右移
            if (right - left + 1 > max+k){
                charNum[chars[left]-'A']--;
                left++;
            }
            right++;

        }
        return right-left;
    }

    public static void main(String[] args) {

        String s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int k = 4;
        String s1 = "AABABBA";
        int k1 = 1;
        System.out.println(characterReplacement(s1,k1));

    }
}
