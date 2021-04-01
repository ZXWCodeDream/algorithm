package main.java.com.zxw.leetcode;

import main.java.com.zxw.common.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Code263
 * Description:
 * 263. 丑数
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例 1:
 *
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 *
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 *
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * 说明：
 *
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 *
 * @author zxw
 * @date 2021/4/1 2:17 下午
 * @since JDK 1.8
 */
public class Code263 {

    public static boolean isUgly(int n) {

        /**
         * 判断该数能否一直被质因数整除为1
         */
        while (n != 1){
            int tmp = n;
            if (n % 2 == 0)n = n/2;
            if (n % 3 == 0)n = n/3;
            if (n % 5 == 0)n = n/5;
            if (tmp == n)return false;
        }
        return true;
    }

    public static void main01(String[] args) {

        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
    }

    /**
     * 题目升级，判断一个数是否都能被质因数整除
     * @param n
     * @return
     */
    public static boolean isUglyNew(int n){

        List<Integer> list = list(n);
        while (n != 1){
            int tmp = n;
            for (Integer v : list){
                if (n % v == 0)n = n/v;
            }
            if (n == tmp) return  false;
        }

        return true;
    }

    /**
     * 获取质因数列表
     * @param n
     * @return
     */
    public static List<Integer> list(int n ){

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++){
            int j = 2;
            for (; j < i; j++){
                if (i % j == 0)break;
            }
            if (j == i){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {

//        int n = 20;
//        List<Integer> list = list(n);
//        Util.print(list);

        System.out.println(isUglyNew(2));
        System.out.println(isUglyNew(3));
        System.out.println(isUglyNew(4));
        System.out.println(isUglyNew(5));
        System.out.println(isUglyNew(6));
        System.out.println(isUglyNew(7));

        System.out.println(isUglyNew(12));
        System.out.println(isUglyNew(13));
        System.out.println(isUglyNew(14));
        System.out.println(isUglyNew(15));
        System.out.println(isUglyNew(16));
        System.out.println(isUglyNew(17));


    }
}
