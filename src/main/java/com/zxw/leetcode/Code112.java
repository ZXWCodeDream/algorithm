package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.TreeNode;

/**
 * ClassName: Code112
 * Description:
 *
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zxw
 * @date 2021/1/16 5:08 下午
 * @since JDK 1.8
 */
public class Code112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        return recursion(root,sum);
    }

    public  Boolean recursion(TreeNode root,int v){

        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null &&  v-root.val == 0){
            return true;
        }
        return recursion(root.left,v-root.val) || recursion(root.right,v-root.val);
    }
}
