/**
 * 类似于105题，只是这里的根节点元素是后序遍历数组的最后一个元素
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = inStart;
        while (index <= inEnd) {
            if (inorder[index] == root.val) break;
            index++;
        }
        root.left = helper(inorder, inStart, index - 1, postorder, postStart, postStart+index-inStart-1);
        root.right = helper(inorder, index + 1, inEnd, postorder, postStart+index-inStart, postEnd - 1);
        return root;
    }
}


public class $106_ConstructBinaryTreefromInorderandPostorderTraversal {
}
