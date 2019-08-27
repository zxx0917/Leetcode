/**
 * 计算不符合非降序规则的列，累加，最后累加值就是结果
 */
class Solution {
    public int minDeletionSize(String[] A) {
        int res = 0;
        int len = A.length;
        if (len == 0) return 0;
        for (int j = 0; j < A[0].length(); j++) {
            for (int i = 0; i < len - 1; i++) {
                if (A[i].charAt(j) > A[i + 1].charAt(j)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}


public class $944_DeleteColumnsToMakeSorted {
}
