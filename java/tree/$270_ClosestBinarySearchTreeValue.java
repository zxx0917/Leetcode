/**
 * 中序遍历BST，判断当前节点和target的差值与记录的节点和target差值的大小，根据结果更换记录的结果节点
 */
public class $270_ClosestBinarySearchTreeValue {
    int res;

    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        helper(root, target);
        return res;
    }

    private void helper(TreeNode root, double target) {
        if (root == null) return;
        helper(root.left, target);
        res = Math.abs(res - target) > Math.abs(root.val - target) ? root.val : res;
        helper(root.right, target);
    }
}
