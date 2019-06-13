package array;

/**
 * 该题需要左边的元素均小于等于右边的元素，所以重点是找到两个数组的分界点，
 * 只要左边数组的最大值元素小于右边所有数组元素即可，因此从左至右遍历整个数组，
 * 创建两个变量保存左数组的最大值和当前遍历过所有数组的最大值，如果当前遍历元素小于左边数组的最大值，
 * 则表示该元素以及之前所有元素属于左边数组，将分界点移至当前元素，并将此元素之前所有元素的最大值赋给左数组最大值，直至遍历结束
 */
public class $915_PartitionArrayintoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        if(A.length == 0) return 0;
        int leftMax = A[0],curMax = A[0],resIndex = 0;
        for(int i = 1;i < A.length;i++){
            curMax = Math.max(A[i],curMax);
            if(leftMax > A[i]){
                leftMax = curMax;
                resIndex = i;
            }
        }
        return resIndex+1;
    }
}
