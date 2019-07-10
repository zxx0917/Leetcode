import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 方法1：使用Queue进行迭代
 * 方法2：前序遍历，递归时传入当前层数（从0开始）和结果集，结果集中的索引值对应层数，根据层数往结果集中加入当前节点值
 */
public class $429_NaryTreeLevelOrderTraversal {
    //1.利用Queue进行迭代
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            //外层循环为一层
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                //将当前元素的非空子节点压入栈
                Node cur = queue.poll();
                list.add(cur.val);
                for (Node node : cur.children) {
                    if (node != null) {
                        queue.add(node);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }

    //2.递归
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0, res);
        return res;
    }

    private void helper(Node root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        //判断是否是新的一层
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);

        //处理子节点
        for (Node node : root.children) {
            if (node != null) {
                helper(node, depth + 1, res);
            }
        }
    }
}
