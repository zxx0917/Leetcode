import java.util.ArrayList;
import java.util.List;


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
