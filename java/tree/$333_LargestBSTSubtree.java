/**
 * dfs判断树中所有子树是否为BST，如果是BST，则计算该子树的节点个数，保存在结果变量中，取最大值即可。
 * 判断当前树是否是BST：因为BST中序遍历为升序，所以如果当前元素小于等于上一个元素，则返回false
 */
public class $333_LargestBSTSubtree {
    int res = 0, preVal = Integer.MIN_VALUE;

    public int largestBSTSubtree(TreeNode root) {
        //深度优先搜索 判定每个子树是否是BST
        if (root == null) return 0;
        //每次判定是否是BST之前要初始化变量
        preVal = Integer.MIN_VALUE;
        if (isBST(root)) {
            res = Math.max(res, getCount(root));
        }
        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);
        return res;
    }

    //获取当前树的节点个数
    private int getCount(TreeNode root) {
        if (root == null) return 0;
        return getCount(root.right) + getCount(root.left) + 1;
    }

    //判断当前树是否是BST，因为BST中序遍历为升序，所以如果当前元素小于等于上一个元素，则返回false
    private boolean isBST(TreeNode root) {
        if (root == null) return true;
        boolean leftFlag = isBST(root.left);
        if (preVal >= root.val) return false;
        preVal = root.val;
        boolean rightFlag = isBST(root.right);
        return leftFlag && rightFlag;
    }
}
