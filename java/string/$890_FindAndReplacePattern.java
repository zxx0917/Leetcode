import java.util.ArrayList;
import java.util.List;

/**
 * 此题的题意是筛选出words数组中字符串与pattern中的字母是一一对应关系的字符串，
 * 如word = abc和pattern = cde，两者的映射关系为a->c/b->e/c->e，满足一一对应关系，所以abc满足条件
 * 如word = ddc和pattern = cde，两者的映射关系为d->c/d->d/c->e，d对应了两个字符，所以ddc不满足条件
 * 所以遍历每个单词，使用两个字典数组分别保存word和pattern每个字符的对应关系，如果当前字符已经有了对应关系，则不满足条件，直接跳出
 */
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int[] wordToP = new int[26];
            int[] pToWord = new int[26];
            boolean found = true;
            for (int i = 0; i < pattern.length(); i++) {
                //map中存在该字符的映射，且映射和pattern中的当前字符不同
                char wordChar = word.charAt(i), patternChar = pattern.charAt(i);
                if ((wordToP[wordChar - 'a'] != 0 && wordToP[wordChar - 'a'] != patternChar)
                        || (pToWord[patternChar - 'a'] != 0 && pToWord[patternChar - 'a'] != wordChar)) {
                    found = false;
                    continue;
                }
                wordToP[wordChar - 'a'] = patternChar;
                pToWord[patternChar - 'a'] = wordChar;
            }
            if (found) res.add(word);
        }
        return res;
    }
}

public class $890_FindAndReplacePattern {
}
