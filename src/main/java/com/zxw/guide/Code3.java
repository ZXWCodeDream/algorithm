package main.java.com.zxw.guide;

import java.util.Stack;

/**
 * ClassName: Code3
 * Description:
 *
 *
 *  仅使用递归函数实现一个栈数据的逆转
 * @author zxw
 * @date 2020/12/13 10:27 下午
 * @since JDK 1.8
 */
public class Code3 {


    /**
     * 获得栈底元素，并且栈底元素出栈
     * 例子：若栈从顶到底元素依次为3、2、1，经过此方法递归后返回1，栈元素变为3、2
     * @param stack
     * @return
     */
    public static int getBottomElement(Stack<Integer>stack){
        //弹出栈顶元素
        int ele = stack.pop();
        if (stack.isEmpty()){
            return ele; // 如果栈是空的，则此时ele是栈底元素
        }else{
           int lastEle = getBottomElement(stack);
           stack.push(ele); // 压入元素lastEle的上一个元素ele
           return lastEle;  //最终就能返回栈底元素
        }
    }

    public static void  reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        //弹出并获得栈底元素
        int bottom = getBottomElement(stack);
        //持续弹出并获得栈底元素
        reverse(stack);
        //通过递归使得最先获取的栈底元素最后入栈
        stack.push(bottom);
    }

}
