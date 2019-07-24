/**
 * dp[i]表示第i个字符形成的解码数量，分为两种情况，dp[i][0]表示包括前一个元素，dp[i][1]表示不包括前一个元素
 * 最后返回dp[i][0]+dp[i][1]即可
 * 对于是否能够与前面一个数字组成解码，需要判断与前一个元素的组成数字在[10,26]之间，否则dp[i][0]=0
 * 这里需要注意当前元素为'0'的情况，'0'不能解码，只有可能和前一个数组成有效解码，所以dp[i][1] = 0
 * 公式如下：dp[i][0] = dp[i-2][0] + dp[i-2][0];dp[i][1] = dp[i-1][0] + dp[i-1][0]
 * 即如果当前字符可以和前一个字符组成解码，则两者只有一种情况，这时需要求出第i-2个字符形成的解码数量，dp[i][0]为1*i-2元素可以形成的解码数量总和
 * 如2226，对于"6"，可以和前一个元素形成"26"，则总共的解码情况为2 2 26/22 26
 */
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[][] dp = new int[s.length()][2];
        if (s.startsWith("0")) return 0;
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < s.length(); i++) {
            char front = s.charAt(i - 1), behind = s.charAt(i);
            if ((front == '2' && behind <= '6') || front == '1'){
                if (i >= 2) dp[i][0] = dp[i - 2][0] + dp[i - 2][1];
                else dp[i][0] = 1;
            }
            if (behind != '0') dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }
        return dp[s.length() - 1][0] + dp[s.length() - 1][1];
    }
}

public class $91_DecodeWays {
}
