/**
 * 创建两个指针，分别指向新树的根节点和最新生成的节点。进行中序遍历，每次递归时将当前节点按照题意连接到新树上即可
 */
class Solution {
    TreeNode pre = null, first = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return first;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre == null) {
            //构建根节点
            first = root;
            pre = root;
            pre.left = null;
        } else {
            pre.right = root;
            pre = root;
            pre.left = null;
        }
        helper(root.right);
    }
}

public class $897_IncreasingOrderSearchTree {
}
