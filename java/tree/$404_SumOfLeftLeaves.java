/**
 * dfs，每次递归时判断当前节点是否是左叶子节点，即在递归时定义一个参数存储当前节点的上一个节点，如果当前节点左右节点为null且是上一个节点的左儿子，
 * 则当前节点就是左叶子节点，加入结果集即可
 */
public class $404_SumOfLeftLeaves {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root, null);
        return res;
    }

    private void helper(TreeNode root, TreeNode pre) {
        if (root == null) return;
        //判断是否是左叶子节点
        if (root.left == null && root.right == null && pre != null && pre.left == root)
            res += root.val;

        //递归
        helper(root.left, root);
        helper(root.right, root);
    }
}
