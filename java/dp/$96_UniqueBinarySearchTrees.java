//使用动态规划，dp[i]表示节点数为i时构成的子树个数，可以逐步将i-1个子节点添加到左子树上来计算子树个数：
//dp[i] = 1 * dp[i-1] + dp[1] * dp[i-2] + dp[2] * dp[i-3] + ... + dp[i-1] * 1;
class Solution {
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int num = i;
            while (--num >= 0) {
                dp[i] += dp[num] * dp[i-num-1];
            }
        }
        return dp[n];
    }
}

public class $96_UniqueBinarySearchTrees {
}
