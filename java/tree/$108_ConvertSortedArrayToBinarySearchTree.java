public class $108_ConvertSortedArrayToBinarySearchTree {
    //中间元素作为根节点，左边元素为左子树，右边元素为右子树，递归
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, lo, mid - 1);
        root.right = helper(nums, mid + 1, hi);
        return root;
    }
}
