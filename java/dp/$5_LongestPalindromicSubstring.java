/**
 * 动态规划，dp[i][j]表示从i~j的字符串是否是回文串。
 * 当char[i] == char[j] && (j-i<=2 || dp[i+1][j-1]是回文串)时为true
 * char[i] == char[j] && j-i<=2对应的情况是三个字符之内的回文串，例如：a、aa、aba
 * char[i] == char[j] && dp[i+1][j-1]对应的是四个字符以上的回文串，如abcba，只要最外层元素相同且子字符串是回文串，则一定是回文串
 * 创建一个变量来记录最长回文串，最后返回即可
 * 这里需要注意动态规划中的i一定要小于定于j，所以可以从字符串末尾定下i，保证不会有情况遗漏
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length();j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}

public class $5_LongestPalindromicSubstring {
}
