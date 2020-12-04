package main.java.com.zxw.guide;

import java.util.Stack;

/**
 * ClassName: Code1
 * Description:
 *
 * 实现pop()、push()、getMin()获取最小值接口的栈
 *
 * @author zxw
 * @date 2020/12/4 9:54 上午
 * @since JDK 1.8
 */
public class Code1 {

    /**
     * 实现方式1：
     * 使用两个默认栈，分别命名为stack和minStack，stack正常存储数据，minStack存储最小值
     * push时，若入栈元素小于等于minStack的顶端元素时，入minStack栈。
     * pop时，若出栈元素等于minStack栈顶元素时，minStack也出栈顶元素pop()
     * getMin时，返回minStack栈顶元素
     */
    class MyStack{
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public void push(Integer e){
            stack.push(e);
            if (minStack.isEmpty()){
                minStack.push(e);
            }else if (minStack.peek() >= e){
                minStack.push(e);
            }
        }

        public Integer pop(){
            Integer e = stack.pop();
            if (e == minStack.peek()){
                minStack.pop();
            }
            return e;
        }

        public Integer getMin(){
            return minStack.peek();
        }
    }


    /**
     * 实现方式2：
     * 使用两个默认栈，分别命名为stack和minStack，stack正常存储数据，minStack存储最小值
     * push时，若入栈元素小于等于minStack的顶端元素时，入minStack栈,否则将minStack的栈顶元素重复入栈
     * pop时，stack和minStack分别pop
     * getMin时，返回minStack栈顶元素
     *
     * 方式2和方式1区别：
     * 方式1:在pop时需要比较出栈元素和minStack的栈顶元素，更消耗时间
     * 方式2：minStack存储的元素更多，更消耗空间
     */
    class MyStack2{
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public void push(Integer e){
            stack.push(e);
            if (minStack.isEmpty()){
                minStack.push(e);
            }else if (minStack.peek() >= e){
                minStack.push(e);
            }else{
                minStack.push(minStack.peek());
            }
        }

        public Integer pop(){
            minStack.pop();
            return stack.pop();
        }

        public Integer getMin(){
            return minStack.peek();
        }
    }
}
