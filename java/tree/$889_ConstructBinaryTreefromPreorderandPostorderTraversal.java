/**
 * 中序遍历的第一个元素是根节点，后序遍历的最后一个元素是根节点，倒数第二个元素是右子树的根节点，所以可以根据后序遍历得到右子树根节点的值
 * 然后在中序遍历中找到右子树根节点的位置rightIndex，对于中序遍历，当前节点的左子树元素索引为[preStart+1,rightIndex-1]，右子树元素的索引为[rightIndex,preEnd]。
 * 而对于后续遍历，可以知道左子树的元素个数为rightIndex-preStart-1，所以后续遍历的左子树元素索引为[postStart,rightIndex-preStart-1-1]，右子树的元素索引为[rightIndex-preStart-1,postEnd-1]
 * 递归构建树即可
 */
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0 || post.length == 0 || pre.length != post.length) return null;
        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) return null;
        //构建根节点：中序遍历第一个元素
        TreeNode root = new TreeNode(pre[preStart]);
        //获取中序遍历中右子树根节点的索引
        int rightIndex = preStart + 1;
        for (int i = preStart + 1; i <= preEnd; i++) {
            if (pre[i] == post[postEnd - 1]) {
                rightIndex = i;
                break;
            }
        }
        //递归构建左右子树，左子树的元素个数为：rightIndex-preStart-1
        root.left = helper(pre, preStart + 1, rightIndex - 1, post, postStart, postStart + rightIndex - preStart - 2);
        root.right = helper(pre, rightIndex, preEnd, post, postStart + rightIndex - preStart - 1, postEnd - 1);
        return root;
    }
}

public class $889_ConstructBinaryTreefromPreorderandPostorderTraversal {
}
