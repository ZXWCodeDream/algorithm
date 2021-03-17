package main.java.com.zxw.leetcode;

/**
 * ClassName: Code21
 * Description:
 *
 *
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * @author zxw
 * @date 2021/3/17 2:50 下午
 * @since JDK 1.8
 */

import main.java.com.zxw.bean.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Code21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode res = head;
        while (l1 != null && l2 != null){

            if (l1.val <= l2.val){
                res.next = l1;
                l1 = l1.next;
            }else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if (l1 == null){
            res.next = l2;
        }
        if (l2 == null){
            res.next = l1;
        }
        return head.next;

    }


    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }

    }
}
