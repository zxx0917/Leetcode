import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯算法。
 * 注意只有一个字符的字符串也是回文串
 * 所以设定一个变量cur指代当前递归的字符串位置，如果当前字符是回文串，则加入结果集，如果不是直接continue。
 * 当cur==s.length()时表示已找到一个结果，加入结果集
 */
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) return res;
        helper(s, new ArrayList<>(), 0);
        return res;
    }

    private void helper(String s, List<String> list, int cur) {
        if (cur == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (cur + i > s.length()) break;
            String subStr = s.substring(cur, cur + i);
            if (!isPalindrome(subStr)) continue;
            //加入当前回文串
            list.add(subStr);
            helper(s, list, cur + i);
            //回退
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String subStr) {
        if (subStr.length() == 1) return true;
        char[] chars = subStr.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1])
                return false;
        }
        return true;
    }
}

public class $131_PalindromePartitioning {
}
