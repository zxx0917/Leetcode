import java.util.Arrays;

/**
 * 典型并查集问题，首先构建一个并查集类，当两个人互为朋友时合并，最后朋友圈的数量等于总人数-合并次数
 */
class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        if (len == 0) return 0;
        Disjoint disjoint = new Disjoint(len);
        //插入边
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (M[i][j] == 1) {
                    disjoint.union(i, j);
                }
            }
        }
        return disjoint.getCount();
    }
}

class Disjoint {
    private int count;//保存总顶点数
    private int[] parent;
    private int[] rank;//根节点的层高

    public Disjoint(int n) {
        this.count = n;
        parent = new int[n];
        Arrays.fill(parent, -1);
        ;
        rank = new int[n];
    }

    public int findRoot(int val) {
        int rootVal = val;
        while (parent[rootVal] != -1) {
            rootVal = parent[rootVal];
        }
        return rootVal;
    }

    //合并
    public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        //同一个朋友圈，不需要处理
        if (xRoot == yRoot) return;
        //压缩路径，高层的根节点作为合并后的根节点
        if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else {
            //两者相等，可以随意取一个作为根节点，这里统一选取y作为根节点，层高+1
            parent[xRoot] = yRoot;
            rank[yRoot]++;
        }
        //每次union之后，连同分类-1
        count--;
    }

    public int getCount() {
        return this.count;
    }
}


public class $547_FriendCircles {
}
