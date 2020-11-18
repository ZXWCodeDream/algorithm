package main.java.com.zxw.leetcode;

import static main.java.com.zxw.common.TimeUtil.t;

/**
 * ClassName: Code28
 * Description:
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * @author zxw
 * @date 2020/6/19 4:44 下午
 * @since JDK 1.8
 */
public class Code28 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(strStr("mississippi",""));
        System.out.println(strStr1("mississippi",""));
        t(start);
    }

    public static int strStr(String haystack, String needle) {
        if (null == needle || needle.length() == 0){
            return 0;
        }
        int i,j;
        for (i = 0; i < haystack.length
                ()-needle.length()+1; i++){
            for (j = 0; j < needle.length(); j++){
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if (j == needle.length()){
                return i;
            }
        }
        return -1;
    }

    public static int strStr1(String haystack,String needle){
        for (int i = 0; i < haystack.length()-needle.length()+1; i++){
            if (haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

}
