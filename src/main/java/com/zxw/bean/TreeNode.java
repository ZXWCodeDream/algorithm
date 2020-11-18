package main.java.com.zxw.bean;

/**
 * ClassName: TreeNode
 * Description:
 *
 * @author zxw
 * @date 2020/9/18 10:56 上午
 * @since JDK 1.8
 */
public  class TreeNode {


    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public  int val;
    public  TreeNode left;
    public  TreeNode right;

    public  int getVal() {
        return val;
    }



    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(){
    }
}
