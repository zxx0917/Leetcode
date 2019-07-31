import java.util.List;

/**
 * 状态：dp[i]表示从头到第i个字符的字符串是否可以拆分
 *
 * 状态转移方程：从第i个字符开始，往前遍历，如果dp[j]为true，则判断[j+1~i]是否在字典中，如果在，则dp[i]=true
 *
 * 初始化：当s为空字符串时，是可以拆分的，dp[0]=true
 *
 * 结果：返回dp[s.length]
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        if (len == 0) return true;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        //初始化
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
public class $139_WordBreak {
}
