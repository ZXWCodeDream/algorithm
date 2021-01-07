package main.java.com.zxw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Code93
 * Description:
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 *
 * @author zxw
 * @date 2021/1/7 10:17 上午
 * @since JDK 1.8
 */
public class Code93 {

    /**
     * 求排列组合，典型的回溯算法
     * 可选择列表、路径、结束条件
     * 关键点在于可选择列表和结束条件，路径的话就只要满足条件的就append追加字符串就好
     * 可选择列表： 对于字符串s，每次最多能截取1-3个字符，且若截取大于1个字符的，第一个字符不能为0。截取的字符的数值要小于等于255
     * 结束条件： .点号添加了4次，若路径的长度=字符串的长度+4（点号的长度），则该路径满足条件，添加到result,其余不满足条件，return;
     */
    private static List<String> result = new ArrayList<>();

    public static  List<String> restoreIpAddresses(String s) {

        StringBuilder sb = new StringBuilder();
        backTrack(s,sb,0,0);
        return result;

    }

    /**
     *
     * @param s 给定字符串
     * @param sb 路径
     * @param index 截取字符串的起点坐标
     * @param num 添加.点号的数量
     */
    public static void backTrack(String s,StringBuilder sb,int index,int num){
        if (num == 4){
            if (sb.length() == s.length()+4) {
                result.add(sb.toString().substring(0,sb.length()-1));
            }
            return;
        }
        for (int i = 1; i <= 3; i++){
            if (index + i > s.length()) continue;
            String s1 = s.substring(index, index + i);
            if (s1.length() > 1 && s1.charAt(0) == '0')continue;
            Integer s1Int = Integer.valueOf(s1);
            if (s1Int > 255)continue;
            sb.append(s1).append(".");
            backTrack(s,sb,index+i,num+1);
            sb.delete(sb.length()-i-1,sb.length());
        }
    }

    public static void main(String[] args) {

        String s1 = "25525511135";
        String s2 = "0000";
        String s3 = "1111";
        String s4 = "010010";
        String s5 = "101023";
        List<String> strings = restoreIpAddresses(s5);
        strings.forEach(System.out::println);
    }

}
