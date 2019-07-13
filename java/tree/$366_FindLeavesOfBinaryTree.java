import java.util.ArrayList;
import java.util.List;

/**
 * 使用dfs，递归时传入上一个节点，如果当前节点是叶子节点，则将值加入集合，使用上个节点将当前叶子节点删除。
 * 每递归一次就会修剪掉叶子节点，形成新树，循环修剪叶子节点，直至只剩下根节点，最后将根节点加入结果集即可。
 */
public class $366_FindLeavesOfBinaryTree {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return res;
        //如果除了根节点之外还有节点，递归
        while (root.left != null || root.right != null) {
            helper(root, null, list);
            res.add(new ArrayList<>(list));
            list.clear();
        }
        //整棵树只剩下根节点，加入根节点
        list.add(root.val);
        res.add(new ArrayList<>(list));
        return res;
    }

    private void helper(TreeNode root, TreeNode pre, List<Integer> list) {
        if (root == null) return;
        //判断当前节点是否是叶子节点
        if (root.left == null && root.right == null) {
            list.add(root.val);
            //删除当前叶子节点
            if (pre != null && pre.left == root) pre.left = null;
            if (pre != null && pre.right == root) pre.right = null;
        }
        pre = root;
        helper(root.left, pre, list);
        helper(root.right, pre, list);
    }
}
