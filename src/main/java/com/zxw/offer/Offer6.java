package main.java.com.zxw.offer;


import java.util.ArrayList;
import java.util.Stack;

/**
 * ClassName: Offer6
 * Description:
 * 题目描述：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 *
 * @author zxw
 * @date 2020/9/17 9:38 上午
 * @since JDK 1.8
 */
public class Offer6 {


    static class ListNode{

       int val;
       ListNode next = null;

       ListNode(int val) {
           this.val = val;
       }

    }
    public static void main(String[] args) {

//        ListNode head = null;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printListFromTailToHead3(head).forEach(a -> System.out.println(a));
    }

    /**
     * 个人思路：逆置链表打印
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> result = new ArrayList<>();
        if(listNode == null){
            return result;
        }
        ListNode pre = listNode;
        ListNode now = listNode.next;
        pre.next = null;
        ListNode next = null;
        while (now != null){
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        while (pre != null){
            result.add(pre.val);
            pre  = pre.next;
        }
        return result;
    }

    /**
     * 思路： 递归实现
     * 假如是链表 1 -> 2 -> 3
     * 我们最终打印的结果是3，2，1
     * 那我们可以先逆序打印 2 -> 3,再打印1，本质即使把2 -> 3当做一个新的链表
     * 接着我们就可以先逆序打印3，再打印2.就是在函数中调用函数，递归实现
     *
     * @param node
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode node){

        ArrayList<Integer> result = new ArrayList<>();
        if (node != null){
            // 先逆序打印后面的链表
            result.addAll(printListFromTailToHead1(node.next));
            // 再打印当前节点的值
            result.add(node.val);
        }
        return result;
    }

    /**
     * 思路： 头插法
     * 概念：
     *  【1】、什么是头插法？
     *         为了更好阅读，将概念符号化： 辅助链表：A 辅助链表头结点：AHead 要插入链表中的一个节点：node、node1、node2...noden(顺序)
     *         头插法就是新建一个辅助链表，只有头结点，然后将目前链表的节点依次插入到辅助链表的下一个节点、
     *         实现方式为node指向AHead的下一个节点，AHead指向node。这样原来是AHead->null。现在是AHead->node->null
     *         重复操作后将变成 AHead->noden->...->node1->node->null
     *         本质就是逆序目标链表
     *  【2】、什么是尾插法？
     *          为了更好阅读，将概念符号化： 辅助尾节点：tailHead 辅助链表头结点：AHead 要插入链表中的一个节点：node、node1、node2...noden(顺序)
     *          尾插法顾名思义就是将目标节点依次往辅助链表尾部插入
     *          实现方式为tailHead=AHead,tailHead指向node,tailHead=node,node=null。即原来是AHead->null,现在是AHead->node>null
     *          重复操作后AHead->node>node1->...->noden->null
     *          本质顺序拼接链表
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode){

        ArrayList<Integer> result = new ArrayList<>();
        ListNode node = new ListNode(-1);
        ListNode next = null;
        while (listNode != null){
            next = listNode.next;
            listNode.next = node.next;
            node.next = listNode;
            listNode = next;
        }
        ListNode head = node.next;
        while (head != null){
            result.add(head.val);
            head = head.next;
        }
        return result;

    }

    /**
     * 利用数据结果栈作为辅助
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode){

        ArrayList<Integer> result = new ArrayList<>();
        Stack stack = new Stack<Integer>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;

        }
        while (!stack.isEmpty()){
            result.add((int)stack.pop());
        }
        return result;
    }


}
