package main.java.com.zxw.leetcode;

import java.util.Arrays;

/**
 * ClassName: Code567
 * Description:
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 提示：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * @author zxw
 * @date 2021/2/25 9:39 上午
 * @since JDK 1.8
 */
public class Code567 {


    /**
     *  解法：滑动窗口
     *  字符串s1的排列是另一个字符串s2的子串。
     *  我们不用考虑字符串s1的全排列，只要s2字符串内存在长度为n，且对应字符个数和s1相同，即存在s1的排列之一是s2的子串
     *  举例： s1="acs" 只要判断s2中存在长度为n的子串，且字符内容包含一个a,一个c,一个s,即可确保s1的排列之一是s2的子串
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() > s2.length()){
            return false;
        }
        if ( s1.equals("")){
            return true;
        }

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        int n = s1.length();
        for (int i = 0; i < n; i++){
            ++c1[s1.charAt(i)-'a'];
            ++c2[s2.charAt(i)-'a'];
        }
        if (Arrays.equals(c1,c2)){
            return true;
        }
        for (int i = n; i < s2.length(); i++){
             --c2[s2.charAt(i-n)-'a'];
             ++c2[s2.charAt(i)-'a'];
             if (Arrays.equals(c1,c2)){
                 return true;
             }
        }
        return false;

    }



    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1,s2));

    }
}
