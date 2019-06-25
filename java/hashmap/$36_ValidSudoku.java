package array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 我一开始是使用Set储存元素，分别遍历每行、每列、每3x3格是否有相同元素，只能合并每行和每列遍历。
 * 后来看了题解，可以在一次遍历时判定每行、每列、每3x3格是否有相同元素。
 * 为每行每列每格创建对应的HashSet
 * 如果当前遍历元素的索引为[i,j]，则加入rowSets[i]、colSets[j]、boxSets[(i/3)*3+j/3]
 *
 * 还可以使用boolean[][]来解这道题，效率比较高，和第一种方法类似。
 */
public class $36_ValidSudoku {
    //方法1
    public boolean isValidSudoku1(char[][] chars) {
        HashSet<Character>[] rowSets = new HashSet[9];
        HashSet<Character>[] colSets = new HashSet[9];
        HashSet<Character>[] boxSets = new HashSet[9];
        //初始化数组
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }
        //一次遍历
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int boxIndex = (i / 3) * 3 + j / 3;
                //判断
                if (rowSets[i].contains(chars[i][j]) || colSets[j].contains(chars[i][j]) || boxSets[boxIndex].contains(chars[i][j]))
                    return false;
                //将对应元素加入set
                if (chars[i][j] != '.') {
                    rowSets[i].add(chars[i][j]);
                    colSets[j].add(chars[i][j]);
                    boxSets[boxIndex].add(chars[i][j]);
                }
            }
        }
        return true;
    }

    //方法2
    public boolean isValidSudoku2(char[][] chars) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (chars[i][j] != '.') {
                    int boxIndex = (i / 3) * 3 + j / 3;
                    int num = chars[i][j] - '0';
                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) return false;
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }

            }
        }
        return true;
    }
}
