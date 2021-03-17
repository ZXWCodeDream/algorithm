package main.java.com.zxw.bean;

/**
 * ClassName: ListNode
 * Description:
 *
 * @author zxw
 * @date 2021/3/17 2:52 下午
 * @since JDK 1.8
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }
}


