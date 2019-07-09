/**
 * 递归终止条件：root==null
 * 每次遍历：求左子树、右子树的最大深度
 */
public class $104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //求左子树、右子树的最大深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //最大值一定是左右子树的最大深度+当前深度
        return Math.max(left, right) + 1;
    }
}
