package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 注意：不常见的单词就是在两个句子中只出现一次的单词，例如"apple apple"，"banana"，
 * apple因为在第一个句子中出现了两次，所以也为常见单词
 *
 * 使用Map记录A和B中出现的单词以及次数，如果出现次数等于1，则加入结果集
 */
public class $884_UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : A.split(" ")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String s : B.split(" ")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        List<String> res = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == 1)
                res.add(key);
        }
        return res.toArray(new String[res.size()]);
    }
}
}
