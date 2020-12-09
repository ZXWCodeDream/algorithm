package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Code95
 * Description:
 *
 *
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 * @author zxw
 * @date 2020/12/9 9:43 上午
 * @since JDK 1.8
 */
public class Code95 {

    /**
     * 分治
     * 思路：
     * 二叉搜索树的特性，左子树所有节点的值都比根节点小，右子树所有节点的值都比根节点大
     * 所以假设x是根节点，那么x的左子树的组合为[1,x-1],右子树的组合为[x+1,n],如此即拆分成子问题
     * 子问题合并：分别将x左子树组合挂接到x的左子树，将x右子树组合挂接到x的右子树，返回以x为根节点树
     * @param n
     * @return
     */
    public static  List<TreeNode> generateTrees(int n) {

        if (n < 1){
            return new ArrayList<>();
        }
        return constructTree(1,n);
    }

    /**
     * 返回区间[l,r]组成二叉搜索树的组合
     * @param l
     * @param r
     * @return
     */
    public static List<TreeNode> constructTree(int l,int r){

        List<TreeNode> list = new LinkedList<>();
        //此时二叉搜索树为空，返回null节点
        if (l > r){
            list.add(null);
            return list;
        }
        for (int i = l; i <= r; i++){
            //以i为根节点的所有左子树组合
            List<TreeNode> leftTreeList = constructTree(l,i-1);
            //以i为根节点的所有右子树组合
            List<TreeNode> rightTreeList = constructTree(i+1,r);
            //合并子问题，构建所有以i为根节点的树
            for (TreeNode left : leftTreeList){
                for (TreeNode right : rightTreeList ){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<TreeNode> trees = generateTrees(3);
        System.out.println(trees);
    }

//    public TreeNode addNode(TreeNode root,int v){
//        if (root == null){
//            root = new TreeNode(v);
//        }else if (root.val > v && root.left == null){
//            root.left = new TreeNode(v);
//        }else if (root.val > v && root.left != null){
//            root.left = addNode(root.left,v);
//        }else if (root.val < v && root.right == null){
//            root.right = new TreeNode(v);
//        }else if (root.val < v && root.right != null){
//            root.right = addNode(root.right,v);
//        }
//        return root;
//    }
}
