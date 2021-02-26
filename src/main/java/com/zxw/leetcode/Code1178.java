package main.java.com.zxw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Code1178
 * Description:
 * 1178. 猜字谜
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] 都是小写英文字母。
 * 每个 puzzles[i] 所包含的字符都不重复。
 * @author zxw
 * @date 2021/2/26 10:46 上午
 * @since JDK 1.8
 */
public class Code1178 {


    /**
     * 解法：状态压缩 + 求子集
     * words和puzzles数组中的字符串都是由小写字母组成，即26个小写字母
     * 状态压缩，是通过数值的二进制来表示对应的字符。26个字符表示数值二进制的26位，若字符存在，则对应的二进制值为1，否则为0
     * 举例： abc 对应的二进制数 111  （a对应二进制位从右往左第1位值为1，b对应二进制位从右往左第2位值为1...）
     *       ac 对应的二进制数 101
     * 具体实现：
     *      w = 0;
     *      w |= 1 << ch-'a';
     *      ch-'a'即为字符ch所在二进制的位数；1 << ch-'a'，将1向左移动ch-'a'位，通过对w的或运算，即可将该位值赋为1
     * 我们可通过Hash值存储字符及其对应的个数。
     * 子集
     * 我们可以通过状态压缩得到puzzles对应字符串的数值，然后求出该数值的所有子集，在hash中寻找是否存在满足条件的，若存在则加上对应的次数
     * 为深入理解子集含义，举例如下
     * 字符ac对应二进制位101，则子集为101、100、001、000。转化对应字符为ac、c、a、空值。
     *
     * 求二进制子集公式
     * subset = s;
     * do{
     *     //对子集进行相对应的操作：比如比较、存储啥的
     *     subset = (subset - 1) & s;
     *     //更新子集。与原字符串代表的s进行&运算，则一定能保证s中值为0的位置，subset一定为0，s中值为1的位置，subset会为1或0。符合子集含义
     * }while (subset != s)
     * //子集subset最后会减为-1。-1的二进制是1的补码（整数二进制取反+1）即1111 1111。所以subset = -1 & s = s。退出循环
     *
     * @param words
     * @param puzzles
     * @return
     */
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> wordMap = new HashMap<>();
        for (String word : words){
            int w = 0;
            for (int i = 0; i < word.length(); i++){
                w |= 1 << (word.charAt(i)-'a');
            }
            if (wordMap.containsKey(w)){
               wordMap.put(w,wordMap.get(w)+1);
            }else{
                wordMap.put(w,1);
            }
        }

        for (String puzzle : puzzles){
            int p = 0;
            for (int i = 1; i < puzzle.length(); i++){
                p |= 1 << (puzzle.charAt(i)-'a');
            }
            int num = 0;
            int subSet = p;
            do{
                //必须保证首字母存在
                int s = subSet | (1 << (puzzle.charAt(0)-'a'));
                if (wordMap.containsKey(s)){
                    num += wordMap.get(s);
                }
                subSet  = (subSet-1) & p;

            }while (subSet != p);
            result.add(num);
        }
        return result;
    }







    /**
     * 普通解法必定超时。
     * 因为 words.length <= 10^5，puzzles.length <= 10^4。对每一个puzzles中的单词去寻找符合条件的word,时间复杂度将达到10^9
     * @param words
     * @param puzzles
     * @return
     */
    public static List<Integer> findNumOfValidWords00001(String[] words, String[] puzzles) {

        int n = words.length;
        int m = puzzles.length;
        List<Integer> result = new ArrayList<>(m);

        int[][] w = new int[n][26];
        int[][] ws = new int[m][26];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < words[i].length();j++){
                w[i][words[i].charAt(j)-'a'] = 1;
            }
        }
        for (int i = 0; i < m; i++){
            int first = puzzles[i].charAt(0)-'a';
            for (int k = 0; k < puzzles[i].length(); k++){
                ws[i][puzzles[i].charAt(k)-'a'] = 1;
            }
            int num = 0;
            for (int j = 0; j < n; j++){
                if (w[j][first] == 0){
                    continue;
                }
                int kk = 0;
                for (; kk < 26; kk++){
                    if (w[j][kk] == 1 && ws[i][kk] == 0){
                        break;
                    }
                }
                if (kk == 26){
                    num++;
                }

            }
            result.add(num);
        }
        return result;
    }

    public static void main(String[] args) {

         String[] words = new String[]{"aaaa","asas","able","ability","actt","actor","access"};
         String[]  puzzles = new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        List<Integer> numOfValidWords = findNumOfValidWords(words, puzzles);
        for (Integer i : numOfValidWords){
            System.out.println(i);
        }
// * 输出：[1,1,3,2,4,0]
    }
}
