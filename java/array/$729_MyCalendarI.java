package array;


import java.util.ArrayList;
import java.util.List;

/**
 * 将[start,end-1]作为一个对象放入list中，每次插入新时间段时首先判断待插入的时间段是否与现有时间段重合
 */
class MyCalendar {
    List<Time> times;
    public MyCalendar() {
        times = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        //插入前遍历集合，判断是否时间段重合
        for(Time time : times){
            int saveStart = time.getStart();
            int saveEnd = time.getEnd();
            //重合有以下几种情况：
            //1.插入时间的后半段落在已有时间段内，如[1,9]插入到[4,11]中
            //2.插入时间的前半段落在已有时间段内，如[7,19]插入到[4,11]中
            //3.插入时间所有都落在已有时间段，如[5,7]插入到[4,11]，这种情况和2类似
            //4.已有时间段包括在插入时间中，如[1,20]插入[4,11]中
            //综上其实只有三种情况
            if((end > saveStart && end <= saveEnd) || (start >= saveStart && start < saveEnd)
                    || (start <= saveStart && end >= saveEnd)){
                return false;
            }
        }
        //合格后可以插入
        times.add(new Time(start,end));
        return true;
    }
}

/**
 * 时间段类，用来保存起始时间和结束时间
 */
class Time{
    private int start;
    private int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

}