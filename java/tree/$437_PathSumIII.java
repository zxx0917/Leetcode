/**
 * 使用两个dfs，一个用于遍历树的所有节点，一个用来求以当前节点为根的子树上是否有路径和等于sum
 */
class Solution {
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum);
        return res;
    }

    //遍历得到树中每个节点
    private void helper(TreeNode root, int sum) {
        if (root == null) return;
        isEqualToSum(root, sum);
        helper(root.left, sum);
        helper(root.right, sum);
    }

    //求当前子树是否有路径和为sum
    private void isEqualToSum(TreeNode root, int sum) {
        if (root == null) return;
        if (sum == root.val) {
            res++;
        }
        isEqualToSum(root.left, sum - root.val);
        isEqualToSum(root.right, sum - root.val);
    }
}

public class $437_PathSumIII {
}