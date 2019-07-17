/*
 *一个二叉树的最长直径一定是某个节点的左右子树高度之和，定义全局变量，每次递归求出当前节点的左右高度之和，更新全局变量。
 */
class Solution {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}

public class $543_DiameterofBinaryTree {
}
