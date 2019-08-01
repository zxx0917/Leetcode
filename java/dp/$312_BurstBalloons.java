import java.util.ArrayList;
import java.util.List;

/**
 * 动态规范，dp[i][j]表示戳破第i到第j个气球能获得的最大硬币数量，最后结果返回dp[1][nums.length]
 * 对于i~j范围内的气球，每次取第K个，将其保留到最后一个戳破，则dp[i][j]=dp[i][k-1]+dp[k+1][j]+nums[i-1]*nums[k]*nums[j+1]，每次取最大值即可
 * 状态转移方程为：dp[i][j]=Math.max(dp[i][j],dp[i][k-1]+dp[k+1][j]+nums[i-1]*nums[k]*nums[j+1])
 * 采用自底向上的方式，i~j的长度从1开始增加到n
 * 注意这里设立左右哨兵，防止出界
 */
class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        //加上左右哨兵
        list.add(0, 1);
        list.add(list.size(), 1);
        int[][] dp = new int[list.size()][list.size()];
        for (int len = 1; len <= nums.length; len++) {
            //设定下限
            for (int i = 1; i <= nums.length - len + 1; i++) {
                //设定上限
                int j = i + len - 1;
                //取i~j中每个K值
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k - 1] + dp[k + 1][j] + list.get(i - 1) * list.get(k) * list.get(j + 1));
                }
            }
        }
        return dp[1][nums.length];
    }
}

public class $312_BurstBalloons {
}
