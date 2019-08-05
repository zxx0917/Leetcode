/**
 * 遍历haystack，如果位置为i的字符和needle第一个字符相同，则比较i~i+needle.length之间的字符串是否等于needle，如果是，则返回i，如果不是，继续操作
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int cur = 0;
        while(cur <= haystack.length()-needle.length()){
            if(haystack.charAt(cur) == needle.charAt(0) && haystack.substring(cur,cur+needle.length()).equals(needle)){
                return cur;
            }else{
                cur++;
            }
        }
        return -1;
    }
}

public class $28_ImplementstrStr {
}
