package main.java.com.zxw.leetcode;

import main.java.com.zxw.bean.TreeNode;

/**
 * ClassName: Code108
 * Description:
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 *
 *
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 *
 * @author zxw
 * @date 2021/3/20 11:16 上午
 * @since JDK 1.8
 */
public class Code108 {


    /**
     * 二叉搜索树的特点：
     * 左子树的左右节点都小于根节点，右子树的所有节点都大于根节点
     * 由于数组是有序数组，并且是递增的，那么二叉搜索树的中序遍历刚好就是递增数组
     * 由于要保持高度平衡二叉搜索树，那么每一个节点都二分作为根节点，递归实现。
     * @param nums
     * @return
     */
    public static  TreeNode sortedArrayToBST(int[] nums) {

        return dfs(nums,0,nums.length-1);

    }

    public static  TreeNode dfs(int[] nums ,int l,int r){
        if (l > r){
            return null;
        }
        int mid = l + (r-l)/2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = dfs(nums,l,mid-1);
        head.right = dfs(nums,mid+1,r);
        return head;
    }

    public static void main(String[] args) {

        int[] arr= new int[]{-10,-3,0,5,9};
        TreeNode node = sortedArrayToBST(arr);
        System.out.println("test");
    }
}
