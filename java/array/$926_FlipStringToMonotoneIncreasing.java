package array;

/**
 * 据题意可知是单调递增的概念是前面全0后面全1，为了实现最小翻转数就是要翻转最小数量的1和0
 * 可以遍历整个字符串，当遇到第一个1时开始给0、1计数，当0的总数大于1的总数时，翻转该0前的所有1（即将其变0）
 * ，然后从下一个1开始重新计算。
 * 如果到最后0的总数不大于1，则翻转0。
 * 这里的翻转不需要真实翻转，计数即可
 */
class $926_FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        char[] chars = S.toCharArray();
        int countOne = 0,countZero = 0,res = 0;
        for(int j = 0;j< chars.length;j++){
            if(chars[j] == '1'){
                countOne++;
            }else if(chars[j] == '0' && countOne!=0){
                //之前出现1才累加0
                countZero++;
            }
            //判断总数
            if(countZero > countOne){
                //翻转1
                res += countOne;
                countOne = 0;
                countZero = 0;
            }
        }
        //遍历到最后，看是否需要翻转0
        if(countZero <= countOne){
            res += countZero;
        }
        return res;
    }
}
