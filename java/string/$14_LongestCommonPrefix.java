/**
 * 获取每个字符串，比较当前单词和上个单词的共同前缀，最后返回结果
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //比较当前单词和当前共同前缀的共同前缀
            int count = 0, len = strs[i].length() > res.length() ? res.length() : strs[i].length();
            for (int j = 0; j < len; j++) {
                if (res.charAt(j) == strs[i].charAt(j)) count++;
                else break;
            }
            res = res.substring(0, count);
        }
        return res;
    }
}

public class $14_LongestCommonPrefix {
}
