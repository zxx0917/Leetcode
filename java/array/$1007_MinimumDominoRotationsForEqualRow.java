package array;

/**
 * 因为数字只有1~6，累积A和B中元素出现的次数，如果有数字的出现次数>=数组长度，
 * 则表示可以旋转，统计这个数字在数组A中的出现次数countA，则数组B中需要旋转的次数为数组长度-countA，
 * 然后再统计这个数字在数组B中出现的次数countB，求出数组A需要旋转的次数，最后求两个旋转次数的最小值
 */
public class $1007_MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int[] flag = new int[7];
        for (int i = 0; i < A.length; i++) {
            flag[A[i]]++;
            //注意去重
            if (A[i] != B[i])
                flag[B[i]]++;
        }

        int res = -1;
        for (int i = 1; i < 7; i++) {
            if (flag[i] >= A.length) {
                //累积i在数组A中的出现次数
                int countA = 0;
                for (int num : A) {
                    if (num == i) {
                        countA++;
                    }
                }
                //累积在数组B中的出现次数
                int countB = 0;
                for (int num : B) {
                    if (num == i)
                        countB++;
                }
                res = Math.min(A.length - countA, A.length - countB);
            }
        }
        return res;
    }
}