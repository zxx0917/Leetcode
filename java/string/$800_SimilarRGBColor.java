
/**
 * 因为要求结果是可以被简写的，由提议可知，只有相邻的两个数相同才能简写，如#AABBCC->#ABC
 * 而颜色相似度是由两个颜色之差决定的，如#AABBCC和#CCDDEE，相似度由0xAA-0xCC/0xBB-0xDD/0xCC-0xEE决定
 * 所以找出与当前数字最接近的相同数，如对于09，与其相邻的相同数为00和11，而与11更为接近，故相似颜色选择11
 */
class Solution {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        //从结尾开始，获取相邻的两数
        for (int i = color.length(); i > 1; i = i - 2) {
            //获取当前相邻数
            String str = color.substring(i - 2, i);
            //找出最接近的相同数
            //1.获取高位，如e1，高位为e，相则邻的相同数为dd/ee/ff，求出距离最近的数
            int x = Integer.valueOf(str.substring(0, 1), 16);
            int num = Integer.valueOf(str, 16);
            int[] nums = new int[3];
            nums[0] = x > 0 ? (x - 1) * 16 + (x - 1) : 0;
            nums[1] = x > 0 ? x * 16 + x : 0;
            nums[2] = x < 15 ? (x + 1) * 16 + (x + 1) : 16 * 15 + 16;

            //2.求出最接近的数
            int min = num, index = 0;
            for (int j = 0; j <= 2; j++) {
                if (Math.abs(nums[j] - num) < min) {
                    min = Math.abs(nums[j] - num);
                    index = j;
                }
            }
            //3.加入结果
            sb.append(nums[index] < 16 ? "0" + Integer.toHexString(nums[index]) : Integer.toHexString(nums[index]));
        }
        //在最后加上#，翻转返回结果
        return sb.append("#").reverse().toString();
    }
}

public class $800_SimilarRGBColor {
}
