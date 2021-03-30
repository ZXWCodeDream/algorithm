package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.ListNode;
import main.java.com.zxw.common.ListNodeUtil;

/**
 * ClassName: Code206
 * Description:
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author zxw
 * @date 2021/3/30 8:39 下午
 * @since JDK 1.8
 */
public class Code206 {

    public static ListNode reverseList(ListNode head) {

        if (head == null)return null;
        ListNode next = null;
        ListNode pre = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        ListNode list = ListNodeUtil.createList(new int[]{});
        ListNode listNode = reverseList(list);
        ListNodeUtil.printList(listNode);
    }
}
