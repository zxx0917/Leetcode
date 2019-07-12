/**
 * 两个递归:
 * 第一个递归用来遍历整个树;
 * 第二个递归用来判断当前节点是否是同值树，递归开始时传入根节点的值，逐个比较子节点是否和各节点值相等
 */
public class $250_CountUnivalueSubtrees {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        //判断当前节点是否是同值子树
        if (isUniVal(root, root.val)) res++;
        //遍历树的每个节点
        countUnivalSubtrees(root.left);
        countUnivalSubtrees(root.right);
        return res;
    }

    //判断当前节点是否是同值子树，传入根节点的值
    private boolean isUniVal(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return isUniVal(root.left, val) && isUniVal(root.right, val);
    }
}
