import java.util.ArrayList;
import java.util.List;

/**
 * 采用回溯算法，当当前路径中的节点数为k时，加入结果集，注意这里相同元素的组合就算顺序不同也算是同一个，如[1,2]和[2,1]是一个组合，
 * 所以为了避免重复，递归时要从当前根节点的值之后取子节点，如当n=4、k=2时，根节点为2，则后面的子节点只能取3,4，以2为根节点的组合为[2,3]/[2,4]
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) return res;
        helper(n, k, 0, 1, new ArrayList<Integer>());
        return res;
    }

    private void helper(int n, int k, int depth, int start, List<Integer> list) {
        if (depth == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            //使用start来控制子节点的取值
            helper(n, k, depth + 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

public class $77_Combinations {
}
