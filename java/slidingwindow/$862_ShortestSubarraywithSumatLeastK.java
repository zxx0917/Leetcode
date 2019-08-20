/**
 * 使用滑动窗口，left指示窗口的左边，right指示窗口的右边，逐步扩大窗口范围，分为以下几种情况：
 * 1.如果当前元素>=K，直接返回1，因为不需要其他数组元素
 * 2.计算窗口元素的和sum，如果sum<=0，因为K为整数，所以当前窗口中的元素对结果没有贡献，删除当前窗口
 * 3.如果窗口元素的和>=K，则尝试增加left，缩小窗口的大小，然后求出窗口大小更新结果
 * 这里注意如果在窗口内有一连串的负数，需要将处理当前负数，将负数加到前面的元素去，有利于后续的窗口缩小，
 * 如数组[2,2,-1,-1,-1]，当left索引为0、right索引为2时，数组转变为[2,1,0,-1,-1]，这样窗口内和不变，但是窗口缩小只用考虑元素为正数的情况，更加方便
 */
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int left = 0, res = Integer.MAX_VALUE, sum = 0;
        for (int right = 0; right < A.length; right++) {
            //如果单个元素大于K
            if (A[right] >= K) return 1;
            //求窗口和
            sum += A[right];
            //如果窗口和为非正数，删除此窗口
            if (sum < 0) {
                sum = 0;
                left = right + 1;
                continue;
            }
            //将数组中的负数元素转换为非负数
            for (int j = right - 1; A[j + 1] < 0; j--) {
                A[j] += A[j + 1];
                A[j + 1] = 0;
            }
            //如果窗口和大于等于K，则视图缩小窗口宽度
            if (sum >= K) {
                while (sum - A[left] >= K) {
                    sum -= A[left++];
                }
                //更新结果
                res = Math.min(res, right - left + 1);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

public class $862_ShortestSubarraywithSumatLeastK {
}
