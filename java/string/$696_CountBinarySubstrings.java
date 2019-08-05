import java.util.ArrayList;
import java.util.List;

/**
 * 遍历整个字符串，记录相邻相同数的出现个数，最后遍历出现次数，相邻的两个数取最小值加入结果即可
 * 如11100110，相邻相同数为3221，结果为2+2+1=5
 */
class Solution {
    public int countBinarySubstrings(String s) {
        //记录相同数的出现次数
        int count = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) count++;
            else {
                list.add(count);
                count = 1;
            }
        }
        //加入最后的count
        list.add(count);
        //求出相邻数的最小值
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            res += Math.min(list.get(i), list.get(i - 1));
        }
        return res;
    }
}

public class $696_CountBinarySubstrings {
}
