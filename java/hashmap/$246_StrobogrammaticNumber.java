package array;

/**
 * 满足中心对称数的数字必须满足一下条件：如果数字长度为奇数，则中间数必须为8/0/1，以中心为对称轴，两侧的数必须对应为
 * 6->9 8->8 1->1 0->0 9->6
 * 所以可以创建字典数组保存上述对应关系，先判断是否有中间数且中间数是否满足条件，然后再判断两侧数是否满足对应关系
 */
public class $246_StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {

        //1.获取数字长度
        int len = num.length();
        //如果是奇数，中间位必须是8/1/0
        if (len % 2 != 0 && num.charAt(len / 2) != '8' && num.charAt(len / 2) != '1' && num.charAt(len / 2) != '0')
            return false;
        //判断两侧元素是否为数字对
        int[] dict = new int[128];
        dict['6'] = '9';
        dict['9'] = '6';
        dict['8'] = '8';
        dict['1'] = '1';
        dict['0'] = '0';
        for(int i = 0;i < len/2;i++){
            char left = num.charAt(i),right = num.charAt(len-1-i);
            if(dict[left] != right) return false;
        }
        return true;
    }
}
