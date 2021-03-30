package main.java.com.zxw.common;

import main.java.com.zxw.bean.ListNode;

/**
 * ClassName: ListNodeUtil
 * Description:
 *
 * @author zxw
 * @date 2021/3/30 9:27 上午
 * @since JDK 1.8
 */
public class ListNodeUtil {

    public static ListNode createList(int[] arr){

        if (arr == null || arr.length == 0){
            return null;
        }
        ListNode head = new ListNode();
        head.val = arr[0];
        ListNode p = head;
        for (int i = 1; i < arr.length; i++){
            ListNode node = new ListNode();
            node.val = arr[i];
            p.next = node;
            p = p.next;
        }
        return head;
    }

    public static void printList(ListNode head){

        StringBuilder sb = new StringBuilder("[");
        while (head != null){
            sb.append(head.val).append(",");
            head = head.next;
        }
        if (sb.length() > 1){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        ListNode list = createList(arr);
        printList(list);
    }
}
