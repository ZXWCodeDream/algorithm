package main.java.com.zxw.leetcode;

import java.util.Stack;

/**
 * ClassName: Code20
 * Description:
 *
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author zxw
 * @date 2021/3/17 2:34 下午
 * @since JDK 1.8
 */
public class Code20 {

    public boolean isValid(String s) {

        if (s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++){
            char  c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top == '(')
                        || (c == ']' && top == '[')
                        || (c == '}' && top == '{') ){
                    continue;
                }else{
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
