import java.util.HashMap;
import java.util.Map;


/**
 * 本题实际是求pattern每个字符和str中每个单词是否是一一对应关系（注意是双向），遍历str中的word，使用两个Map分别记录当前pattern中的字符和word的对应关系，
 * 如果出现了不同对应关系则返回false
 */
public class $290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        //key->value为字符->word
        Map<Character, String> cToStr = new HashMap<>();
        //key->value为word->字符
        Map<String, Character> strToC = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            //判断字符和单词是否一一对应
            if (cToStr.containsKey(pattern.charAt(i)) && !cToStr.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }
            //判断单词和字符是否一一对应
            if (strToC.containsKey(words[i]) && strToC.get(words[i]) != pattern.charAt(i)){
                return false;
            }
            cToStr.put(pattern.charAt(i), words[i]);
            strToC.put(words[i], pattern.charAt(i));
        }
        return true;
    }
}
