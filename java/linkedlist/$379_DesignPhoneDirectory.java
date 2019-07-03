
class PhoneDirectory {
    ListNode head;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        //构成链表
        head = new ListNode(0);
        ListNode tail = head;
        for(int i = 1;i < maxNumbers;i++){
            tail.next = new ListNode(i);
            tail = tail.next;
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        //获取链表的第一个元素
        if(head != null){
            ListNode node = head;
            //删除第一个元素
            head = head.next;
            return node.val;
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        //遍历链表中是否有当前元素
        ListNode cur = head;
        while(cur != null){
            if(cur.val == number) return true;
            cur = cur.next;
        }
        return false;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        //将当前元素插入链表头
        if(!check(number)){
            ListNode node = new ListNode(number);
            node.next = head;
            head = node;
        }
    }
}

public class $379_DesignPhoneDirectory {
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}