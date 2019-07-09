import java.util.LinkedList;
import java.util.Queue;

/**
 * 两种方法：
 * 1.递归：
 * 递归终止条件：root==null时，返回0
 * 每层递归需要做的事情：分别求出当前节点子节点的最大深度，然后求出其最大值，最大值+1即为最大深度
 *
 * 2.迭代：层序遍历，遍历时记录层数即可
 */
public class $559_MaximumDepthofNaryTree {
    //递归：
    public int maxDepth1(Node root) {
        if (root == null) return 0;
        //求出每个子树的最大深度
        int max = 0;
        for (Node node : root.children){
            int depth = maxDepth1(node);
            max = Math.max(max,depth);
        }
        return max+1;
    }

    //迭代：层序遍历
    public int maxDepth2(Node root) {
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while(!queue.isEmpty()){
            int count = queue.size();
            maxDepth++;
            while(count > 0){
                count--;
                Node cur = queue.poll();
                for(Node node : cur.children){
                    if(node != null)
                        queue.add(node);
                }
            }
        }
        return maxDepth;
    }
}
