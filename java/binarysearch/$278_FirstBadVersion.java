/**
 * 对于[1..n]个版本，其中一个版本出错后后面的都为错，可以通过系统提供的方法bool isBadVersion(version)判断当前选定的版本号是否出错
 * 所以可以使用二分法在[1...n]中查找错误的版本号，对于中间版本号mid，如果mid出错，则出错的版本一定在[1,mid]中，如果mid没有出错，则出错的版本一定在[mid+1,n]中
 * 这里的二分法选取开区间[left,right)，获取下界元素
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

public class $278_FirstBadVersion {
}
