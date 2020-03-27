/**
 * 从BST的最右边节点开始进行累加，遍历的顺序是右->中->左，当前节点的更新值为当前节点的原有值+上个节点的累加值，所以设定一个全局变量来保存上一个节点，
 * 逐个累加节点值即可。
 */
class Solution {
    TreeNode pre = null;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += pre == null ? 0 : pre.val;
        pre = root;
        convertBST(root.left);
        return root;
    }
}

public class $538_ConvertBSTtoGreaterTree {
}
