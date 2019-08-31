import java.util.*;

/**
 * 因为离边界越远的节点越可能成为根节点，所以每次删除叶子节点，一层一层往里收缩，最后留下的就是可能的根节点
 * 使用拓扑排序的类似算法，每次删除入度为1的节点，最后剩下的1个或两个入度为1的节点就是可能的最小高度树的根节点
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        //特殊情况：
        if(n <= 2){
            for(int i = 0;i < n;i++) res.add(i);
            return res;
        }

        //构造邻接矩阵
        Set<Integer>[] graph = new Set[n];
        //初始化
        for(int i = 0;i < n;i++){
            graph[i] = new HashSet<>();
        }
        //入度数组
        int[] degrees = new int[n];

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        //将入度为1的节点放入Queue
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1)
                queue.addLast(i);
        }

        //使得最后剩下一个或两个节点
        while (n > 2) {
            int size = queue.size();
            //一次性减去所有的叶子节点
            n -= size;
            while (size-- > 0) {
                //得到当前叶子节点
                Integer cur = queue.poll();
                //出度改变
                degrees[cur]--;
                //对于其所有的邻接点入度-1
                if(!graph[cur].isEmpty()){
                    for(int node : graph[cur]){
                        degrees[node]--;
                        if(degrees[node] == 1) queue.add(node);
                        //删除叶子节点和邻接点的关系
                        graph[cur].remove(node);
                        graph[node].remove(cur);
                    }
                }
            }
        }

        //剩下位于Queue中的节点就是根节点
        return queue;
    }
}

public class $310_MinimumHeightTrees {
}
