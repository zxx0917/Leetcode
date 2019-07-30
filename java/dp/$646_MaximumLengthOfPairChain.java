import java.util.Arrays;
import java.util.Comparator;

/**
 * 有题意可知，对于两个数对(a,b)和(c,d)，当c > b时，两个数对可以连在一起
 * 考虑使用DP，dp[i]为第i个数对作为结尾的最长数对链长度。将数对先按照第一个元素排序，然后按照按照第二个元素从小到大排序，
 * 如果paris[i][0] > pairs[0~i-1][1]，则dp[i]=dp[i-1]+1
 * 注意每个dp[i]需要初始化为1，如果前面没有数对与其构成数对链，则dp[i]=1
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 0) return 0;
        //先按照第一个元素排序，然后按照按照第二个元素从小到大排序
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

public class $646_MaximumLengthOfPairChain {
}
