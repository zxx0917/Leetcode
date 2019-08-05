import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首先将paragraph全部转换为小写，因为单词中可能还有其他的字符，如a,b,b,a，所以将其中的非字母字符全都替换为空格
 * 将banned中的字符串放入List中，建立Map，统计paragraph中每个单词的出现次数，如果单词在banned中，不计数，最后返回出现次数最多的单词
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        Map<String, Integer> map = new HashMap<>();
        int max = 0;//统计出现的最大次数
        //替换非字符
        paragraph = paragraph.toLowerCase().replaceAll("[,|.|!|?|;|']"," ");
        //分割paragraph
        String[] words = paragraph.split(" ");
        for (String word : words) {
            //判断是否在banned
            if (word.isEmpty() || bannedList.contains(word)) continue;
            //加入Map
            map.put(word, map.getOrDefault(word, 0) + 1);
            max = Math.max(max, map.get(word));
        }
        //找出出现次数为max的单词
        for (String key : map.keySet()) {
            if (map.get(key) == max)
                return key;
        }
        return "";
    }
}

public class $819_MostCommonWord {
}
