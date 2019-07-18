/**
 * 先比较根节点，如果根节点相同，则分为两种情况：
 * 1.顺序比较：比较root1的左子树和roo2的左子树、root1的右子树和root2的右子树；
 * 2.交叉比较：比较root1的左子树和roo2的右子树、root1的右子树和root2的左子树，上述两种情况只要有一种符合就是翻转子树
 */
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        if (root1.val == root2.val) {
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                    (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        }
        return false;
    }
}

public class $951_FlipEquivalentBinaryTrees {
}
