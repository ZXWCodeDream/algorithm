package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.TreeNode;
import main.java.com.zxw.common.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Code222
 * Description:
 *
 *
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * @author zxw
 * @date 2020/11/25 10:51 上午
 * @since JDK 1.8
 */
public class Code222 {


    /**
     * 解法1:
     * 广度优先搜索主要就是系统的搜索全部节点，以便找到满足条件的结果
     * bfs:广度优先搜索，使用队列作为辅助工具，一层一层地进行搜索全部节点
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {

        if (root == null){
            return 0;
        }
        // 节点总数
        int nodeSum = 0;
        // 每一层的最大节点数
        int levelNum = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            // 二叉树每层的节点总数
            int len = queue.size();
            nodeSum += len;
            //当该层的节点不是满节点时，就没有必要继续遍历剩下的节点进行搜索了
            if (len != levelNum || len == 0){
                break;
            }
            //遍历该层所有节点，继续往下遍历搜索
            for(;len > 0; len--){
                TreeNode node = queue.poll();
                if (node.left != null){queue.offer(node.left);}
                if (node.right != null){queue.offer(node.right);}
            }
            // 每次往下一层，每一层的总节点数就✖️2（<<位运算，向左移动一位）
            levelNum <<= 1;
        }
        return nodeSum;
    }


    /**
     * 前序遍历求解
     * @param root
     * @return
     */
    public static int countNodes1(TreeNode root){

        int count = 0;
        if (root == null){
            return  count;
        }
        count++;
        count += countNodes1(root.left);
        count += countNodes1(root.right);
        return count;
    }

    /**
     * 根据完全二叉树的特点进行求见（二分）
     * 待完善思考
     * @param
     * @return
     */
//    public static int countNodes2(TreeNode root){
//        if (root == null){
//            return 0;
//        }
//        int level = 0;
//        TreeNode node = root;
//        while (node != null){
//            node = node.left;
//            level++;
//        }
//        int low = 1 << (level-1),high = 1 << level -1;
////        二分取中间值时两个数相加容易引起超过整型最大值
////        int middle = (high+low+1)/2;
//        // +1是为了向上取整
//          int middle = (high-low+1)/2+low;
//
//
//
//    }
//
//    public static boolean isExistNode(TreeNode root,int level,int index){
//
//         int bits = 1 << (level-1);
//         TreeNode node = root;
//         while (node != null && bits > 0){
//             if (bits )
//         }
//
//
//    }




    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        TreeNode root = TreeUtil.createBinaryTree(arr,0,arr.length);
        System.out.println(countNodes(root));
        System.out.println(countNodes1(root));
    }
}
