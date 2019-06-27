package array;

/**
 * 题目是说使用字符串中出现的所有字符构成的最长回文串，字符在字符串中出现的次数并不需要等于字符在回文串中出现的次数，注意理解题意。
 * 回文串有两种构成形式：1.所有字符出现次数为偶数，如aabbaa；2.最中间字符出现1次，其余的字符出现偶数次。
 * 所以可以创建数组来出现字符出现的总次数，所有出现偶数次的字符都用于构成回文串，所有出现奇数次字符-1用于构成回文串，
 * 且如果有出现奇数词的字符，再取一个放入最中间。
 */
public class $409_LongestPalindrome {
    public int longestPalindrome(String s) {
        //记录字符串中每个字符的出现个数
        int[] nums = new int[128];
        for (char c : s.toCharArray()) {
            nums[c]++;
        }

        int res = 0,oddCount = 0;
        for (int val : nums) {
            if(val % 2 == 0){
                res += val;
            }else{
                //记录是否有出现奇数次的字符
                oddCount++;
                res += val-1;
            }
        }
        return oddCount > 0? res + 1:res;
    }
}
