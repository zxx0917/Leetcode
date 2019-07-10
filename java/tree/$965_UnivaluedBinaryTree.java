/**
 * 单值二叉树要求每个元素都相同，可以选取根节点作为对比，如果是非单值二叉树，则一定有元素和根节点不同，
 * 所以采用前序遍历，先比对当前节点和根节点是否相同，如果相同则递归比较左节子树节点和右子树节点与根节点是否相同
 */
public class $965_UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return helper(root,root.val);
    }

    private boolean helper(TreeNode root, int val) {
        if(root == null) return true;
        if(val != root.val) return false;
        return helper(root.left,val) && helper(root.right,val);
    }
}
