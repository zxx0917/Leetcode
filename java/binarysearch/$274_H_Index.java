import java.util.Arrays;

/**
 * 二分法，同275题
 */
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
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

public class $274_H_Index {
}
