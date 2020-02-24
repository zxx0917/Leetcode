import java.util.Arrays;

/**
 * 这道题和167题两数之和是一个类型的题，不过这道题是求出最接近K值的和，故参考167题的解法，即数组排序+双指针。
 * 首先对数组进行排序，数字从小到大排列，然后我们建立两个指针left/right，分别表示数组中第一个元素的索引和最后一个元素的索引。
 * nums[left]指代数组中最小的值，nums[right]指代数组中最大的值，将这两个值相加，与target比较，如果大于target，则减小较大的数，
 * 即将right左移一位，如果小于target，则当前和有可能是结果。因为一个数组中可能有多个小于target的和，所以创建一个变量res用于
 * 储存当前小于target的最大和，最后返回res即可。
 * 这里注意有一种情况是数组中没有最小和，我们则将res初始化为Integer.MIN_VALUE，如果循环后res的值依旧为Integer.MIN_VALUE，
 * 则表示没有结果，返回-1。
 */
public class $1099_TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        if (A.length == 0) return -1;
        //1.排序
        Arrays.sort(A);
        //2.使用双指针，从两侧逼近中心
        int left = 0, right = A.length - 1, res = Integer.MIN_VALUE;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum >= K) {
                right--;
            } else {
                res = Math.max(res, A[left] + A[right]);
                left++;
            }
        }

        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
