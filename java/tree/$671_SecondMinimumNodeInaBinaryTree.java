/**
 * 创建两个变量，表示最小和第二小的元素，遍历整个树，遍历时来筛选值即可
 */
class Solution {
    long min = Long.MAX_VALUE, secondMin = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        //第二小的值没有更新，则没有该值
        if (secondMin == Long.MAX_VALUE) return -1;
        return (int) secondMin;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        //判断当前节点，如果最小值大于当前节点，则更新secondmin和min
        if (min > root.val) {
            //注意需要保留原来的最小节点
            secondMin = min;
            min = root.val;
        } else if (min != root.val && secondMin > root.val) {//如果min小于当前值且secondmin大于当前值，则更新secondmin
            //这里要注意当min等于当前值时，secondMin不需要更新
            secondMin = root.val;
        }
        helper(root.left);
        helper(root.right);
    }
}

public class $671_SecondMinimumNodeInaBinaryTree {
}
