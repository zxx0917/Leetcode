// 求出0-1,0-2,0-3,...0-n的和，储存在数组中，0-n的元素和为sum[n]。
// 因此，[i,j]的元素和为sum[0,j]-sum[0,i-1]
class NumArray {
    int arr[];

    //动态规划，dp[n] = dp[n-1] + nums[n]
    public NumArray(int[] nums) {
        arr = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            arr[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i > j) return -1;
        //求[0,j]的元素和
        int sumJ = arr[j];
        if (i == 0) return sumJ;
        //求[0,i-1]的元素和
        int sumI = arr[i - 1];
        return sumJ - sumI;
    }
}

public class $303_RangeSumQueryImmutable {
}
