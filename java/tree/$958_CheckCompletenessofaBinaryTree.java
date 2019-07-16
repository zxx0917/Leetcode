import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用层序遍历，这里将根节点的null节点也加入了Queue，等同于遍历了h+1层。
 * 当出现第一个null节点，记录。如果出现null节点后还出现了非Null节点，表示节点不是全部都靠左或1~h-1层未全满，返回false
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean occurNull = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                //出现第一个null节点，记录。如果出现null节点后还出现了非Null节点，表示节点不是全部都靠左，返回false
                if (cur == null && !occurNull) {
                    occurNull = true;
                } else if (cur != null && occurNull) {
                    return false;
                } else if (cur != null && !occurNull) {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        return true;
    }
}

public class $958_CheckCompletenessofaBinaryTree {
}
