import java.util.ArrayList;
import java.util.List;

/**
* 使用回溯算法，从2开始计算因子，这里注意需要去重，如对于12，其中一个因子集合为2,2,3，还有一个重复的集合为2,3,2，所以加入的因子必须大于等于集合中最后一个因子
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        helper(n, new ArrayList<>());
        return res;
    }

    private void helper(int n, List<Integer> list) {
        if (n == 1 && list.size() > 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 2; i <= n; i++) {
            //如果当前i不是n的因子，剪枝
            if (n % i != 0) continue;
            //去重：加入的因子必须大于等于集合中最后一个因子
            if (list.size() > 0 && list.get(list.size() - 1) > i) continue;
            list.add(i);
            helper(n / i, list);
            //回退
            list.remove(list.size() - 1);
        }
    }
}

public class $254_FactorCombinations {
}
