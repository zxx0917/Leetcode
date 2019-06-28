package array;

/**
 * 使用两个数组分别记录两个字符串中字符的映射，第一个数组记录s->t，第二个数组记录t->s
 * 然后遍历整个字符串，如果当前字符已经存在在映射数组中且映射值不为自己，则不符合要求。
 */
public class $205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        //使用数组记录两个字符串中的映射
        int[] sToT = new int[128]; //s->t
        int[] tToS = new int[128]; //t->s
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i), charT = t.charAt(i);
            //当前字符是否存在于数组中
            if ((sToT[charS] != 0 && sToT[charS] != charT) || (tToS[charT] != 0 && tToS[charT] != charS)) {
                return false;
            } else {
                sToT[charS] = charT;
                tToS[charT] = charS;
            }

        }
        return true;
    }
}

