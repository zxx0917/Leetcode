import java.util.*;

/**
 * 首先创建Map记录每个单词出现的次数，然后创建优先队列，根据题目排序规则定义Comparator，最后加入Map的key值，取优先队列前k个元素即为结果
 */
public class $692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        //创建一个Map，记录每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //使用优先队列，通过出现次数排列单词
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //1.如果word出现频率相同，按照字母顺序排序
                if (map.get(o1) == map.get(o2)) {
                    return o1.compareTo(o2);
                }
                //2.按照出现频率从大到小排序
                return map.get(o2) - map.get(o1);
            }
        });

        //3.往优先队列插入元素
        for (String key : map.keySet()) {
            priorityQueue.add(key);
        }

        //4.加入集合
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }

        return res;
    }
}
