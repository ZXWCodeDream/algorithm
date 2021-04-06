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


    public static void main(String[] args) {

        List<String> strings = readBinaryWatch(2);
        Util.print(strings);
        System.out.println(strings.size());
    }
}
