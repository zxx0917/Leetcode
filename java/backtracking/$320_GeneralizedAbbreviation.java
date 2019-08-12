import java.util.ArrayList;
import java.util.List;

/**
 * 典型的回溯题
 * 缩写的规律为：一个字符->1，相邻的两个字符->2...相邻的n个字符->n
 * 对于当前字符，有两种情况：不缩写或者缩写成数字
 * 设置三个变量：1.当前字符串的位置pos 2.结果字符串str 3.缩写的字符数count
 * 当pos == word.length时，为终止条件
 */
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateAbbreviations(String word) {
        helper(word, "", 0, 0);
        return res;
    }

    private void helper(String word, String str, int pos, int count) {
        if (pos == word.length()) {
            if (count > 0) {
                str += count;
            }
            res.add(str);
            return;
        }

        //1.缩写当前字符
        helper(word, str, pos + 1, count + 1);
        //2.不缩写当前字符
        if (count > 0) str += count;
        str += word.charAt(pos);
        helper(word, str, pos + 1, 0);
    }
}


public class $320_GeneralizedAbbreviation {
}
