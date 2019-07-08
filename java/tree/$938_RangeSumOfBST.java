/**
 * 可以使用两种方法：
 * 方法1：使用BST的性质，递归的终止条件如下：
 * 1.root==null，返回0
 * 2.root.val<L，返回右子树的和
 * 3.root.val>R，返回左子树的和
 * 4.L<=root.val <=R，返回root.val+左子树之和+右子树之和
 *
 * 方法2：使用中序遍历遍历每个节点，当节点值在[L,R]时加入sum
 */
public class $938_RangeSumOfBST {
    //方法1
    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null) return 0;
        //根据BST的性质：
        if (root.val < L) {
            return rangeSumBST1(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST1(root.left, L, R);
        }
        return root.val + rangeSumBST1(root.left, L, R) + rangeSumBST1(root.right, L, R);

    }

    //方法2：中序遍历
    int sum;
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if(root == null) return 0;
        //根据BST的性质：
        helper(root,L,R);
        return sum;
    }

    private void helper(TreeNode root, int l, int r) {
        if(root == null) return;
        helper(root.left,l,r);
        if(root.val >= l && root.val <= r)
            sum += root.val;
        helper(root.right,l,r);
    }
}
