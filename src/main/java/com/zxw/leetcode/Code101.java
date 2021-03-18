package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.TreeNode;
import main.java.com.zxw.common.TreeUtil;

/**
 * ClassName: Code101
 * Description:
 *
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @author zxw
 * @date 2021/3/18 11:20 上午
 * @since JDK 1.8
 */
public class Code101 {


    /**
     * 镜像对称，找其规律：
     * 1、以树的根节点为轴点，对其左右子树进行比较。
     * 2、左子树的右节点跟右子树的左节点进行比较，左子树的左节点跟右子树的右子树进行比较
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {

        return circleTree(root.left,root.right);

    }

    public static boolean circleTree(TreeNode left ,TreeNode right){

        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }
        return circleTree(left.right,right.left) && circleTree(left.left,right.right);
    }

    public static void main(String[] args) {

        Integer[] arr = {1};
        TreeNode root = TreeUtil.createBinaryTree(arr, 0, arr.length);
        System.out.println(isSymmetric(root));
    }
}
