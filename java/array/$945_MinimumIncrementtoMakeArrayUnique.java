package array;

import java.util.*;

/**
 * 1.排序，[3,2,1,2,1,7]->[1,1,2,2,3,7]
 * 2.遍历：当前后元素相等时，后一个元素+1；当A[i] < A[i+1]，跳过；当A[i] > A[i+1]，后一个元素累加A[i]-A[i+1]+1，如[1,3,2] -> [1,3,4]
 * 3.创建变量来统计累加总数，即为结果。
 */
public class $945_MinimumIncrementtoMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for(int i = 0;i < A.length-1;i++){
            if(A[i] == A[i+1]){
                A[i+1] += 1;
                res++;
            }else if(A[i] > A[i+1]){
                res += A[i+1]-A[i]+1;
                A[i+1] += A[i+1]-A[i]+1;
            }
        }
        return res;
    }
}
