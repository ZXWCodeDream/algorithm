package main.java.com.zxw.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Code524
 * Description:
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * 输出:
 * "apple"
 * 示例 2:
 *
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * 输出:
 * "a"
 * 说明:
 *
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zxw
 * @date 2020/11/18 4:26 下午
 * @since JDK 1.8
 */
public class Code524 {

    /**
     * 思路：
     * 1. 首先考虑如何判断一个字符串可以通过删除给定字符串某些字符匹配到(假定给定字符串为s，匹配字符串为s1)
     *  1.1 若s字符串长度<s1字符串长度，则自然无法匹配到
     *  1.2 双指针： 定义双指针l、r指向s字符串两端，定义双指针l1、r1指向s1字符串两端
     *              若l指向的值 等于 l1指向的值 则 l右移，l1右移
     *              若l指向的值 不等于 l1指向的值 则 l右移
     *              若r指向的值 等于 r1指向的值 则 r左移，r1左移
     *              若r指向的值 不等于 r1指向的值 则 r左移
     *              结束条件：l<=r 并且 l1<=r1 (结束条件这里需要考虑等于，当左右指针指向同一个值时也需要考虑能不能在s中匹配到)
     * 2. 遍历数组，获取满足条件的字符串。返回长度最长，字段序列最小的字符串
     * @param s
     * @param d
     * @return
     */
    public static  String findLongestWord(String s, List<String> d) {

        String  result = "";
        String s1 = "";
        int len = s.length();
        int len1 = 0;
        for (int i = 0; i < d.size(); i++){
            s1 = d.get(i);
            len1 = s1.length();
            if (len < len1){
                continue;
            }
            int l = 0,r = len-1,l1 = 0,r1 = len1-1;
            while (l <= r && l1 <= r1){
                if (s.charAt(l) == s1.charAt(l1)){
                    l++;l1++;
                }else{
                    l++;
                }
                if (s.charAt(r) == s1.charAt(r1) ){
                    r--;r1--;
                }else{
                    r--;
                }
            }
            if (l1 > r1){
                if (result.length() < s1.length()){
                    result = s1;
                }else if (result.length() == s1.length()){
                    result = result.compareTo(s1) <= 0 ? result : s1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        String s = "aewfafwafjlwajflwajflwafj";
        List<String> list = Arrays.asList("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf");
        System.out.println(findLongestWord(s,list));
    }


}
