/**
 * 多维背包问题
 * dp[i][j]表示由i个0，j个1构成的字符串最大数量
 * 对于当前第k个字符串，有zero个0，one个1，则有两种情况：不拼出字符串和拼出字符串
 * dp[i][j]=Math.max(dp[i][j],dp[i-zero][j-one]+1)
 * 最后返回dp[m][n]
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int zero = 0, one = 0;
            int l = 0;
            //求出当前字符串的1/0个数
            while (l < strs[i].length()) {
                if (strs[i].charAt(l) == '1') one++;
                else zero++;
                l++;
            }
            //DP，数组复用
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

public class $474_OnesAndZeroes {
}
