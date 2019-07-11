/**
 * 自底向上，分别求出左右子树的最大高度，如果左右子树高度差超过1，使用全局变量来记录
 */
public class $110_BalancedBinaryTree {
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left-right) > 1) res = false;
        return Math.max(left,right)+1;
    }
}
