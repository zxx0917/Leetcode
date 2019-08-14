/**
 * 依照题意，峰顶就是最大值，可以直接从左至右遍历元素找到第一个A[i]>A[i+1]，即为最大值，时间复杂度为O(n)
 * 当然也可以使用O(logN)的二分法
 * 因为整个数组只有一个最大值，所以取中点mid，如果A[mid]<A[mid+1]，则最大值一定在[mid+1,right]之间，
 * 如果A[mid]>A[mid+1]，则最大值一定在[left,mid]之间，当遍历结束，返回left即为最大值
 */
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else if (A[mid] > A[mid + 1]) {
                right = mid;
            }
        }
        return left;
    }
}

public class $852_PeakIndexInAMountainArray {
}
