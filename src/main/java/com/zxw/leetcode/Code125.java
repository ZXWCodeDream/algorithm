package main.java.com.zxw.leetcode;

/**
 * ClassName: Code125
 * Description:
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zxw
 * @date 2020/11/16 10:42 下午
 * @since JDK 1.8
 */
public class Code125 {

    /**
     * 解题思路：
     * 1、对非字符和非数字的字符替换为空
     * 2、使用双指针进行左右向中间遍历。若存在左指针指向的元素不等于右指针指向的元素，则返回false
     * @param s
     * @return
     */
    public static  boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]","");
        System.out.println(s);
        if (s.length() == 0){
            return  true;
        }
        int i = 0,j = s.length()-1;
        while (i < j){
            if (!String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j)))){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    /**
     * 使用StringBuffer或者StringBuild类型的reverse()api实现字符串逆转
     * 使用String.equalsIgnoreCase()比较字符串大小，忽略大小写。
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s ){
        s = s.replaceAll("[^0-9A-Za-z]","");
        StringBuffer s1 = new StringBuffer(s).reverse();
        if (s.equalsIgnoreCase(s1.toString())){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        System.out.println(isPalindrome2(s));
    }
}
