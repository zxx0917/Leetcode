/**
 * dfs，使用两个公共变量记录当前最小差值和对应的节点值，根据结果更换记录的结果节点
 */
public class $270_ClosestBinarySearchTreeValue {
    double min = Double.MAX_VALUE;
    int res = 0;

    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        helper(root, target);
        return res;
    }

    private void helper(TreeNode root, double target) {
        if (root == null) return;
        if (min > Math.abs(root.val - target)) {
            min = Math.abs(root.val - target);
            res = root.val;
        }
        helper(root.left, target);
        helper(root.right, target);
    }

}
