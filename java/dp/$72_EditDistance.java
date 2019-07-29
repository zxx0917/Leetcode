/**
 * 使用dp[i][j]表示从0~i的word1转变为0~j的word2需要的步骤的最小值，最后直接返回dp[word1.length][word2.length]即可
 * 对于边界条件：当i=0，即word1为空字符串时，dp[0][j] = word2.sub(0,j).length，即对应word2的长度
 * 当j=0，即Word2为空字符串时，dp[i][0]=word1.sub(0,i).length，即对应word1的长度
 * 当到达最后一步horse->ros，如果存在horse->ro的步骤，则在ro上直接添加s就可以达成目标，dp[i][j]=dp[i][j-1]+1
 * 如果存在hors->ros的步骤，则在horse上直接删除可达到目标，即dp[i][j]=dp[i-1][j]+1
 * 如果存在hors->ro的步骤，直接将horse的e替换为s即可达到目标，dp[i][j]=dp[i-1][j-1]+1
 * 综上 dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])+1
 * 特殊情况：如果word1.charAt(i)==word2.charAt(j)，不需要修改，dp[i][j]=dp[i-1][j-1]
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //初始化
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        //dp
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

public class $72_EditDistance {
}
