package main.java.com.zxw.common;

import main.java.com.zxw.bean.TreeNode;

/**
 * ClassName: TreeUtil
 * Description:
 *
 * @author zxw
 * @date 2020/9/18 10:55 上午
 * @since JDK 1.8
 */
public class TreeUtil {


    /**
     * 根据数组生成二叉树
     * 规则： 若当前节点为下标n的元素，则它的左节点为下标2*n+1元素，右节点为2*n+2元素。上下节点相差2倍
     * @param arr 给定数组
     * @param index 数组下标
     * @param len 数组长度
     * @return
     */
    public static TreeNode createBinaryTree(Integer[] arr,int index,int len){

        if (arr == null || arr.length == 0 ){
            return null;
        }
        TreeNode node = null;
        if (index < len && arr[index] != null){
            node = new TreeNode(arr[index]);
            node.left = createBinaryTree(arr,index*2+1,len);
            node.right = createBinaryTree(arr,index*2+2,len);
        }
        return node;

    }

    public static void main(String[] args) {
        Integer[] arr = {1,null,2,null,null,3};
        TreeNode root = createBinaryTree(arr, 0, arr.length);
        System.out.println("tests");
    }
}
