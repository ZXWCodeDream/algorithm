package main.java.com.zxw.leetcode;

/**
 * ClassName: Code371
 * Description:
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * @author zxw
 * @date 2021/4/2 11:20 上午
 * @since JDK 1.8
 */
public class Code371 {

    public int getSum(int a, int b) {

        if (a == 0)return b;
        if (b == 0)return a;

        while (b != 0){
            //所有的进位数
            int carry = a&b;
            //无进位求和
            a = a ^ b;
            //将b赋值为左移一位的进位数
            b = carry << 1;
        }

        return a;
    }
}
