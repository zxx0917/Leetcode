/**
 * 定义一个全局变量，用于储存各个树的坡度。自底向上求出当前节点的左子树和右子树之和，两者的绝对值之差就是坡度，每次递归结束返回当前子树之和（包括根节点）
 */
class Solution {
    int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        //求坡度
        getTilt(root);
        return res;
    }

    private int getTilt(TreeNode root) {
        if (root == null) return 0;
        int sumLeft = getTilt(root.left);
        int sumRight = getTilt(root.right);
        res += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + root.val;
    }
}

public class $563_BinaryTreeTilt {
}
