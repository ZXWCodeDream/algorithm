package main.java.com.zxw.offer;

/**
 * ClassName: Offer5
 * Description:
 * 题目：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author zxw
 * @date 2020/9/16 9:47 上午
 * @since JDK 1.8
 */
public class Offer5 {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("I love china ");
        System.out.println(replaceSpace2(sb));
    }

    /**
     * 思路一：
     * 借助辅助字符串存储不是空格的字符，若是空格拼接%20
     * @param str
     * @return
     */
    public static  String replaceSpace(StringBuffer str) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 思路2：不借助辅助字符串如何实现呢？
     * 统计给定字符串的空格的个数，由于要把空格替换成"%20"，所以一旦有一个空格，就在给定字符串末尾扩充2个字符。用P1指向原给定字符串的末尾，
     * 用P2指向扩充后的字符串的末尾，P1、P2两个指针同时从后往前移动，p1指针指向的元素不是空格，则P2所在的位置赋值P1指向的位置，
     * 一旦P1指针指向的元素是空格，则P2依次向前移动3个位置，并依次赋值'0'，'2'，'%'，因为是逆序存储，所以字符也是逆序存储。
     * 直到P1<0或者P1==P2，结束
     * @param str
     * @return
     */
     public static  String replaceSpace2(StringBuffer str) {

        int p1 = str.length()-1;
        // 注意点1： for循环不能再使用i < str.length作为结束条件，因为str无时无刻在扩充容量，所以会导致死循环
         // 注意点2： i <= p1
        for (int i = 0; i <= p1;i++){
            if (str.charAt(i) == ' '){
                str.append("  ");
            }
        }
        int p2 = str.length()-1;
        while (p1 >= 0 && p1 != p2){
            //注意点3：str.charAt(p1--)需要单独使用char c存储,不然在str.setCharAt(p2--,c)赋值会取值不对
            char c = str.charAt(p1--);
            if (c == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else{
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
    }
}
