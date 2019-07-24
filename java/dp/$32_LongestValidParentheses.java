/**
 *   1.DP
 *   使用dp[i]表示i位置的有效括号的最大长度。
 *   可知'('的最大长度一定为0
 *   如果i为')'，则分为两种情况：
 *   1.i-1为'('，则()是有效长度，dp[i]=dp[i-2]+2
 *   2.i-1为')'，如果i为有效长度的一部分，则在前面一定有对应的'('，位置为i - dp[i - 1] - 1
 *   dp[i-1]+2为dp[i]的一部分。而i对应的'('的前面一个字符的最大长度也是dp[i]的一部分，这里注意不要越界
 *   dp[i] = dp[i-1]+2+dp[i-dp[i-1]-2]
 *
 */
class Solution {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) return 0;
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(')
                    dp[i] = dp[i >= 2 ? i - 2 : 0] + 2;
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2 >= 0 ? i - dp[i - 1] - 2 : 0];
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}

public class $32_LongestValidParentheses {
}
