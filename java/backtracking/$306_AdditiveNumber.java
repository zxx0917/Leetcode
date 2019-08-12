import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯，cur表示当前递归的字符串位置，并用一个List保存之前分割的数字
 * 剪枝条件：1，已经找到了对应的累加序列；2.当前数字不能以0开头；3.当前数字不等于前两个数之和
 */
class Solution {
    boolean flag = false;

    public boolean isAdditiveNumber(String num) {
        if (num.isEmpty()) return false;
        helper(num, 0, new ArrayList<>());
        return flag;
    }

    private void helper(String num, int cur, List<String> list) {
        //判断
        if (cur == num.length() && list.size() > 2) {
            flag = true;
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            if (flag) break;
            if (cur + i > num.length()) break;
            String subStr = num.substring(cur, cur + i);
            //当前数不能以0开头
            if (subStr.startsWith("0") && subStr.length() > 1) continue;
            //如果结果集已经有两个数，则判断前两个数相加是否为当前数
            if (list.size() >= 2) {
                if (Long.valueOf(subStr) != Long.valueOf(list.get(list.size() - 1)) + Long.valueOf(list.get(list.size() - 2)))
                    continue;
            }
            list.add(subStr);
            helper(num, cur + i, list);
            list.remove(list.size() - 1);
        }
    }
}

public class $306_AdditiveNumber {
}
