package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.TreeNode;
import main.java.com.zxw.common.TreeUtil;

/**
 * ClassName: Code437
 * Description:
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * 通过次数72,853提交次数128,644
 *
 * @author zxw
 * @date 2021/4/7 9:58 上午
 * @since JDK 1.8
 */
public class Code437 {

    public static int pathSum(TreeNode root, int sum) {

        if (root == null){
            return 0;
        }
        //以root节点为起点满足条件个数+以root.left节点为起点满足条件个数+以root.right节点为起点满足条件个数
        return circle(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    public static int circle(TreeNode node,int sum){

        if  (node == null)return 0;
        //判断当前节点是否是满足条件的结束节点，若是count=1
        int count = sum-node.val == 0 ? 1 : 0;
        //持续深入
        return count+circle(node.left,sum-node.val)+circle(node.right,sum-node.val);

    }


    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1,null,2,null,null,null,3,null,null,null,null,null,null,null,4};
        TreeNode node = TreeUtil.createBinaryTree(arr, 0, arr.length);
        int count = pathSum(node, 3);
        System.out.println(count);

    }
}
