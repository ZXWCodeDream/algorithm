package main.java.com.zxw.leetcode;

import java.math.BigDecimal;

/**
 * ClassName: Code172
 * Description:
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 5*4*3*2
 * 说明: 你算法的时间复杂度应为 O(log n)
 *
 *
 * @author zxw
 * @date 2021/3/22 7:18 下午
 * @since JDK 1.8
 */
public class Code172 {


    public static int trailingZeroes(int n) {

        int count = 0;
        while (n > 0){
            count += n/5;
            n = n/5;
        }
        return count;
    }

    /**
     * 5! = 5*2=10，一个5，一个2，组成末尾一个0
     * 10! = 5*2*(5*2)=100，一个5，一个2，一个10，拆分为5*2，组成末尾两个0
     * 15! = 5*2*(5*2)*(5*2)=1000,一个5，一个2，一个10，拆分5*2，一个15，5，组成末尾三个0
     * 20！ = 10000，四个0
     * 25！= 五个0，因为25拆为5*5，所以5的个数比正常多一个
     *
     * @param args
     */
    public static void main(String[] args) {

        int n =  25;
        System.out.println(trailingZeroes(n));
        BigDecimal result = new BigDecimal(n);
        for (long i = n-1; i >= 1 ; i--){
            result = result.multiply(new BigDecimal(i));
        }
        System.out.println(result.toString());
    }
}
