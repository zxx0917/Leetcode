import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1.递归
 * 递归的终止条件：1)当前节点为null，返回0；2)当前节点为叶子节点，返回1
 * 每层递归需要做的事：获得左右子树的最小深度，最后的最小深度为min+1
 *
 * 2.层序
 * 使用dfs每个节点都需要遍历到，而使用层序时记录每个节点所在的层次，然后遇到的第一个叶子节点的层次就是最小深度
 */
public class $111_MinimumDepthofBinaryTree {
    //1.递归
    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        if(root.right == null && root.left == null) return 1;
        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(min,minDepth1(root.left));
        }
        if(root.right != null){
            min = Math.min(min,minDepth1(root.right));
        }
        return min+1;
    }

    //2.迭代：逐层遍历，遇到的第一个叶子节点所在的深度就是最小深度
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        int currentDepth = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            currentDepth++;
            while (count-- > 0) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode cur = pair.getKey();
                //第一个叶子节点，直接返回层数
                if (cur.left == null && cur.right == null) {
                    return pair.getValue();
                }
                if (cur.left != null) {
                    queue.add(new Pair<>(cur.left, currentDepth));
                }
                if (cur.right != null) {
                    queue.add(new Pair<>(cur.right, currentDepth));
                }
            }
        }
        return 0;
    }
}
