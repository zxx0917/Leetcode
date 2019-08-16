/**
 * 题目要求对数时间复杂度，且数组已经排好序，则考虑使用二分法
 * 例如[0,1,2,3,5,6]，对于中位数2，c[2]是不符合h指数定义的，因为如果h指数为2，则数组中最多只有2篇文章至少引用了2次，
 * 而实际上有4篇文章至少引用了2次，所以对于c[mid]，至少引用了c[mid]次的文章篇数为c.length-mid
 * 所以，如果c[mid]<c.length-mid，则h指数一定在右边，left=mid+1，反之h指数在左边，right = mid;
 * 最后的h指数为c.length-mid
 */
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        // 特判
        if (len == 0 || citations[len - 1] == 0) {
            return 0;
        }

        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return len - left;
    }
}

public class $275_H_IndexII {
}
