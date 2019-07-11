/**
 * 递归，递归返回的条件如下：
 * 1.当前节点为Null返回false
 * 2.当前节点是叶子节点且节点值和sum相同，返回true
 * 每次递归时求当前节点的左右子树路径和是否为sum-root.val
 */
public class $112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum - root.val == 0) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
