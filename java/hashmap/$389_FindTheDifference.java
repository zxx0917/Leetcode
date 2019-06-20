package array;

/**
 * 有两种方法：
 * 方法1：使用数组，保存s中出现的字符次数，然后遍历t中的字符，
 * 在数组中减去出现的字符次数，最后哪个元素值为-1就是被添加的字母；
 * 方法2：因为t中只比s多了一个字符，所以可以使用异或，a^a^b = b，最后留下的字符就是被添加的字母。
 */
public class $389_FindTheDifference {
    //方法1：字典表
    public char findTheDifference1(String s, String t) {
        int[] dic = new int[26];
        for (char c : s.toCharArray()) {
            dic[c - 'a']++;
        }
        //
        for(char c : t.toCharArray()){
            dic[c-'a']--;
            if(dic[c-'a'] == -1)
                return c;
        }
        return ' ';
    }
    //方法2：异或
    class Solution {
        public char findTheDifference2(String s, String t) {
            char res = 0;
            for(char c : s.toCharArray()){
                res ^= c;
            }
            for(char c : t.toCharArray()){
                res ^= c;
            }
            return res;
        }
    }
}
