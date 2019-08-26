import java.util.Arrays;

/**
 * 并查集，在并查集中创建一个变量来记录合并的次数，总结点数减去合并次数就等于连同分类数目
 */
class Solution {
    public int countComponents(int n, int[][] edges) {
        int len = edges.length;
        if (n == 0) return 0;
        if (len == 0) return n;
        DisjointSet disjoint = new DisjointSet(n);
        for (int[] edge : edges) {
            disjoint.union(edge[0], edge[1]);
        }
        return disjoint.getRes();
    }
}

class DisjointSet {
    private int res;//记录连通分量个数
    private int[] parent;
    private int[] rank;//记录根节点的层高

    public DisjointSet(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
        rank = new int[n];
        res = n;
    }

    public int getRes() {
        return this.res;
    }

    public int findRoot(int val) {
        int root = val;
        while (parent[root] != -1) {
            root = parent[root];
        }
        return root;
    }

    public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        if (xRoot == yRoot) return;
        if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else {
            parent[xRoot] = yRoot;
            rank[yRoot]++;
        }
        res--;
    }
}


public class $323_NumberOfConnectedComponentsInAnUndirectedGraph {
}
