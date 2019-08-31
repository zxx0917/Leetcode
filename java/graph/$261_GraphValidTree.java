import java.util.*;

/**
 * 判断一个图是否为树结构就是判断这个图是否有环，如果无环且连同分量为1，则是树结构
 * 乘着这道题来训练以下判断图无环的算法
 * 方法1：并查集，如果合并的两个点在一个集合中，则这个图是有环的
 * 方法2：BFS：根据边构建邻接矩阵，然后进行BFS，如果在遍历过程中将访问过的节点涂黑，并记录访问过的节点。如果有节点已经被访问过，则表示有环，如果遍历完成后还有节点没有被访问到，则表示连同分量大于1
 * 方法3：DFS：思路同BFS
 */
class Solution {
    //方法1：并查集
    public boolean validTree1(int n, int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge : edges) {
            if (!disjointSet.union(edge[0], edge[1]))
                return false;
        }
        return disjointSet.getCount() == 1;
    }

    class DisjointSet {
        int n;
        int[] parent;
        int[] rank;
        int count; //连同分量

        DisjointSet(int n) {
            this.n = n;
            this.parent = new int[n];
            Arrays.fill(parent, -1);
            this.rank = new int[n];
            this.count = n;
        }

        private int findRoot(int x) {
            int root = x;
            while (parent[root] != -1) {
                root = parent[root];
            }
            return root;
        }

        public boolean union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            //如果两个在同一颗树上，直接返回false
            if (xRoot == yRoot) return false;
            //压缩路径
            if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] == rank[yRoot]) {
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            }
            count--;
            return true;
        }

        public int getCount() {
            return this.count;
        }
    }


    //方法2：BFS
    public boolean validTree2(int n, int[][] edges) {
        //构建邻接矩阵
        int[][] graph = new int[n][n];
        //有边的元素设置为1，没有边的元素设置为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        //进行BFS
        Queue<Integer> queue = new LinkedList<>();
        //从第一个节点开始搜索，这样就不会漏掉无边图的情况
        queue.add(0);
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            visited[cur] = true;
            //获取邻接点
            for (int i = 0; i < n; i++) {
                //查看当前节点的邻接点
                if (graph[cur][i] == 1) {
                    //如果访问过，则返回false
                    if (visited[i])
                        return false;

                    //标记邻接点，入队列
                    visited[i] = true;
                    //涂黑访问过的节点
                    graph[cur][i] = 0;
                    graph[i][cur] = 0;
                    queue.add(i);
                }
            }
        }

        //判断是否为单连通分量
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }


    //方法3：DFS
    public boolean validTree3(int n, int[][] edges) {
        //构建邻接矩阵
        int[][] graph = new int[n][n];
        //有边的元素设置为1，没有边的元素设置为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        //进行DFS
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        boolean[] visited = new boolean[n];
        while(!stack.isEmpty()){
            Integer cur = stack.pop();
            visited[cur] = true;
            for(int i = 0;i < n;i++){
                if(graph[cur][i] == 1){
                    if(visited[i]) return false;

                    visited[i] = true;
                    graph[cur][i] = 0;
                    graph[i][cur] = 0;
                    stack.add(i);
                }
            }
        }

        //判断是否为单连通分量
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}



public class $261_GraphValidTree {
}
