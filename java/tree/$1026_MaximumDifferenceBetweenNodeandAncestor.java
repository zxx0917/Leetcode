/**
 * 使用全局变量保存最大差值，进行dfs，每次递归查找当前路径的最大值和最小值，到达叶子节点时使用当前路径的最大值和最小值更新全局变量
 */
class Solution {
    int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        //如果当前节点没有子节点，则直接返回
        helper(root, root.val, root.val);
        return res;
    }

    /**
     * 每条从根节点到叶子节点的路径中的最大值和最小值，并求出差值更新全局变量
     */
    private void helper(TreeNode node, int max, int min) {
        if (node == null) return;
        max = Math.max(node.val, max);
        min = Math.min(node.val, min);
        //到达叶子节点，求最大差值
        if (node.left == null && node.right == null) {
            res = Math.max(res, Math.abs(max - min));
        }
        helper(node.left, max, min);
        helper(node.right, max, min);
    }
}

public class $1026_MaximumDifferenceBetweenNodeandAncestor {
}
