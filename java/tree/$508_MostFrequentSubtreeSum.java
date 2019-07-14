import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 *  深度优先遍历求每个子树的元素和，然后使用HashMap储存的元素和与出现的次数，最后取出出现次数最多的元素和集合即可
 */
public class $508_MostFrequentSubtreeSum {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        helper(root);
        //求出map中最大的出现次数
        Integer max = Collections.max(map.values());
        List<Integer> res = new ArrayList<>();

        //获取map中对应最大出现次数的元素和
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                res.add(key);
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        int sum = getSum(root);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(root.left);
        helper(root.right);
    }

    //获取当前数的元素和
    private int getSum(TreeNode root) {
        if (root == null) return 0;
        return getSum(root.left) + getSum(root.right) + root.val;
    }
}
