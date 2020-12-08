package main.java.com.zxw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Code241
 * Description:
 *
 * 241. 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * @author zxw
 * @date 2020/12/8 10:07 上午
 * @since JDK 1.8
 */
public class Code241 {

    /**
     * 分治算法：
     *解题思路
     * 对于一个形如 x op y（op 为运算符，x 和 y 为数） 的算式而言，它的结果组合取决于 x 和 y 的结果组合数，而 x 和 y 又可以写成形如 x op y 的算式。
     *
     * 因此，该问题的子问题就是 x op y 中的 x 和 y：以运算符分隔的左右两侧算式解。
     *
     * 然后我们来进行 分治算法三步走：
     *
     * 分解：按运算符分成左右两部分，分别求解
     * 解决：实现一个递归函数，输入算式，返回算式解
     * 合并：根据运算符合并左右两部分的解，得出最终解
     *
     *
     * 此题举例：2*3-4*5
     * diffWaysToCompute()获取所有可能的结果值
     * 1、分割*号，diffWaysToCompute(2)*diffWaysToCompute(3-4*5)获取所有可能结果值
     * 2、分割-号,diffWaysToCompute(2*3)-diffWaysToCompute(4*5)获取所有可能结果值
     * 3、分割*号，diffWaysToCompute(2*3-4)*diffWaysToCompute(5)获取所有可能结果值
     * @param input
     * @return
     */
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                //分解，拆子问题[0,i],[i+1,n]
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                //合并
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }
}
