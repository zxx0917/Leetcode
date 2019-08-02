import java.util.HashSet;
import java.util.Set;

/**
 * 创建字典表，index为0~25，保存对应的摩斯码，创建一个Set，储存翻译好的字符串，利用Set的特性去重，最后返回Set的值即可
 */
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        if (words.length == 0) return 0;
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            //翻译每个单词
            for (char c : word.toCharArray()) {
                sb.append(dict[c - 'a']);
            }
            set.add(sb.toString());
            //清空
            sb.delete(0, sb.length());
        }
        return set.size();
    }
}

public class $804_UniqueMorseCodeWords {
}
