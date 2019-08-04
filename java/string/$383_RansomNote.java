/**
 * 题目意思是是否可以用magazine中的字符组成ransomNote，且使用字符的数量不能超过magazine中的字符数量
 * 所以创建一个字典表，首先记录magazine的字符出现次数，然后再遍历ransomNote，如果字典表中对应字符数量<=0，则返回false
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 0) return true;
        if (magazine.length() == 0) return false;
        int[] dict = new int[26];
        //构建字典表
        for (char c : magazine.toCharArray()) {
            dict[c - 'a']++;
        }
        //遍历ransomNote
        for (char c : ransomNote.toCharArray()) {
            if (dict[c - 'a'] <= 0) return false;
            dict[c - 'a']--;
        }
        return true;
    }
}

public class $383_RansomNote {
}
