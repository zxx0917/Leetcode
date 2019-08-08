/**
 * 使用回溯法求出元素的全排列，加入一个计数器，当一个全排列生成时计数器+1，当计数器等于k时，则表示当前全排列是第k个排列。
 * 注意这里输入的元素都是不重复的，所以每次遍历时从1开始，如果当前元素已经在全排列中，则跳过这个元素，我们创建一个boolean[]来表示当前元素是否被访问
 */
class Solution {
    String res = "";
    int count = 0;

    public String getPermutation(int n, int k) {
        if (k == 0 || n == 0) return "";
        boolean[] flag = new boolean[n + 1];
        helper(n, k, "", flag);
        return res;
    }

    private void helper(int n, int k, String str, boolean[] flag) {
        //如果已经集齐一个全排列
        if (str.length() == n) {
            //找到第k个排列
            if (++count == k) {
                res = str;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!res.isEmpty()) return;
            if (flag[i]) continue;
            flag[i] = true;
            helper(n, k, str + i, flag);
            flag[i] = false;
        }
    }
}

public class $60_PermutationSequence {
}
