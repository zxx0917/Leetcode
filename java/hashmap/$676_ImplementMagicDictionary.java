package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $676_ImplementMagicDictionary {
}

/**
 * 要"判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。"，两个词必须是等长的，
 * 所以创建一个Map，key为单词的长度，value为对应长度的单词List，
 * 根据输入的单词长度来逐个比较字典中的单词不同的字符数只为1.
 */
class MagicDictionary {
    Map<Integer, List<String>> map;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        //按照单词的长度放入map中
        for (String str : dict) {
            int len = str.length();
            List<String> list = map.get(len);
            if (list == null) list = new ArrayList<>();
            list.add(str);
            map.put(len,list);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        //找到word相同长度的单词
        List<String> list = map.get(word.length());
        if(list == null)
            return false;
        for(String str : list){
            int count = 0;
            for(int i = 0;i < str.length();i++){
                if(str.charAt(i) != word.charAt(i))
                    count++;
                if(count > 1)
                    break;
            }
            if(count == 1) return true;
        }
        return false;
    }
}