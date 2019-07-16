import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 方法1：定义一个全局变量用来保持最小的路径值，dfs过程中不断更新即可。
 * 方法2：这里测试了一下采用优先队列来筛选出最小的字符串，而字符串通过dfs得到根节点到叶子节点的路径，然后再反转得到，效率不高，优先使用第一种方法
 */
class Solution {
    //方法1
    String res = "~";

    public String smallestFromLeaf1(TreeNode root) {
        if (root == null) return "";
        helper(root, new StringBuilder());
        return res;
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        //储存节点值，注意把int->char
        sb.append((char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            //比较更小的路径
            String path = sb.reverse().toString();
            if (res.compareTo(path) > 0) res = path;
            //将路径还原
            sb.reverse();
        }
        //递归
        helper(root.left, sb);
        helper(root.right, sb);
        //注意回退当前节点值
        sb.deleteCharAt(sb.length() - 1);
    }


    //方法2：测试优先队列
    public String smallestFromLeaf2(TreeNode root) {
        if (root == null) return "";
        //定义优先队列
        PriorityQueue<String> queue = new PriorityQueue<>(2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        //dfs求出字符串
        helper(root, queue, new StringBuilder());
        //如果只有一个节点
        if (queue.size() > 1) queue.remove();
        return queue.poll();
    }

    private void helper(TreeNode root, PriorityQueue<String> queue, StringBuilder sb) {
        if (root == null) return;
        //储存节点值，注意把int->char
        sb.append((char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            //到达叶子节点则将字符串反转加入优先队列
            if (queue.size() > 1) {
                queue.remove();
            }
            queue.add(sb.reverse().toString());
            //字符串还原
            sb.reverse();
        }
        //递归
        helper(root.left, queue, sb);
        helper(root.right, queue, sb);
        //注意回退当前节点值
        sb.deleteCharAt(sb.length() - 1);
    }
}

public class $988_SmallestStringStartingFromLeaf {
}
