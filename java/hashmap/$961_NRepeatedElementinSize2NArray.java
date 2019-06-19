package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 第一种方法：
 * 排序数组，出现次数为N的元素有三种情况：
 * 1.元素横跨A.length/2，如[1,2,2,2,3,4]
 * 2.元素位于[0,A.length/2-1]，如[2,2,2,3,4,5]
 * 3.元素位于[A.length/2,A.length-1]，如[1,2,3,4,4,4]
 * 根据上述几种情况取A.length/2的元素即可，判断是否为N元素
 *
 * 第二种方法：
 * 因为题目中强调了有N+1个不同的元素，剩余的元素都是N元素，所以直接使用Set加入每个元素，
 * 当当前元素存在于Set表示为N元素
 */
public class $961_NRepeatedElementinSize2NArray {
    //方法1
    public int repeatedNTimes1(int[] A) {
        Arrays.sort(A);
        int n = A.length, mid = n/2;
        //判断当前元素是否为N元素
        if(A[mid] == A[mid-1] || A[mid] == A[mid+1]){
            return A[mid];
        }else{
            //表示元素为[0,A.length/2-1]
            return A[mid-1];
        }
    }

    //方法2
    public int repeatedNTimes2(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int i : A){
            if(set.contains(i))
                return i;
            set.add(i);
        }
        return -1;
    }
}
