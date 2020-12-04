package main.java.com.zxw.guide;

import java.util.Stack;

/**
 * ClassName: Code2
 * Description:
 *
 * 由两个栈组成的队列，支持队列的基本操作（add,poll,peek）
 * @author zxw
 * @date 2020/12/4 11:02 下午
 * @since JDK 1.8
 */
public class Code2 {

    /**
     * 思路：
     * 定义两个栈，一个栈addStack拿来添加数据，另一个栈peekStack拿来取数据
     * 添加数据时，直接往addStack添加数据
     * 取数据时，当peekStack为空时，那么就将addStack的所有数据都推到peekStack中，
     * @param <T>
     */
    static class MyQueue<T>{
        private Stack<T> addStack;
        private Stack<T> peekStack;

        public MyQueue(){
            addStack = new Stack<>();
            peekStack = new Stack<>();
        }

        public void add(T e){
            addStack.push(e);
        }
        public T poll() {
            if (peekStack.isEmpty()){
                while (!addStack.isEmpty()){
                    peekStack.push(addStack.pop());
                }
            }
            if(peekStack.isEmpty()){
                throw new RuntimeException("队列为空！");
            }
            return peekStack.pop();
        }

        public T peek() {
            if (peekStack.isEmpty()){
                while (!addStack.isEmpty()){
                    peekStack.push(addStack.pop());
                }
            }
            if(peekStack.isEmpty()){
                throw new RuntimeException("队列为空！");
            }
            return peekStack.peek();
        }
    }

    public static void main(String[] args){

        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}


