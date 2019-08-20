/**
 * 首先了解中位数的概念：一个有序数组的中位数将数组分为元素数量相等的两个部分，其中左边数组的最大值永远小于右边数组的最小值
 * 所以在两个数组分别设置指针i,j，i、j左边的元素为大数组中位数左边的元素，右边的元素为大数组中位数右边的元素
 * 假设两个大数组的长度分别为m、n，为了让大数组左右两部分长度相同，则i+j=(m+n+1)/2 ，所以只要找到i就可以固定j了
 * 对于i的取值，使用二分法来获取，判断找到i/j的条件为：nums1[i-1] <= nums[j] && nums[i] >= nums[j-1]
 * 对于二分法的mid，如果nums[mid] < nums[j-1]，则表示mid太小，left = mid+1；
 * 如果nums[mid-1] > nums[j]，表示mid太大，right = mid-1;
 * 如果大数组是奇数，则中位数为Math.max(A[i-1],B[j-1])，如果是偶数，则中位数为(Math.max(A[i],B[j])+Math.max(A[i-1],B[j-1]))/2
 */
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        //让A指向长度小的数组，防止B超限，且搜索次数变小
        if (A.length > B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        int m = A.length, n = B.length;
        //二分法找到A中i的位置
        int start = 0, end = m;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            //求出j
            int j = ((m + n + 1) >> 1) - mid;
            //判断mid是否合适
            if (mid < m && A[mid] < B[j - 1]) {
                start = mid + 1;
            } else if (mid > 0 && j < n && A[mid - 1] > B[j]) {
                end = mid;
            } else {
                //找到合适的位置
                int maxLeft;//大数组左边的中位数
                //如果到达边界
                if (mid == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[mid - 1];
                } else {
                    //取两者的最大值
                    maxLeft = Math.max(A[mid - 1], B[j - 1]);
                }
                //如果是奇数，直接返回
                if (((m + n) & 1) != 0) {
                    return maxLeft;
                }
                int maxRight;
                //如果是偶数，还需要求右边的中位数
                if (mid == m) {
                    maxRight = B[j];
                } else if (j == n) {
                    maxRight = A[mid];
                } else {
                    maxRight = Math.min(A[mid], B[j]);
                }
                return (double) (maxLeft + maxRight) / 2;
            }
        }
        return 0.0;
    }
}

public class $4_MedianOfTwoSortedArrays {
}
