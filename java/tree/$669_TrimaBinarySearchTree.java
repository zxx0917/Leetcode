public class $669_TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        //如果根节点大于R，则所求元素一定在左子树
        if (root.val > R) return trimBST(root.left, L, R);
        //如果根节点小于L，则所求元素一定在右子树
        if (root.val < L) return trimBST(root.right, L, R);
        //如果根节点在L,R中，两边均修剪
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
