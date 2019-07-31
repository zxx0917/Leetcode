import java.util.Arrays;

/**
 * 状态：dp[i][j]表示从第一个元素为A[i]、第二个元素为A[j]的斐波那契子序列的长度，如[1,2,3,4,5,8]，因为1+2=3，所以dp[2][3]=3；2+3=5，所以dp[2][5]=dp[2][3]+1=4
 * 状态转移方程：对于A[j]，因为0~j-1的元素是递增的，所以创建两个指针，分别指向最小值(left)和最大值(right)，如果A[left]+A[right]=A[j]，则A[right][j]=A[left][right]+1，
 * 如果A[left]+A[right]>A[j]，缩小大值，right--；如果A[left]+A[right]<A[j]，增加小值，left++
 * 初始化：所有数组初始化为2
 * 结果：返回dp[0][j]，如果结果大于等于3，返回dp[0][j]，否则返回0
 */
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int len = A.length;
        if (len == 0) return 0;
        int[][] dp = new int[len][len];
        //初始化
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], 2);
        }
        //开始DP
        int res = 0;
        for (int j = 2; j < len; j++) {
            int left = 0, right = j - 1;
            while (left < right) {
                if (A[left] + A[right] == A[j]) {
                    dp[right][j] = Math.max(dp[left][right] + 1, dp[right][j]);
                    res = Math.max(res, dp[right][j]);
                    left++;
                    right--;
                } else if (A[left] + A[right] > A[j]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res >= 3 ? res : 0;
    }
}

public class $873_LengthOfLongestFibonacciSubsequence {
}
