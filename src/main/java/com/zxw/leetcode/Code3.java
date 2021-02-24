package main.java.com.zxw.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: Code3
 * Description:
 *
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 *
 * @author zxw
 * @date 2021/2/24 1:40 下午
 * @since JDK 1.8
 */
public class Code3 {

    /**
     * 解法：滑动窗口
     * 滑动窗口在移动过程中窗口长度只会保持不变或者变大。
     * 应用场景： 最长的连续子串问题
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0){
            return 0;
        }
        //滑动窗口左指针，滑动窗口右指针
        int left = 0, right = 0;
        //记录字符对应的个数
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        char[] chars = s.toCharArray();
        while (right < len){
            //如果map中已经包含right指针指向的字符，则个数+1,若不存在，则初始值1
            if (map.containsKey(chars[right])){
                map.put(chars[right],map.get(chars[right])+1);
            }else{
                map.put(chars[right],1);
            }
            //若窗口的长度大于map的长度（表明map中已经存在重复的字符）时，此时窗口不满足连续不重复子串的条件。则让left左指针右移（窗口整体右移）
            if ((right-left+1) > map.size()){
                //若left左指针指向的字符在滑动窗口中存在多个，则个数-1，若只存在一个，则删除key
                if (map.get(chars[left]) > 1){
                    map.put(chars[left],map.get(chars[left])-1);
                }else{
                    map.remove(chars[left]);
                }
                //left左指针右移
                left++;
            }
            //右指针始终保持右移
            right++;
        }
        //返回窗口的长度即为最长不重复子串(没有+1是因为退出上述循环时，right会多+1)
        return right-left;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";
        String s1 = "bbbbb";
        String s2 = "pwwkew";
        String s3 = " ";
        String s4 = "";
        int result = lengthOfLongestSubstring(s1);
        int result1 = lengthOfLongestSubstring(s2);
        int result2 = lengthOfLongestSubstring(s3);
        int result3 = lengthOfLongestSubstring(s4);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
