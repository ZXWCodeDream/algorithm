package main.java.com.zxw.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Code279
 * Description:
 *
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * @author zxw
 * @date 2020/12/12 7:26 下午
 * @since JDK 1.8
 */
public class Code279 {

    /**
     * BFS 广度优先搜索，关键点在于剪枝boolean[] marked = new boolean[n+1];记录每次放入队列的数，要是放过了，就不再放了，不然队列中就会存在诸多的数据，导致超时
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        List<Integer> list = getNums(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n+1];
        for (Integer num : list){
            queue.add(n-num);
            marked[n-num] = true;
        }

        int count = 0;
        while (!queue.isEmpty()){

            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int value = queue.poll();
                if (value == 0){
                    return count;
                }
                for (Integer num : list){
                    if (num <= value){
                        if (marked[value-num]){
                            continue;
                        }
                        queue.add(value-num);
                        marked[value-num] = true;
                    }
                }

            }
        }
        return count;

    }

    public static List<Integer> getNums(int n){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= n; i++){
            result.add(i*i);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(numSquares(12));
//        System.out.println(numSquares(13));
        System.out.println(numSquares(7168));
    }
}
