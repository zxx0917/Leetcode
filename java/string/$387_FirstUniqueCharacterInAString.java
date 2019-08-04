/**
 * 使用一个字典表记录每个字符出现的次数，然后再遍历一次，返回第一个字典表值为1的索引
 */
class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        //1.构建字典表
        int[] dict = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            dict[c - 'a']++;
        }
        //2.获取第一个出现次数为1的索引
        for (int i = 0; i < s.length(); i++) {
            if (dict[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}

public class $387_FirstUniqueCharacterInAString {
}
