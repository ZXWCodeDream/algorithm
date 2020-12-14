package main.java.com.zxw.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Code127
 * Description:
 *
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * @author zxw
 * @date 2020/12/14 11:29 上午
 * @since JDK 1.8
 */
public class Code127 {

    /**
     * BFS 广度优先搜索，将beginword存入队列中，依次弹出队列中的元素，并在wordList中寻找与之只差一个字符的单词，放入队列中，反复弹出，放入，以此寻找endword并返回
     * 剪枝： 之前放入到队列中的元素就不用再放入了。设定一个boolean[] flag = new boolean[wordList.size()]保存对应单词是否已经访问的标识
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        boolean findFlag = true;
        for (String word : wordList){
            if (word.equals(endWord)){
                findFlag = false;
                break;
            }
        }
        if(findFlag){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 0;
        boolean[] tag = new boolean[wordList.size()];
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            while (--size >= 0){
                String target = queue.poll();
                if (target.equals(endWord)){
                    return step;
                }
                for (int i = 0; i < wordList.size(); i++){
                    if (!tag[i] && judgeIsTargetStr(wordList.get(i),target)){
                        queue.add(wordList.get(i));
                        tag[i] = true;
                    }
                }
            }
        }
        return 0;
    }

    public static boolean judgeIsTargetStr(String word,String target){
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) != target.charAt(i)){
                count++;
                if (count > 1){
                    return false;
                }
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList1 = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
