/**
 * 1 2 3 4 5 6 7 8  9  10
 * 1 2 3 4 5 6 9 12 16 20
 * dp[i]表示连续按键i次最多显示的A数
 * 对于N<=5，使用复制粘贴的开销大于直接输入A的开销，所以直接返回N
 * 对于N>5，使用复制粘贴的效率高于直接输入A。对于“选中”、“复制”，需要2次操作，“粘贴”至少需要一次操作，建立第二层循环，j表示粘贴的次数，比较当前
 * N可以得到A的最大次数，就是dp[i]的值，即键入A的操作次数为i-2-j，dp[i] = Math.max(dp[i], dp[i - 2 - j] * (j + 1));
 * dp[i] = Math.max(dp[i-2-j]*(j+1))，j属于[1,i-3]
 */
class Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        if (N <= 5) return N;
        //初始化
        for (int i = 1; i <= 5; i++) {
            dp[i] = i;
        }
        //开始dp
        for (int i = 6; i <= N; i++) {
            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], dp[i - 2 - j] * (j + 1));
            }
        }
        return dp[N];
    }
}

public class $651_4KeysKeyboard {
}
