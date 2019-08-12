import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯，pos表示当前字符的位置，当pos的字符为数字时，不进行转换，如果pos的字符为字母时，可以分为两种情况：当前字符大写或当前字符小写
 * 当pos==S.length时表示到达结尾，将结果加入结果集
 */
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        helper(S.toCharArray(), 0);
        return res;
    }

    private void helper(char[] chars, int pos) {
        //到达叶子节点
        if (pos == chars.length) {
            res.add(new String(chars));
            return;
        }

        //递归到达叶子节点
        helper(chars,pos+1);
        //如果当前字符是小写字符，则转换为大写
        if(chars[pos] >= 'a' && chars[pos] <= 'z'){
            chars[pos] = Character.toUpperCase(chars[pos]);
            helper(chars,pos+1);
        }else if(chars[pos] >= 'A' && chars[pos] <= 'Z'){
            //如果当前字符是大写字符，则转换为小写
            chars[pos] = Character.toLowerCase(chars[pos]);
            helper(chars,pos+1);
        }

    }
}

public class $784_LetterCasePermutation {
}
