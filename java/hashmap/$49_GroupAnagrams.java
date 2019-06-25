package array;

import java.util.*;

/**
 * 字母异位词的字符在排序后都是一样的，所以可以维护一个Map，key为单词字符排序后的值，
 * value为List，保存每个排序字符对应的词，每个List即为字符字母异位词集合。
 */
public class $49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.get(key);
            if(list == null)
                list = new ArrayList<>();
            list.add(str);
            map.put(key,list);
        }
        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
}
