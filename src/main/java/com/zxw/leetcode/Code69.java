package main.java.com.zxw.leetcode;

/**
 * ClassName: Code69
 * Description:
 *
 *
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * @author zxw
 * @date 2020/12/1 10:07 上午
 * @since JDK 1.8
 */
public class Code69 {

    /**
     * 二分法
     * 二分查找也称为折半查找，每次都能将查找区间减半，这种折半特性的算法时间复杂度为 O(logN)。
     * 只要是对int类型的数值进行加减操作，必须要考虑值越界成负数问题，需要使用long类型替代计算，最终转为int值
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {

        if (x*x == x){
            return x;
        }
        long l = 0,h = x;
        long m;
        while (h-l>1){
            m = (h-l)/2+l;
            if (m * m > x){
                h = m;
            }else if (m * m < x){
                l = m;
            }else{
                return (int)m;
            }
        }
        return (int)l;

    }

    /**
     * 无耻解法
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        Double value = Math.sqrt(x);
        return value.intValue();
    }


        public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(8));
    }
}
