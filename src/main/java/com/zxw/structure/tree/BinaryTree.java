package main.java.com.zxw.structure.tree;

import main.java.com.zxw.bean.TreeNode;
import main.java.com.zxw.common.TreeUtil;

import java.util.*;

/**
 * ClassName: BinaryTree
 * Description:
 * 二叉树遍历
 * 遍历方式有前序遍历、中序遍历、后序遍历
 * 前序遍历顺序：根、左、右
 * 中序遍历顺序：左、根、右
 * 后序遍历顺序：左、右、根
 *
 * @author zxw
 * @date 2020/9/18 10:11 上午
 * @since JDK 1.8
 */
public class BinaryTree {



    /**
     * 前序遍历：递归实现
     * @param root
     * @return
     */
    public static List<Integer> preOrder(TreeNode root){

        List<Integer> result = new ArrayList<>();
        if (root != null){
            result.add(root.val);
            result.addAll(preOrder(root.left));
            result.addAll(preOrder(root.right));
        }
        return result;
    }

    /**
     * 前序遍历：迭代实现
     * 利用栈先进后出的存储能力实现
     * @param root
     * @return
     */
    public static List<Integer> preOrderIteration(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
         return result;
    }

    /**
     * 中序遍历：递归实现
     * @param root
     * @return
     */
    public static  List<Integer> inOrder(TreeNode root){

        List<Integer> result = new ArrayList<>();
        if (root != null){
            result.addAll(inOrder(root.left));
            result.add(root.val);
            result.addAll(inOrder(root.right));
        }
        return result;

    }

    /**
     * 中序遍历：迭代实现
     * 前中后：必须将左节点优先放入队列中
     * @param root
     * @return
     */
    public static List<Integer> inOrderIteration(TreeNode root){

        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            // 待全部左节点压入栈中后，开始弹出
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;

    }


    /**
     * 后序遍历：递归实现
     * @param root
     * @return
     */
    public static List<Integer> postOrder(TreeNode root){

        List<Integer> result = new ArrayList<>();
        if (root != null){
            result.addAll(postOrder(root.left));
            result.addAll(postOrder(root.right));
            result.add(root.val);
        }
        return result;
    }

    public static List<Integer> postOrderIteration(TreeNode root){

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.getFirst().right;
            if (root != null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();

        }
        return result;
    }


    public static void main(String[] args) {
        Integer[] arr = {1,null,2,null,null,3};
        TreeNode root = TreeUtil.createBinaryTree(arr, 0, arr.length);
        List<Integer> list = postOrderIteration(root);
        list.forEach(item-> System.out.println(item));
    }
}
