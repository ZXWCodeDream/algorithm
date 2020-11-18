package main.java.com.zxw.leetcode;


/**
 * ClassName: Code680
 * Description:
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zxw
 * @date 2020/11/18 9:41 上午
 * @since JDK 1.8
 */
public class Code680 {

    /**
     * 思路：
     * 双指针： 左指针指向最左位置，右指针指向最右位置
     * 关键点：如果左指针指向的值和右指针指向的值不相等时，左右指针该如何移动？
     * 该题无法判断如何移动，则移动一次左指针判断是否是回文字符串，若是返回true，若不是，则移动右指针后判断是否是回文字符串。若是则返回true，若不是，则返回false
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        if (s.length() == 0){
            return true;
        }
        int i = 0,j = s.length()-1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                if (s.charAt(i+1) == s.charAt(j)){
                    int m = i+1,n = j;
                    while(m < n){
                        if (s.charAt(m) != s.charAt(n)){
                            break;
                        }
                        m++;n--;
                    }
                    if (m >= n){
                        return true;
                    }
                }
                if (s.charAt(i) == s.charAt(j-1)){
                    int m = i,n = j-1;
                    while(m < n){
                        if (s.charAt(m) != s.charAt(n)){
                            return false;
                        }
                        m++;n--;
                    }
                    return true;
                }
                return false;
            }
            i++;j--;
        }
        return true;
    }

    /**
     * 使用逆置函数API接口实现
     * @param s
     * @return
     */
    public static boolean validPalindrome2(String s) {
        if (s.length() == 0){
            return true;
        }
        int i = 0,j = s.length()-1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                    int len = s.length();
                    String s1 = "".concat(s.substring(0,i)).concat(s.substring(i+1,len));
                    StringBuilder sb1 = new StringBuilder(s1).reverse();
                    if (s1.equals(sb1.toString())){
                        return true;
                    }
                    String s2 = "".concat(s.substring(0,j)).concat(s.substring(j+1,len));
                    StringBuilder sb2 = new StringBuilder(s2).reverse();
                    if (s2.equals(sb2.toString())){
                        return true;
                    }
                    return false;
            }
            i++;j--;
        }
        return true;
    }


    /**
     * 我愿称之为最强解
     * @param s
     * @return
     */
    public static boolean validPalindrome3(String s) {
        int i = 0,j = s.length()-1;
        for (;i<j && s.charAt(i) == s.charAt(j);i++,j--);
        return isPalindrome(i+1,j,s) || isPalindrome(i,j-1,s);
    }

    public static boolean isPalindrome(int i,int j,String s){
        for(;i<j && s.charAt(i) == s.charAt(j);i++,j--);
        return i>=j;
    }

        public static void main(String[] args) {
        String s = "aca";
        System.out.println(validPalindrome3(s));
    }
}
