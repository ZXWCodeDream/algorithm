package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.TreeNode;

/**
 * ClassName: Code226
 * Description:
 *
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * @author zxw
 * @date 2021/1/15 2:30 下午
 * @since JDK 1.8
 */
public class Code226 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    /**
     * 思路：
     * 将二叉树的问题回归到每一个节点上，翻转二叉树的本质其实就是对应每一个根节点，左右子节点互换。
     * 使用先序遍历的模板
     * 1、互换左右节点
     * 2、将左节点作为根节点递归
     * 3、将右节点作为根节点递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {

        if (root == null)return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
