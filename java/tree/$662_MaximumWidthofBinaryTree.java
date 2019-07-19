import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用层序遍历，每层遍历时使用一个list来储存下次层元素的索引位置，比如根节点的索引位置为1，则下一层两个子节点的索引为2,3
 * 当根节点索引位置为k时，下一层的两个节点的索引分别为2k、2k+1，当一层遍历完后获取List中的第一个索引和最后一个索引，两者相减+1就是当前层的最大宽度
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> list = new LinkedList<>();
        //根节点的索引值为1
        list.addFirst(1);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                //获取并移除当前节点的索引位置
                int index = list.removeFirst();
                if (cur.left != null) {
                    queue.add(cur.left);
                    list.add(index * 2);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    list.add(index * 2 + 1);
                }
            }
            //本层遍历结束，求下一层的最大宽度
            if (list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }
        return res;
    }
}

public class $662_MaximumWidthofBinaryTree {
}
