/**
 *  从低向上遍历，每次遍历返回当前子树的元素和和节点个数，使用数组arr储存，arr[0]为元素和，arr[1]为节点个数，然后更新包括当前根节点在内的平均值
 */
class Solution {
    double res = 0;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) return arr;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        //设置当前树的元素和
        arr[0] = left[0] + right[0] + root.val;
        //设置节点个数
        arr[1] = left[1] + right[1] + 1;
        //更新平均值
        res = Math.max(res,(double) arr[0] / arr[1]);
        return arr;
    }
}

public class $1120_MaximumAverageSubtree {
}
