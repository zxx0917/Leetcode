/**
 * 深度优先搜索，在递归时传入StringBuilder作为容器拼接节点值，当到达叶子节点时将容器中的值加入sum中，注意每次遍历完需要将当前节点值删除。
 */
public class $129_SumRootToLeafNumbers {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, new StringBuilder());
        return res;
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        //拼接当前路径的当前元素值
        sb.append(root.val);
        //判断是否是叶子节点
        if (root.right == null && root.left == null) {
            //将路径值加入结果
            res += Integer.parseInt(sb.toString());
        }
        helper(root.left, sb);
        helper(root.right, sb);
        //回退
        sb.deleteCharAt(sb.length() - 1);
    }
}
