/**
 * "Bulls"：遍历两个字符串，相同位置相同字符的个数
 * "Cows"：排出完全猜对的数字，统计secret中剩余数字和出现的次数，再比对guess中出现相同数的次数
 */
public class $299_BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] dict = new int[10];
        //计数
        for (int i = 0; i < secret.length(); i++) {
            dict[secret.charAt(i) - '0']++;
        }

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bulls++;
                dict[secret.charAt(i) - '0']--;
                if (dict[secret.charAt(i) - '0'] < 0) cows--;
            } else if (dict[guess.charAt(i) - '0'] > 0) {
                cows++;
                dict[guess.charAt(i) - '0']--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
