/**
 * 因为BST的中序遍历是升序的，所以两节点的最小差值一定在相邻两个节点之间，所以中序遍历BST，计算相邻两个节点差值，并使用全局变量保存最值
 */
class Solution {
    int res = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null) res = Math.min(res, root.val - pre.val);
        pre = root;
        helper(root.right);
    }
}

public class $783_MinimumDistanceBetweenBSTNodes {
}
