/**
 * 使用BST的特征，比对当前节点值和val的大小关系，如果相等直接返回当前节点，如果小于val，则递归查找左子树，如果大于val则递归查找右子树
 */
public class $700_SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val < val) {
            return searchBST(root.right, val);
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }
}
