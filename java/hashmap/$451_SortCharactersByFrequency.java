package array;

import java.util.*;

/**
 * 使用map记录每个字符出现的次数，出现次数为key，对应字符为val，因为不同的字符可能出现相同次数，所以使用List来保存val.
 * 然后将map根据出现次数从大到小排列元素，然后遍历Map，将出现次数对应的字符加入结果即可。
 */
public class $451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Integer,List<Character>> map = new HashMap<>();
        //排序
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int slow = 0,fast = 0;
        while(fast < chars.length){
            while(fast < chars.length && chars[fast] == chars[slow]){
                fast++;
            }
            if(map.get(fast-slow) == null){
                map.put(fast-slow,new ArrayList<>());
            }
            List<Character> charList = map.get(fast - slow);
            charList.add(chars[slow]);
            map.put(fast-slow,charList);
            slow = fast;
        }
        //根据出现次序从大到小排序
        StringBuilder sb = new StringBuilder();
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int key : keys){
            List<Character> characterList = map.get(key);
            for(char c : characterList){
                int count = key;
                while(count > 0){
                    sb.append(c);
                    count--;
                }
            }
        }
        return sb.toString();
    }
}
