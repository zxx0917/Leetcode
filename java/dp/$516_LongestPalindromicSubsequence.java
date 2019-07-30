/**
 * dp[i][j]表示从i~j的子字符串中回文串的最大长度
 * 当i==j，dp[i][j]=1
 * 当char[i]==char[j]，dp[i][j]=dp[i+1][j-1]+2
 * 当char[i]!=char[j]，dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])
 * 最后返回dp[0][s.length-1]即可
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }
}

public class $516_LongestPalindromicSubsequence {
}
