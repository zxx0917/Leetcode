import java.util.ArrayList;
import java.util.List;

/**
 * ip地址每段在0~255之间，且不能以0作为开头，如012，这些可以作为剪枝条件
 * 因为每次分割出的自字符串需要用.拼接，所以暂时使用List来储存分段的ip地址，最后再用.拼接即可
 */
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.isEmpty()) return res;
        helper(s, 0, new ArrayList<String>());
        return res;
    }

    //pos表示当前分割的字符串位置
    private void helper(String s, int cur, List<String> list) {
        if (list.size() >= 4) {
            if(cur == s.length()) res.add(String.join(".", list));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (cur + i > s.length()) break;
            String subStr = s.substring(cur, cur + i);
            //判断ip地址是否合适
            if ((subStr.startsWith("0") && subStr.length() > 1) || (i == 3 && Integer.valueOf(subStr) > 255))
                continue;
            list.add(subStr);
            helper(s, cur + i, list);
            list.remove(list.size() - 1);
        }
    }
}

public class $93_RestoreIPAddresses {
}
