//dp[i][j]表示从i到j是否为回文字符串，如果j-i<=2且s[j] == s[i]为true，如果j-i>2，且s[j]==s[i]&&dp[i+1][j-1]为true
class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        //注意要从尾往前构建，否则会遗漏情况
        for (int i = chars.length-1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}

public class $647_PalindromicSubstrings {
}
