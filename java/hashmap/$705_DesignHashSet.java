package array;

public class $705_DesignHashSet {
}

/**
 * 因为题目已经给出数字范围是[1,1000000]，并且规定只需要实现HashSet的功能，
 * 所以可以建立一个boolean数组，已经添加的元素对应的boolean值变为true
 */
class MyHashSet {
    boolean[] flags;
    /** Initialize your data structure here. */
    public MyHashSet() {
        flags = new boolean[1000001];
    }

    public void add(int key) {
        if(!flags[key])
            flags[key] = true;
    }

    public void remove(int key) {
        if(flags[key]){
            flags[key] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return flags[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */