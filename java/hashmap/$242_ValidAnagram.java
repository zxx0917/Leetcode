package array;

/**
 * 题中异位词为两个词字母出现次数相同，字母顺序可同可不同，
 * 如aa和aa也是异位词。
 * 所以可以创建一个字典表记录一个字符串中字符出现的次数，再将另一个字符串字符出现的次数从数组中减去。
 * 如果字典表中有元素不为0，则表示两者不为异位词。
 */
public class $242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        //1.先判断两个字符串中字符出现次数是否相同
        int[] flags = new int[26];
        for (char c : s.toCharArray()) {
            flags[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            flags[c - 'a']--;
        }
        //遍历数组，判断元素值是否都为0
        for (int i : flags) {
            if (i != 0) return false;
        }
        //2.再判断两个字符串是否相等
        return true;
    }
}
