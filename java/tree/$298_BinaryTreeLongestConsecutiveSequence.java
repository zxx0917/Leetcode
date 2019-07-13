/**
 * dfs，每次递归时保存父节点的值，判断当前节点值和父节点值是否差1，并求出累积的最大值即可
 */
public class $298_BinaryTreeLongestConsecutiveSequence {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root,null,0);
        return res;
    }

    private void helper(TreeNode root, TreeNode pre, int length) {
        if(root == null) return;
        length = (pre != null && pre.val+1 == root.val)?length+1:1;
        res = Math.max(res,length);
        helper(root.left,root,length);
        helper(root.right,root,length);
    }
}
