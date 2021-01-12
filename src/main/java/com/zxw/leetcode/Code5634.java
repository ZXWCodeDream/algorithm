package main.java.com.zxw.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: Code5634
 * Description:
 *
 * 5634. 删除子字符串的最大得分 显示英文描述
 * 通过的用户数246
 * 尝试过的用户数474
 * 用户总通过次数246
 * 用户总提交次数738
 * 题目难度Medium
 * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
 *
 * 删除子字符串 "ab" 并得到 x 分。
 * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
 * 删除子字符串"ba" 并得到 y 分。
 * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
 * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "cdbcbbaaabab", x = 4, y = 5
 * 输出：19
 * 解释：
 * - 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
 * - 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
 * - 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
 * - 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
 * 总得分为 5 + 4 + 5 + 5 = 19 。
 * 示例 2：
 *
 * 输入：s = "aabbaaxybbaabb", x = 5, y = 4
 * 输出：20
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * 1 <= x, y <= 104
 * s 只包含小写英文字母。
 *
 * @author zxw
 * @date 2021/1/9 10:48 下午
 * @since JDK 1.8
 */
public class Code5634 {


    /**
     *
     * 提示： 暴力解法都会超时
     *
     * 由于删除ab或者ba都不会改变字符串的原有顺序，也不会新增元素，故贪心算法思路就是每次优先删除分数大的
     * 问题处理的优化
     *
     * 对于如下的两个字符串互为逆序的示例，
     * 示例 11 将先删除 abab ，再删除 baba 得到 1515 分，
     * 而示例 22 将先删除 baba ，再删除 abab 得到 1515 分，
     * 我们发现，字符串逆序后，将对应的得分也进行互换，最终的最大得分是相同的，
     * 所以，我们可以将 x > yx>y 的情况经过预处理转化为 x <= yx<=y 的情况。
     * 示例1：s = "abcdba", x = 10, y = 5
     * 示例2：s = "abdcba", x = 5, y = 10
     *
     * 具体实现的细节
     *
     * 在用栈结构优先处理完所有 baba 子字符串后，要第二次处理栈中剩余的 abab 子字符串。
     * 由于栈具有“后入先出”的特点，该栈中 abab 子字符串弹出元素的顺序实际上为 baba，
     * 所以在代码实现中，利用了第二个栈 tt 作为载体，基本复制第一次处理的代码即可。
     *
     * @param s
     * @param x
     * @param y
     * @return
     */
    public static  int maximumGain(String s, int x, int y) {

        if (x < y){
            x = x^y;
            y = x^y;
            x = x^y;
            s = new StringBuilder(s).reverse().toString();
        }
        Stack<Character> stack = new Stack<>();
        int score = 0;
        //先处理ab
        for (int i = 0; i <  s.length(); i++){
            Character c = s.charAt(i);
            if (c != 'b'){
                stack.push(c);
            }else{
                if (!stack.isEmpty() && stack.peek() == 'a'){
                    stack.pop();
                    score += x;
                }else{
                    stack.push(c);
                }
            }
        }
        //再处理ba。在stack自底向上顺序 b a ,先弹出a,再弹出b
        Stack<Character> stack2 = new Stack<>();
        while (!stack.isEmpty()){
            Character c = stack.pop();
            if (c != 'b'){
                stack2.push(c);
            }else{
                if (!stack2.isEmpty() && stack2.peek() == 'a'){
                    stack2.pop();
                    score += y;
                }else{
                    stack2.push(c);
                }
            }
        }
        return score;
    }


    /**
     * 对应贪心策略一致
     * 不过此时借助双指针计数器实现子字符串删除，上面方法借助栈实现
     * 第一个指针计数器记录a字符
     * 第二个指针计数器记录b字符
     * 首先要删除ab
     * 如果遍历到a字符，则第一个指针计数器+1
     * 如果遍历到b字符，判断第一个指针计数器是否>0,若大于0，代表b前面存在n个a字符,所以使得第一个指针计数器-1，代表子串ab逻辑删除。
     * 若第一个指针计数器等于0,则代表b前面不存在a字符，此时第二个指针计数器+1
     * 最后删除ba，删除的个数为Min（第一个指针计数器，第二个指针计数器）
     * @param s
     * @param x
     * @param y
     * @return
     */
    public static  int maximumGain1(String s, int x, int y) {

        if (x < y){
            x = x^y;
            y = x^y;
            x = x^y;
            s = new StringBuilder(s).reverse().toString();
        }
        int score = 0;
        int a = 0,b = 0;
        //先删除ab
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (c == 'a'){
                a++;
            }
            if (c == 'b'){
                //代表前面有a字符存在
                if (a > 0){
                    a--;
                    score += x;
                }else{
                    b++;
                }
            }
        }
        score += y * Math.min(a,b);

        return score;
    }



    public static void main(String[] args){

        System.out.println(maximumGain("cdbcbbaaabab",4,5));
     }
}
