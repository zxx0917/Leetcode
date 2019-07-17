/**
 * 对于根节点，具有同值路径的有两种情况：
 * 1.左右子树都具有和根节点相同节点
 * 2.左右子树只有一边和根节点具有相同节点
 * 这两种情况下此树对下一次递归的贡献是相同的，即左右子树的同值路径的最大值+1
 */
class Solution {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int tmp = 0; //用来返回对下次递归的贡献
        //左右路径过root
        if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            res = Math.max(res, left + right + 2);
        }
        if (root.left != null && root.left.val == root.val) {
            tmp = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            tmp = Math.max(tmp, right + 1);
        }
        res = Math.max(res, tmp);
        return tmp;
    }
}

public class $687_LongestUnivaluePath {
}
