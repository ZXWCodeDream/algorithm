package main.java.com.zxw.offer;

import java.util.Stack;

/**
 * ClassName: Offer9
 * Description:
 *题目描述：
 * 使用两个栈实现队列的push和pop操作
 *
 * 思路:
 * 方法1：
 * stack1作为入栈操作，stack2作为出栈操作 --推入1、2，pop,推入3、4
 * push操作即把stack2的数据导入到stack1,推入stack1 -- 1，2 -> 2,3,4
 * pop操作即把stack1的数据导入到stack2,推出pop值   -- 2，1 -> 推出1
 *
 *
 *方法2：
 * stack1作为入栈操作，stack2作为出栈操作。关键一点在于后入栈的都是后出
 * push操作直接推入stack1
 * pop操作 当stack2操作为空时(关键)，把stack1的数据都推入到stack2.推出pop值（只有当stack2全部数据推出时再把stack1的值推入到stack2）
 * @author zxw
 * @date 2020/10/19 9:28 上午
 * @since JDK 1.8
 */
public class Offer9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push1(int node) {
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop2() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Offer9 test = new Offer9();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
