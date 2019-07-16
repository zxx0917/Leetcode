import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 *  堂兄弟节点是父节点不同而深度相同，所以我们可以定义一个方法，查找指定节点值的父节点和深度，分别存入Map(指定节点为key,父节点和深度为value)，比较父节点和深度即可
 */
class Solution {
    Map<Integer, Pair<TreeNode, Integer>> map = new HashMap<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        getParentAndPair(root, null, x, y, 0);
        //从Map中获取两个节点的parent和depth
        Pair<TreeNode, Integer> xPair = map.get(x);
        Pair<TreeNode, Integer> yPair = map.get(y);
        if (xPair.getKey() != yPair.getKey() && xPair.getValue() == yPair.getValue()) return true;
        return false;
    }

    private void getParentAndPair(TreeNode root, TreeNode parent, int x, int y, int depth) {
        if (root == null) return;
        //dfs寻找节点
        Pair<TreeNode, Integer> pair = null;
        if (x == root.val) {
            map.put(x, new Pair<>(parent, depth));
        }
        if(y == root.val){
            map.put(y, new Pair<>(parent, depth));
        }
        parent = root;
        getParentAndPair(root.left, parent, x, y, depth + 1);
        getParentAndPair(root.right, parent, x, y, depth + 1);
    }
}

public class $993_CousinsinBinaryTree {
}
