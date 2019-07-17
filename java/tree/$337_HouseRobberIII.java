/**
 * 有两种情况：1.root.val+不带根节点的左右子树结果；2.带根节点的左右子树结果，不加root.val值，用数组储存树不包括节点和包括节点的最大值
 */
class Solution {
    public int rob(TreeNode root) {
        int[] res = doRob(root);
        return Math.max(res[0], res[1]);
    }

    //res[0]是不包括根节点的最大值，res[1]是包括根节点的最大值
    private int[] doRob(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        //求当前左/右子树的两个最大值
        int[] leftArr = doRob(root.left);
        int[] rightArr = doRob(root.right);
        //求根节点不包括根节点的最大值，即左右子树的最大值之和
        res[0] = Math.max(leftArr[0], leftArr[1]) + Math.max(rightArr[0], rightArr[1]);
        //求根节点包括根节点的最大值，即左右子树不包括根节点的值相加再加根节点
        res[1] = root.val + leftArr[0] + rightArr[0];
        return res;
    }
}

public class $337_HouseRobberIII {
}
