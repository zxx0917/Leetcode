/**
 * 0 1 2 3 4
 * -----------
 * -5 1 2 8 17
 *
 * 如上图所示，要找出i == A[i]的最小索引，因为数组是有序的，且需要查找某个数据，可以使用二分查找法。
 * 因为数组中可能不止有一个元素和索引值相同，所以需要找到相同元素的下界，这里的二分查找采用开区间[left,right)
 */
class Solution {
    public int fixedPoint(int[] A) {
        int left = 0, right = A.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == mid) {
                right = mid;
            } else if (A[mid] < mid) {
                //元素值小于索引值，增大left
                left = mid + 1;
            } else if (A[mid] > mid) {
                //元素值大于索引值，减小right
                right = mid;
            }
        }
        if (left == A.length) return -1;
        return left == A[left] ? left : -1;
    }
}

public class $1064_FixedPoint {
}
