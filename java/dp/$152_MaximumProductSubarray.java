//使用dp，imax表示当前i元素的最大乘积，当前元素要不是前一个元素最大乘积序列的一部分，要不它自己就是最大乘积，所以imax = Math.max(imax*nums[i],nums[i])
//如果当前元素为负数，会使最大乘积变为最小值，最小乘积变为最大值，所以需要维护一个imin，表示当前i元素的最小乘积，imin = Math.min(imin,imin*num[i])
//当nums[i]<0时，交换imax和imin的值，然后再继续求值。
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int res = nums[0];
        int imax = nums[0], imin = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            res = Math.max(res, imax);
        }
        return res;
    }
}

public class $152_MaximumProductSubarray {
}
