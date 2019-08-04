/**
 * 遍历字符串，记录其中A的数量和连续L的数量，如果A的数量大于1或连续L的数量大于2，返回false
 */
class Solution {
    public boolean checkRecord(String s) {
        if (s.length() == 0) return true;
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                if (countA == 1) return false;
                else countA++;
            }
            //判断连续L的数量
            if (i < s.length() - 2 && c == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') return false;
        }
        return true;
    }
}

public class $551_StudentAttendanceRecordI {
}
