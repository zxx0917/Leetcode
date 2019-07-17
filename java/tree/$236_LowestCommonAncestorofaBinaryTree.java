import java.util.*;

class Solution {
    //深度遍历树，将当前节点和父节点存入Map，直到找到q/p，然后根据p、q在Map中找它们的祖先，使用Set来找出最先出现的祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<TreeNode, TreeNode> map = new HashMap<>();
        //储存根节点
        map.put(root, null);
        //迭代
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode cur = queue.poll();
            //放入当前节点和父节点
            if (cur.left != null) {
                queue.add(cur.left);
                map.put(cur.left, cur);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                map.put(cur.right, cur);
            }
        }

        Set<TreeNode> set = new HashSet<>();
        //将p和祖先节点放入set
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        //遍历q的各个祖先，第一个包含在set中的节点就是LCR
        while (!set.contains(q)) {
            q = map.get(q);
        }
        return q;
    }
}

public class $236_LowestCommonAncestorofaBinaryTree {
}
