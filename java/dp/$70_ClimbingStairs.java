//对于最后一次爬到顶，可以从n-2跨两步到顶，也可以从n-1跨一步到顶，所以f(n)=f(n-2)+f(n-1+
//对于边界条件：爬到第1阶有一种爬法，f(1)=1，爬到第二阶有f(2)=2种爬法，即0->1->2，0->2
//状态转移方程为：dp[n]=dp[n-1]+dp[n-2]
class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return a + b;
    }
}

public class $70_ClimbingStairs {
}
