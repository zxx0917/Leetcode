package array;

/**
 * 本题所有矩阵元素是升序的，所以可以直接对所有元素进行二分查找，时间复杂度为O(log(m*n))
 */
public class $74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] nums, int target) {
        int m = nums.length;
        if(m == 0) return false;
        int lo = 0,hi = nums[0].length*m-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            //得到当前mid元素在矩阵中的位置
            int row = mid/nums[0].length,col = mid%nums[0].length;
            if(nums[row][col] == target){
                return true;
            }else if(nums[row][col] < target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return false;
    }
}
