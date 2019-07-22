//第一根柱子颜色有k种涂法，第二个栏杆有k*k种涂法，第三个柱子有两种情况：1.第三个柱子和第二个栏杆颜色相同，与第一个栏杆颜色不同，
//则有k*k*(k-1)种涂法；2.如果第三根柱子和第二个不同，则有k*(k-1)中，第三种柱子总的涂色方法有(dp[2]+dp[1])*(k-1)中
class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k * k;
        for(int i = 3;i <= n;i++){
            dp[i] = (dp[i-2] + dp[i-1]) * (k-1);
        }
        return dp[n];
    }
}

public class $276_PaintFence {
}
