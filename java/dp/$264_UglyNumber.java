/**
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12是前10位的丑数，可以观察到后面的丑数都是前面的丑数与2/3/5的乘积，
 * 为了按照顺序排列，使用三个指针指代需要相乘的前丑数，比较这三个乘积的最小值作为新丑数，被选中的乘数指针+1
 * 使用dp[i]表示第i个丑数
 */
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int tmp = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            //插入指定位置
            dp[i] = tmp;
            //调换指针位置
            if (dp[p3] * 3 == tmp) p3++;
            if (dp[p2] * 2 == tmp) p2++;
            if (dp[p5] * 5 == tmp) p5++;
        }
        return dp[n - 1];
    }
}
public class $264_UglyNumber {
}
