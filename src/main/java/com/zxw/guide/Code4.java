package main.java.com.zxw.guide;

import java.util.Stack;

/**
 * ClassName: Code4
 * Description:
 *
 * 用一个栈实现另一个栈的排序
 *
 * 一个栈中元素的类型为整型，现在想从该栈从顶到底按从大大小的顺序排序，只允许申请一个栈。
 * @author zxw
 * @date 2020/12/18 10:54 下午
 * @since JDK 1.8
 */
public class Code4 {

    /**
     * 实现思路
     * 依次从stack弹出栈顶元素pop()为ele
     * 如果ele元素小于等于help栈顶元素，则压入help栈
     * 如果ele元素大于help栈顶元素，则依次将help栈的元素弹入stack栈，直到ele元素小于等于help栈顶元素，最后将ele元素压入help栈
     * 当stack栈为空时，此时help栈从顶到底为从小到大
     * 将help栈压入stack，则为目标顺序
     * @param stack
     */
    public void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            int ele = stack.pop();
            while (!help.isEmpty() && ele > help.peek()){
                stack.push(help.pop());
            }
            help.push(ele);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
