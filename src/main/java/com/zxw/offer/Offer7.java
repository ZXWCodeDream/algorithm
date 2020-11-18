package main.java.com.zxw.offer;

import main.java.com.zxw.bean.TreeNode;
import main.java.com.zxw.structure.tree.BinaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Offer7
 * Description:
 *题目描述：
 *          输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *          假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *          例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *
 *思路：
 * 前序遍历：根左右
 * 中序遍历：左根右
 * 那么就可以根据前序遍历的第一个节点值划分中序遍历为左子树和右子树
 * 继续拆分
 * @author zxw
 * @date 2020/10/15 2:12 下午
 * @since JDK 1.8
 */
public class Offer7 {


    public static TreeNode reConstructBinaryTree(int[] pre,int[] in){

        if (pre == null || in == null || pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = pre[0];
        for (int i = 0; i < in.length;i++){
            if (in[i] == pre[0]){
                root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }




    /**
     * 以下方法在牛客网编译不通过。应该是不能新使用一个方法
     */
    //辅助Map,为了方便获取具体value对应的index
    private static Map<Integer,Integer> inOrderMap = new HashMap<>();

    public  static TreeNode reConstructBinaryTree2(int[] pre,int[] in){

        for (int i = 0; i < in.length;i++){
            inOrderMap.put(in[i],i);
        }
        TreeNode root = reBuildTree(pre,0,pre.length-1,0);
        return root;
    }

    /**
     *
     * @param pre 前序遍历的数组
     * @param preL 前序遍历的数组最左下标
     * @param preR 前序遍历的数组最右下标
     * @param inL 中序遍历的数组最左下标
     * @return
     */
    public static TreeNode reBuildTree(int[] pre,int preL,int preR,int inL){

        if (preL > preR){
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inMiddleIndex = inOrderMap.get(root.val);
        int leftTreeNodeSize = inMiddleIndex-inL;
        root.left = reBuildTree(pre,preL+1,preL+leftTreeNodeSize,inL);
        root.right = reBuildTree(pre,preL+leftTreeNodeSize+1,preR,inL+leftTreeNodeSize+1);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre,in);
        List<Integer> list = BinaryTree.inOrder(root);
        list.forEach(item -> System.out.println(item));
    }

}
