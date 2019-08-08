import java.util.ArrayList;
import java.util.List;

/**
 * 形成有效括号的前提是先输出左括号，再输出有括号，所以这里采用回溯算法，递归的函数使用两个变量来记录左括号和右括号的数量，
 * 如果左括号数或右括号数大于n，或右括号数>左括号数，则返回，如果等于n，则加入结果集
 */
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        helper(0, 0, "", n);
        return res;
    }

    private void helper(int leftCount, int rightCount, String str, int n) {
        if (leftCount > n || rightCount > n || rightCount > leftCount) return;
        if (leftCount == n && rightCount == n) {
            res.add(str);
            return;
        }
        helper(leftCount + 1, rightCount, str + "(", n);
        helper(leftCount, rightCount + 1, str + ")", n);
    }
}

public class $22_GenerateParentheses {
}
