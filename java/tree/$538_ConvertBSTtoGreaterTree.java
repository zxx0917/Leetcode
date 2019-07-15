/**
 * 从BST的最大节点开始自底向上递归，节点的更新顺序为右->中->左。创建一个全局变量来保存当前节点需要累加的节点数，当前节点需要累加的节点值sum为上一个节点的val+上一个节点需要累加的sum
 */
class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        //更新累加值
        sum += root.val;
        //改变节点值
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}

public class $538_ConvertBSTtoGreaterTree {
}
