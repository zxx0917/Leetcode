/**
 * 题目意思有点难读懂，
 * 对于"ax"和"axehd"，"ax"的最长子序列为"ax"，但是"axehd"中有"ax"子序列，所以不是独有的，对于"ax"的子序列"a"和"x"，在"axehd"都存在，均不是独有，所以返回"axehd"的最长子序列，即"axehd"
 * 其实就是如果两个字符串完全相同，则返回-1，如果不相同，则返回最长字符串的长度
 */
class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return a.length() > b.length() ? b.length() : a.length();
    }
}

public class $521_LongestUncommonSubsequenceI {
}
