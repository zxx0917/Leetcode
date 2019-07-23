import java.util.List;

// 因为递归超时，所以考虑使用动态规划，对于在i行j列的元素，其下一层的相邻元素在i+1行j列和i+1行j+1列
// 1.自顶向下
// 使用dp[i][j]来保存第i行第j列的最小路径和，dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+list.get(i).get(j)，这里需要考虑j的边界
// 取最后一个数组的最小值就是结果
// 可以看到这种方法每次需要判定是否超过了上一层的边界，比较麻烦，所以可以优化一下，自底向上动态规划
// 2.自底向上
// 用dp[i][j]来保存第i行第j列的最小路径和，dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
// 这样就不用考虑边界情况
class Solution1 {
    //2.自底向上
    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) return 0;
        int[][] dp = new int[row][];
        //初始化最后一行
        dp[row - 1] = new int[triangle.get(row - 1).size()];
        for (int j = 0; j < dp[row - 1].length; j++) {
            dp[row - 1][j] = triangle.get(row - 1).get(j);
        }

        for (int i = row - 2; i >= 0; i--) {
            dp[i] = new int[triangle.get(i).size()];
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    //1.自顶向下
    public int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) return 0;
        int[][] dp = new int[row][];
        dp[0] = new int[1];
        dp[0][0] = triangle.get(0).get(0);
        //从第二行开始
        for (int i = 1; i < row; i++) {
            dp[i] = new int[triangle.get(i).size()];
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //看是否是边界元素
                int upperCol = triangle.get(i - 1).size();
                if (j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j > upperCol - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    //不超边界
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int num : dp[row - 1]) {
            res = Math.min(res, num);
        }
        return res;
    }
}

public class $120_Triangle {
}
