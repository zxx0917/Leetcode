package array;

/**
 * 将A[i] + A[j] + i - j分为两个部分：A[i]+i和A[j]-j
 * 固定A[i]+i，在遍历过程中不断更新A[i]+i的最大值，求每个A[j]-j和A[i]+i之和的最大值
 */
public class $1014_BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int iMax = A[0] + 0, res = 0;
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, iMax + A[j] - j);
            iMax = Math.max(iMax, A[j] + j);
        }
        return res;
    }
}
