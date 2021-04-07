package main.java.com.zxw.leetcode;

import main.java.com.zxw.common.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Code401
 * Description:
 * 401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *
 *
 * （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0) ）
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 *
 *
 * 示例：
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 *
 * 提示：
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 *
 *
 * @author zxw
 * @date 2021/4/6 10:22 上午
 * @since JDK 1.8
 */
public class Code401 {

    /**
     * 回溯算法，求组合
     */
    public static  List<String> result = new ArrayList<>();

    public static  List<String> readBinaryWatch(int num) {

        if (num > 8)return result;
        List<Integer> hl = Arrays.asList(0,1,2,3);
        List<Integer> ml = Arrays.asList(0,1,2,3,4,5);
        LinkedList<Integer> hll = new LinkedList<>();
        LinkedList<Integer> mll = new LinkedList<>();
        back(hl,ml,hll,mll,num);
        return result;

    }

    public static void back(List<Integer> hl,List<Integer> ml,LinkedList<Integer> hll,LinkedList<Integer> mll,int num){

        if (hll.size()+mll.size() == num || hll.size()+mll.size() == hl.size() + ml.size()){
            StringBuilder sb = new StringBuilder();
            int hour = 0,minute = 0;
            for (Integer n : hll){
                hour += (int)Math.pow(2,n);
            }
            for (Integer n : mll){
                minute += (int)Math.pow(2,n);
            }
            if (hour > 11 || minute > 59)return;
            sb.append(hour).append(":");
            if (minute < 10){
                sb.append("0");
            }
            sb.append(minute);
            String s = sb.toString();
            if (!result.contains(s)){
                result.add(s);
            }
            return;
        }
        for (Integer index : hl){
            if (!hll.contains(index) && hll.size() < 4){
                hll.add(index);
                back(hl,ml,hll,mll,num);
                hll.removeLast();
            }
        }

        for (Integer index : ml){
            if (!mll.contains(index) && mll.size() < 6){
                mll.add(index);
                back(hl,ml,hll,mll,num);
                mll.removeLast();
            }
        }

    }

    /**
     * 优秀题解
     * 总体思路
     * 在10个灯中选num个灯点亮，如果选择的灯所组成的时间已不合理（小时超过11，分钟超过59）就进行剪枝
     * 也就是从0到10先选一个灯亮，再选当前灯的后面的灯亮，再选后面的灯的后面的灯亮，一直到num个灯点满
     * 具体思路
     * 为了方便计算，分别设置了小时数组和分钟数组
     * 递归的四个参数分别代表：剩余需要点亮的灯数量，从索引index开始往后点亮灯，当前小时数，当前分钟数
     * 每次进入递归后，先判断当前小时数和分钟数是否符合要求，不符合直接return
     * for循环枚举点亮灯的情况，从index枚举到10，每次枚举，
     * 减少一个需要点亮的灯数量num - 1
     * 从当前已点亮的灯后面选取下一个要点亮的灯 i + 1
     * 在hour中增加当前点亮灯的小时数，如果i大于3，当前灯是分钟灯而不是小时灯，则加上0个小时
     * 在minute中增加当前点亮灯的分钟数，如果i没有大于3，当前灯是小时灯而不是分钟灯，则加上0分钟
     * 当剩余需要点亮的灯数量为0的时候，已枚举完一种情况，根据题目要求的格式加到res列表中
     * 返回res
     *
     * @param num
     * @return
     */
    public static  int[] hourArr = new int[]{1,2,4,8,0,0,0,0,0,0};
    public static int[] minuterArr = new int[]{0,0,0,0,1,2,4,8,16,32};
    public static List<String> res = new ArrayList<>();

    public static List<String> greaterAnswer(int num){

        backTrack(num,0,0,0);
        return res;

    }

    public static void  backTrack(int num,int index,int hour,int minuter){

        if (hour > 11 || minuter > 59)return;
        if (num == 0){
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            if (minuter < 10){
                sb.append("0");
            }
            sb.append(minuter);
            res.add(sb.toString());
        }
        for (int i = index; i < 10; i++){
            backTrack(num-1,i+1,hour+hourArr[i],minuter+minuterArr[i]);
        }
    }


    public static void main(String[] args) {

        List<String> strings = readBinaryWatch(2);
        List<String> strings1 = greaterAnswer(2);
        System.out.println(strings.size());
        System.out.println(strings1.size());
    }
}
