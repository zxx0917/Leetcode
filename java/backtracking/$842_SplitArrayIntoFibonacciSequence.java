import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯算法，剪枝的条件有三个：如果前两个数之和不等于当前数，则剪枝；如果当前数字以0开头，则剪枝；如果当前的子字符超过了整数最大值，则剪枝
 * 每次递归时使用一个List来保存已经拆分好的斐波那契式序列，pos表示当前递归字符的位置
 * 当pos==S.length()时且List有三个以上元素则递归结束
 * 因为字符串可能不止有一个结果，所以将递归函数的返回值设置为boolean，方便有结果时直接返回，不再继续递归
 */
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        helper(S, res, 0);
        return res;
    }

    private boolean helper(String s, List<Integer> list, int pos) {
        //因为斐波拉契数组至少为3个元素，找到后直接返回true
        if (pos == s.length() && list.size() > 2) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (pos + i > s.length()) break;
            String subStr = s.substring(pos, pos + i);
//剪枝条件1：数字以0开头
            if (subStr.startsWith("0") && subStr.length() > 1) continue;
            //剪枝条件2：当前字符串不能超过Integer的最大值
            if (Long.valueOf(subStr) > Integer.MAX_VALUE) break;
            //剪枝条件3：当前数不等于前两个数之和
            if (list.size() >= 2 && Integer.valueOf(subStr) != list.get(list.size() - 1) + list.get(list.size() - 2))
                continue;
            //将当前值加入结果集
            list.add(Integer.valueOf(subStr));
            //递归，找到一个结果就返回
            if (helper(s, list, pos + i)) return true;
            list.remove(list.size() - 1);
        }
        return false;
    }
}

public class $842_SplitArrayIntoFibonacciSequence {
}
