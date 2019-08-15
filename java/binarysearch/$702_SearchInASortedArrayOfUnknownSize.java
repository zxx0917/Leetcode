/**
 * 首先需要确定数组的长度，然后再使用二分法查找target
 * 因为题目已经给出了数组元素的域为[-9999,9999]，且每个数组元素不相同，所以数组最多有9999*2+1个元素
 * 先使用ArrayReader.get()找到数组长度，然后再二分
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        //1.二分法找到数组长度
        int left = 0, right = 19999;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == Integer.MAX_VALUE) {
                //数组长度小于于mid，缩小right
                right = mid - 1;
            } else {
                //数组长度大于等于，扩大Left
                left = mid + 1;
            }
        }

        //2.根据数组长度使用二分法查找target
        right = left;
        left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                right = mid - 1;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}

public class $702_SearchInASortedArrayOfUnknownSize {
}
