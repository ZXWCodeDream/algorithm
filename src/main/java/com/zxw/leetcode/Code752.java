package main.java.com.zxw.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Code752
 * Description:
 *
 *
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *
 *
 * 提示：
 *
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 *
 *
 * @author zxw
 * @date 2020/12/26 9:31 下午
 * @since JDK 1.8
 */
public class Code752 {

    public static int openLock(String[] deadends, String target) {

        if (target.equals("0000")){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,0});
        int step = 0;
        boolean[][][][] tag = new boolean[10][10][10][10];
        for (String s : deadends){
            int s_1 = Integer.valueOf(s.substring(0,1));
            int s_2 = Integer.valueOf(s.substring(1,2));
            int s_3 = Integer.valueOf(s.substring(2,3));
            int s_4 = Integer.valueOf(s.substring(3,4));
            tag[s_1][s_2][s_3][s_4] = true;
            if (s_1 == 0 && s_2 == 0 && s_3 == 0 && s_4 == 0){
                return -1;
            }
        }

        int[] move1 = new int[]{1,-1,0,0,0,0,0,0};
        int[] move2 = new int[]{0,0,1,-1,0,0,0,0};
        int[] move3 = new int[]{0,0,0,0,1,-1,0,0};
        int[] move4 = new int[]{0,0,0,0,0,0,1,-1};

        while(!queue.isEmpty()){

            step++;
            int size = queue.size();

            for (int ii = 0; ii < size; ii++) {
                if (queue.size() == 0){
                    System.out.println("test");
                }
               int[] s = queue.poll();

               for (int k = 0; k < move1.length; k++){

                   int n1 = s[0]+move1[k] == -1 ? 9 : (s[0]+move1[k] == 10 ? 0 : s[0]+move1[k]);
                   int n2 = s[1]+move2[k] == -1 ? 9 : (s[1]+move2[k] == 10 ? 0 : s[1]+move2[k]);
                   int n3 = s[2]+move3[k] == -1 ? 9 : (s[2]+move3[k] == 10 ? 0 : s[2]+move3[k]);
                   int n4 = s[3]+move4[k] == -1 ? 9 : (s[3]+move4[k] == 10 ? 0 : s[3]+move4[k]);
                   StringBuilder sb = new StringBuilder();
                   sb.append(n1).append(n2).append(n3).append(n4);
                   if (sb.toString().equals(target)){
                       return step;
                   }
                   if (!tag[n1][n2][n3][n4]){
                       queue.add(new int[]{n1,n2,n3,n4});
                       tag[n1][n2][n3][n4] = true;
                   }
               }


            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String[] arr= new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";

        String[] arr2= new String[]{"8888"};
        String target2 = "0009";

        String[] arr3= new String[]{"0000"};
        String target3 = "0009";

        String[] arr4= new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target4 = "8888";
        System.out.println(openLock(arr,target));


    }
}
