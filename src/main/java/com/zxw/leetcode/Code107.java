package main.java.com.zxw.leetcode;

import javafx.util.Pair;
import main.java.com.zxw.bean.TreeNode;
import main.java.com.zxw.common.TreeUtil;

import java.util.*;

/**
 * ClassName: Code107
 * Description:
 *
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @author zxw
 * @date 2020/12/17 8:37 下午
 * @since JDK 1.8
 */
public class Code107 {

    /**
     * BFS:广度优先搜索
     * 每遍历一层就将该层的数据存入List中，最后逆置
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (!list.isEmpty()){
                result.add(list);
            }
        }
        Collections.reverse(result);
        return result;
    }


    /**
     * DFS 深度优先搜搜 添加深度作标识
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        dfs(root,0,result);
        return result;
    }

    public static void dfs(TreeNode node,int depth,List<List<Integer>> res){
        if (node == null){
            return;
        }
        // depth从0开始，size从1开始，若相等则代表此深度还未新建列表
        if (depth == res.size()){
            res.add(0,new ArrayList<>()); // 在最前面添加元素
        }
        //在当前深度的集合列表里面添加元素
        res.get(res.size()-depth-1).add(node.val);
        //深度+1继续添加元素
        dfs(node.left,depth+1,res);
        dfs(node.right,depth+1,res);
    }



    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeUtil.createBinaryTree(arr, 0, arr.length);
        List<List<Integer>> lists = levelOrderBottom2(root);
        System.out.println("end");
    }


}
