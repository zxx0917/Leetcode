/**
 * 对根节点的左右子树进行递归判断，递归结束条件有3：
 * 1.左右节点均为null，返回true
 * 2.左右节点有一个为null，返回false
 * 3.左右节点均不为null，且值不等，返回false
 */
public class $101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        //左右节点有一个为Null
        if(left == null || right == null) return false;
        //左右节点值不相等，返回false
        if(left.val != right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
