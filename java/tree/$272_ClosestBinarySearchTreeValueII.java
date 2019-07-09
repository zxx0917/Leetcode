import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 1.中序遍历，获得BST升序元素排列
 * 2.每个元素求出和target的绝对值，将差值和对应的节点值保存在Map<Double,List<Integer>>中，这里注意不同节点可能有相同的绝对差值
 * 3.然后根据差值从小到大排列，按照差值从小到大取k个对应节点值
 */
public class $272_ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        //1.中序遍历，获得BST的升序元素
        List<Integer> list = new ArrayList<>();
        helper(root, list);

        //2.根据升序元素数组，求出每个元素各target的差值绝对值，使用Map保存差值和对应的节点值(注意使用List)，
        HashMap<Double, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Double key = Math.abs(list.get(i) - target);
            List<Integer> valList = map.get(key);
            if (valList == null) {
                valList = new ArrayList<>();
            }
            valList.add(list.get(i));
            map.put(key, valList);
        }

        //3.排序
        List<Double> diffs = new ArrayList<>(map.keySet());
        Collections.sort(diffs);

        //4.获取k个值
        List<Integer> res = new ArrayList<>();
        for (double key : diffs) {
            for (int val : map.get(key)) {
                res.add(val);
                if (--k == 0)
                    return res;
            }
        }

        return res;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
