package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $244_ShortestWordDistanceII {
}

/**
 * 将word和对应的索引位置存入map，因为word可能有相同存在，所以使用Map<String, List<Integer>>。
 * 然后根据需要查询的string获取对应的索引集，两两求出最小值即可。
 */
class WordDistance {
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        //将word和对应的位置放入map
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i]) == null) {
                map.put(words[i],new ArrayList<>());
            }
            List<Integer> list = map.get(words[i]);
            list.add(i);
            map.put(words[i],list);
        }
    }

    public int shortest(String word1, String word2) {
        //分别获取两个单词在map中的值
        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        //找出两者的最小值
        int res = Integer.MAX_VALUE;
        for(int i : word1List){
            for(int j : word2List){
                res = Math.min(res,Math.abs(i-j));
            }
        }
        return res;
    }
}
