package array;

import java.util.ArrayList;
import java.util.LinkedList;

public class $705_DesignHashSet {
}

/**
 * 使用拉链法实现，每个key对应一个List，用于储存对应的Value
 */
class MyHashSet {
    List<LinkedList<Integer>> list;
    int bucketNum = 1000;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        list = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            list.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        if (!contains(key)) {
            list.get(key % bucketNum).add(key);
        }
    }

    public void remove(int key) {
        if(contains(key)){
            list.get(key % bucketNum).removeFirstOccurrence(key);
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        LinkedList<Integer> bucket = list.get(key % bucketNum);
        for (int num : bucket) {
            if (num == key)
                return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */