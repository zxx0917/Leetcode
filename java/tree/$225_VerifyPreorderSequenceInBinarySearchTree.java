/**
 * BST的左子树所有节点都小于根节点，右子树的所有节点都大于根节点，所以遍历数组，
 * 找到第一个大于根节点的元素就是右子树的根节点，右子树所有节点都要大于上一个根节点，递归处理
 */
public class $225_VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0) return true;
        return helper(preorder, 1, preorder.length - 1, preorder[0], false);
    }

    private boolean helper(int[] preorder, int start, int end, int root, boolean findRoot) {
        if (start > end) return true;
        //找到右子树节点
        int rightRootIndex = start;
        for (int i = start; i <= end; i++) {
            if (!findRoot && preorder[i] > root) {
                findRoot = true;
                rightRootIndex = i;
            }
            //右子树根节点之后的所有元素都要大于上一个根节点
            if (findRoot && preorder[i] < root) {
                return false;
            }
        }
        return helper(preorder, start+1, rightRootIndex-1, preorder[start], false) && helper(preorder, rightRootIndex+1, end, preorder[rightRootIndex], false);
    }
}
