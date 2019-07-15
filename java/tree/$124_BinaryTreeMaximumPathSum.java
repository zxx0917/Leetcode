class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        getMax(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null) return 0;
        //自底向上求出左右子树对结果的贡献
        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);
        //给当前最大路径和赋值
        res = Math.max(res, leftMax + rightMax + root.val);
        //左右子树最大路径和与当前节点值的和为当前节点的最大路径，如果为负值则表示不选该路，设为0
        return Math.max(0, Math.max(leftMax, rightMax) + root.val);
    }
}

public class $124_BinaryTreeMaximumPathSum {
}
