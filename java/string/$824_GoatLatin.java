import java.util.Arrays;
import java.util.List;

/**
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 * <p>
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 * <p>
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 */
class Solution {
    public String toGoatLatin(String S) {
        if (S.length() == 0) return "";
        List<Character> dict = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        String[] fields = S.split(" ");
        StringBuilder sb = new StringBuilder();
        //遍历所有单词
        for (int i = 0; i < fields.length; i++) {
            String word = fields[i];
            //当前单词需要在结尾加上的a
            String aStr = "";
            int count = i + 1;
            while (count-- > 0) aStr += "a";
            //1.如果首字母为元音
            if (dict.contains(word.charAt(0))) word = word + "ma" + aStr;
                //2.如果为辅音
            else {
                String firstStr = word.substring(0, 1);
                word = word.substring(1, word.length()) + firstStr + "ma" + aStr;
            }
            sb.append(word).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}

public class $824_GoatLatin {
}
