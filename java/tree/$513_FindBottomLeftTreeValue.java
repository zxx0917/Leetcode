import java.util.LinkedList;
import java.util.Queue;

/**
 * 方法1：迭代，层序遍历，保存每层左边第一个元素为结果，遍历完成后直接返回结果
 * 方法2：递归：中序遍历，找到最深层，将左边第一个元素保存在结果中
 */
public class $513_FindBottomLeftTreeValue {
    //方法1：迭代
    public int findBottomLeftValue1(TreeNode root) {
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            //将每层左边第一个作为结果
            res = queue.peek().val;
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }


    //方法2：递归
    int maxDepth = -1, res = -1;

    public int findBottomLeftValue2(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) return;
        helper(root.left, depth + 1);
        //判断是否是最大深度
        if (depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }
        helper(root.right, depth + 1);
    }

}
