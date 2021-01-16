package main.java.com.zxw.Inteview;

import main.java.com.zxw.bean.TreeNode;
import main.java.com.zxw.common.TreeUtil;

/**
 * ClassName: Code2
 * Description:
 * From: 蚂蚁
 * 在一个二叉树中，求判定是否存在一条从根节点到叶节点的路径，这条路径上所有节点的值加起来的和等于给定的值。
 * @author zxw
 * @date 2021/1/15 6:16 下午
 * @since JDK 1.8
 */
public class Code2 {

    public static Boolean judgePath(TreeNode root,int target){

        return recursion(root,target);
    }

    public static Boolean recursion(TreeNode root,int v){

        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null &&  v-root.val == 0){
            return true;
        }
        return recursion(root.left,v-root.val) || recursion(root.right,v-root.val);
    }

    public static void main(String[] args) {

        Integer[] arr = {1,2,4,4,5};
        TreeNode root = TreeUtil.createBinaryTree(arr, 0, arr.length);
        System.out.println(judgePath(root,5));
    }
}
