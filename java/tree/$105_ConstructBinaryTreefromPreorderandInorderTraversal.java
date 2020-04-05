/**
 * 这里给出了中序遍历和前序遍历的结果，可知中序遍历的顺序是左节点->根节点->右节点，而前序遍历的顺序是根节点->左节点->右节点
 * 举个例子：某树的前序遍历和中序遍历结果如下：
 * 前序遍历：3,9,20,15,7
 * 中序遍历：9,3,15,20,7
 * 可知前序遍历数组的第一个元素3为根节点，后面的元素分别为该根节点左子树和右子树的元素，在中序遍历数组中，3为根节点，左边的元素为左子树元素，
 * 右边的元素为右子树的元素，根据以上分析，可以使用递归来构建树，步骤如下：
 * 1.树的根节点为前序遍历的第一个元素preStart
 * 2.在中序遍历数组中找到根节点的索引为止Index，左子树有index-inStart个元素，故左子树在中序遍历数组中的范围是[inStart,index-1]
 * 3.根据左子树的元素个数，得到前序遍历左子树元素的范围是[preStart+1,preStart+index-inStart]
 * 4.递归得到当前根节点的左子树
 * 5.而前序遍历右子树元素的范围是[preStart + index - inStart + 1,preEnd]，中序遍历右子树的范围是[index + 1, inEnd]
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = inStart;
        while (index <= inEnd) {
            if (inorder[index] == preorder[preStart]) break;
            index++;
        }
        root.left = helper(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1);
        root.right = helper(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}

public class $105_ConstructBinaryTreefromPreorderandInorderTraversal {
}
