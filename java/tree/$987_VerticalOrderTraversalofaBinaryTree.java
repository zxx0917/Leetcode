import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    //创建一个新类Location在保存当前节点的坐标和节点值，dfs树，获取每个节点的Location对象，加入集合中，然后Location根据x值从小到大排列，y值从大到小排列，根节点值从小到大排列
    //最后根据x值的变化整理集合即可
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Location> list = new ArrayList<>();
        helper(root, list, 0, 0);
        //按照指定排序规则排序
        Collections.sort(list);
        //整理集合
        int preX = Integer.MIN_VALUE;
        for (Location location : list) {
            if (preX != location.x) {
                //创建新集合
                res.add(new ArrayList<>());
            }

            res.get(res.size() - 1).add(location.nodeVal);
            preX = location.x;
        }
        return res;
    }

    private void helper(TreeNode root, List<Location> list, int x, int y) {
        if (root == null) return;
        list.add(new Location(x, y, root.val));
        helper(root.left, list, x - 1, y + 1);
        helper(root.right, list, x + 1, y + 1);
    }
}

class Location implements Comparable<Location> {
    int x;
    int y;
    int nodeVal;

    public Location(int x, int y, int nodeVal) {
        this.x = x;
        this.y = y;
        this.nodeVal = nodeVal;
    }


    @Override
    public int compareTo(Location l2) {
        if (this.x != l2.x) {
            return this.x - l2.x;
        } else if (this.y != l2.y) {
            return this.y - l2.y;
        } else if (this.nodeVal != l2.nodeVal) {
            return this.nodeVal - l2.nodeVal;
        }
        return 0;
    }
}


public class $987_VerticalOrderTraversalofaBinaryTree {
}
