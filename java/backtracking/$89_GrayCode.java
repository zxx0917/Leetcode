import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯算法：
 * 每一位只有两个可能值：0/1，由题意可知整个解可以构成完全二叉树，元素个数为2^n
 * 当当前元素为0时，下一个元素先添加0，再添加1，如果当前元素为1，则先添加1，再添加0,
 * 这里需要注意，当父节点为1，子节点也为1时，子节点优先添加0，再添加1，
 * 当父节点为1，子节点为0时，子节点优先添加1，再添加0，
 * 当递归的深度depth == n，到达叶子节点，加入结果集
 */
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        if (n < 0) return res;
        helper(0, n, "0", '0');
        return res;
    }

    private void helper(int depth, int n, String str, char parent) {
        if (depth == n) {
            //到达叶子节点，当当前二进制转换为十进制加入结果集
            res.add(Integer.valueOf(str, 2));
            return;
        }

        if (parent == '0') {
            //先添加0，再添加1
            helper(depth + 1, n, str + "0", '0');
            helper(depth + 1, n, str + "1", '1');
        } else {
            //先添加1，再添加0
            helper(depth + 1, n, str + "1", '0');
            helper(depth + 1, n, str + "0", '1');
        }
    }
}

public class $89_GrayCode {
}
