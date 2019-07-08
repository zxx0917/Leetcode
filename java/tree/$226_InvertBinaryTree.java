/**
 * 递归终止条件：当前节点为null
 * 每层递归需要做的事：将当前根节点的左右节点交换
 */
public class $226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode head = new TreeNode(root.val);
        head.left = invertTree(root.right);
        head.right = invertTree(root.left);
        return head;
    }
}
