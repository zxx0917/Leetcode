import java.util.ArrayList;
import java.util.List;

/**
 * 这道题使用HashMap+中序遍历很简单，进阶里要求不使用额外空间，则可以使用BST的中序遍历，在递归时使用count和maxCount来记录
 * 当前元素出现的次数，如果前一个节点和当前节点值相等，则count+1，如果不等则重置计数器，count=1。当count > maxCount时，表示当前节点出现次数最多，
 * 清空结果集，加入当前节点。如果count == maxCount，表示有多个众数，直接将节点加入结果集
 */
public class $501_FindModeInBinarySearchTree {
    class Solution {
        int maxCount = 0, count = 1;
        TreeNode pre = null;

        public int[] findMode(TreeNode root) {
            if (root == null) return new int[]{};
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            //放入数组
            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root == null) return;
            helper(root.left, res);
            //如果是第一个元素
            if (pre != null) {
                //如果当前元素和前一个元素相同，则累加计数器，并判断是否是最大出现次数；不过不相等则将计数器重置
                count = pre.val == root.val ? count + 1 : 1;
            }
            if (count > maxCount) {
                maxCount = count;
                res.clear();
                res.add(root.val);
            } else if (count == maxCount) {
                res.add(root.val);
            }
            pre = root;
            helper(root.right, res);
        }
    }
}
