import java.util.*;

public class $103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //层序遍历，在奇数层将遍历结果翻转即可（层数从0开始）
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            //记录每层节点
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            //使用结果集的size来判断奇数层
            if (res.size() % 2 == 1) {
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}
