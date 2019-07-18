/**
 * 对于叶子节点，如果有硬币数为N，那么它的过载量为（即需要移除或移入的金币数）Math.abs(N-1)
 * 从底向上遍历，每次遍历返回当前节点的子树的过载量。对于当前根节点，因为题目中已经说明金币数为节点个数，一定能保证每个节点有一个硬币，
 * 所以我们只要处理好左右子树的金币则根节点一定会满足条件。因此当前树子树需要移动的硬币量为左右过载量之和，
 * 而这个根节点的拥有的金币数为为L+R+node.val，过载量为L+R+node.val-1
 */
class Solution {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        //当前树需要移动的总次数为
        res += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }
}

public class $979_DistributeCoinsinBinaryTree {
}
