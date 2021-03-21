package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.ListNode;

/**
 * ClassName: Code160
 * Description:
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author zxw
 * @date 2021/3/21 2:07 下午
 * @since JDK 1.8
 */
public class Code160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)return null;
        ListNode pa = headA;
        ListNode pb = headB;
        /**
         * 若链表A和链表B相交，则指针pa和指针pb走相同距离后必相交，pa=pb
         * 若链表A和链表B不相交，则指针pa和pb都走a+b距离后，pa=null,pb=null;
         */
        while (pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;

    }

    /**
     * 链表A，长度a,
     * 链表B，长度b,
     * 链表A和链表B相交长度为c
     *
     * 指针A走完链表A，再指向链表B走到相交点:路径为a+b-c
     * 指针B走完链表B，再指向链表A走到相交点:路径为b+a-c
     * a+b-c=b+a-c，指针A和指针B走过的路径相同，并且同时走到相交点
     * 如果两条链表相交，c>0
     * 如果两条链表不相交，c=0
     *
     */
}
