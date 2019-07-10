/**
 * 从底向上后续遍历，如果当前元素为0且左右子树为null，则删除节点
 */
public class $814_BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null)
            return null;
        return root;
    }
}
