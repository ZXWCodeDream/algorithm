package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.ListNode;
import main.java.com.zxw.common.ListNodeUtil;

/**
 * ClassName: Code203
 * Description:
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 *
 * 提示：
 *
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 *
 * @author zxw
 * @date 2021/3/29 11:55 上午
 * @since JDK 1.8
 */
public class Code203 {

    /**
     * 关键使用pre保存上一个节点
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {

        ListNode node = head;
        boolean  headFlag = true;
        ListNode pre = null;
        while (node != null){
            if (node.val == val && headFlag){
                head = head.next;
            }else if (node.val == val){
                pre.next = node.next;
                node = pre;
            }else{
                headFlag = false;
            }
            pre = node;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode list = ListNodeUtil.createList(new int[]{1,2,6,3,4,5,6});
        ListNode node = removeElements(list, 6);
        ListNodeUtil.printList(node);
    }
}
