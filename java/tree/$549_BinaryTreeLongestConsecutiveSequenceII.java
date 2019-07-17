/**
 * 根节点有可能处于递增或递减位置，所以创建一个数组，分别用来保存当前节点的递增数列的连续路径数和递减数列的连续路径数（这里路径长度是节点个数，所以数组要初始化为1），最后返回这个数组
 * 
 * 1.根节点能对结果造成什么影响：如果根节点处于左子树或右子树的递增或递减序列中，则结果为包括根节点的递增序列数+包括根节点的递减序列数-1（去除重复根节点）
 *
 * 2.对下次递归的贡献：求出当前节点的递增和递减序列数。
 * 当当前根节点处于左子树的递增位置时，当前节点的递增序列数为左子树的递增序列数+1
 * 当当前根节点处于左子树的递减位置时，当前节点的递减序列数为左子树的递减序列数+1
 * 当当前根节点处于右子树的递增位置时，当前节点的递增序列数为左子树递增序列数+1和右子树递增序列数+1的最大值
 * 当当前根节点处于右子树的递减位置时，当前节点的递减序列数为左子树递减序列数+1和右子树递减序列数+1的最大值
 */
class Solution {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        //arr[0]为递增序列路径数，arr[1]为递减序列路径数
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 1;
        if (root == null) return arr;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        //判断root在左子树中处于递增还是递减
        if (root.left != null) {
            if (root.left.val - 1 == root.val) arr[1] = left[1] + 1;
            if (root.left.val + 1 == root.val) arr[0] = left[0] + 1;
        }

        //判断root在右子树中处于递增还是递减，最后arr结果中保留最大值
        if (root.right != null) {
            if (root.right.val - 1 == root.val) arr[1] = Math.max(arr[1], right[1] + 1);
            if (root.right.val + 1 == root.val) arr[0] = Math.max(arr[0], right[0] + 1);
        }

        //统计结果
        res = Math.max(res, arr[0] + arr[1] - 1);
        return arr;
    }
}

public class $549_BinaryTreeLongestConsecutiveSequenceII {
}
