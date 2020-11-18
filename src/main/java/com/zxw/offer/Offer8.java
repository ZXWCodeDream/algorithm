package main.java.com.zxw.offer;

import main.java.com.zxw.bean.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Offer8
 * Description:
 * 题目描述：
 *      给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *      注意 树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 解题思路：
 * 暴力解法：
 *  根据该节点获取该树的根节点，进行中序遍历。查询该节点的下一个节点
 *
 * 最优解解题思路:
 * 碰到这种问题可以手画二叉树，寻找规律
 *
 *                      6
 *                    /   \
 *                 2       7
 *               /  \
 *             1     4
 *                  /  \
 *                 3   5
 *
 *  图中为中序遍历（左根右）顺序，可以总结下规律
 *  1->2: 当前节点的父节点
 *  2->3: 当前节点的右子树的最左节点
 *  3->4: 当前节点的父节点
 *  4->5: 当前节点的右子树的最左节点
 *  5->6: 当前节点的父节点的父节点的父节点（当当前节点是父节点的左子树是，下一个节点就是父节点）
 *  6->7: 当前节点的右子树的最左节点
 *
 * 总结：
 * 规律1：如果当前节点的右节点不为空，则下一个节点为右子树的最左节点
 * 规律2：如果当前节点的右节点为空，则向上寻找第一个节点为其父节点的左节点，下一个节点则为该节点的父节点
 * 举例：
 * 规律2样例：寻找节点1的下一个节点------》节点1是其父节点2的左节点，那么下一个节点就是2
 * 规律2样例：寻找节点5的下一个节点------》节点5的父节点是4，但4是其父节点2的右节点，所以继续往上找，2是其父节点6的左节点，则下一个节点就是6）
 * @author zxw
 * @date 2020/10/16 9:28 上午
 * @since JDK 1.8
 */
public class Offer8 {

    /**
     * 最优解
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode){

        if (pNode.right != null){
            TreeLinkNode rightTreeNode = pNode.right;
            while(rightTreeNode.left != null){
                rightTreeNode = rightTreeNode.left;
            }
            return rightTreeNode;
        }else{

            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left== pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }


    /**
     * 暴力解法
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext2(TreeLinkNode pNode)
    {
        TreeLinkNode root = pNode;
        while (root.next != null){
            root = root.next;
        }
        ArrayList<TreeLinkNode> result = inOrder(root);
        for (int i = 0; i < result.size();i++){
            if (result.get(i).val == pNode.val && i+1 < result.size()){
                return result.get(i+1);
            }
        }
        return null;
    }

    public ArrayList<TreeLinkNode> inOrder(TreeLinkNode root){
        ArrayList<TreeLinkNode> result = new ArrayList<>();
        if (root != null){
            result.addAll(inOrder(root.left));
            result.add(root);
            result.addAll(inOrder(root.right));
        }
        return result;
    }
}
