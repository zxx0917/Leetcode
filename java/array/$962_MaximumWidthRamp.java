package array;

/**
 * 根据题意是要求出A[i]<=A[j]下最大的j-i距离，可以使用窗口法，一开始窗口设置为最大宽度，
 * 如果有满足条件的j,i直接返回，如果没有缩小窗口距离，继续求值
 */
public class $962_MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        int n = A.length,winLength = n-1;
        while(winLength > 0){
            int left = 0;
            int right = winLength;

            while(right < n){
                if(A[left] <= A[right]){
                    //表示找到
                    return right-left;
                }else{
                    left++;
                    right++;
                }
            }

            //当前窗口宽度已经搜索完，将宽度缩小一个继续搜索
            winLength--;
        }
        return 0;
    }
}
