package main.java.com.zxw.leetcode;

/**
 * ClassName: Code342
 * Description:
 * 342. 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *
 * @author zxw
 * @date 2021/4/2 9:45 上午
 * @since JDK 1.8
 */
public class Code342 {

    /**
     * 位运算
     * 4的幂其实就是2的幂
     * 1 = 4^0 = 2^0   二进制0000...1
     * 4 = 4^1 = 2^2   二进制0000...100
     * 16 = 4^2 = 2^4  二进制0000...10000
     * 64 = 4^3 = 2^6  二进制0000...1000000
     * 通过规律发现4的幂的二进制位数存在一个1，其余都为0，且1存在的下标为偶数下标
     *
     * @param n
     * @return
     */
    public static  boolean isPowerOfFour(int n) {

        boolean flag = false;
        //变量int类型二进制位最大位数32
        for (int i = 0; i < 32; i++){
            //判断二进制位末尾位的值
            int  tmp = n & 1;
            //若为1，且在偶数下标位
            if (tmp == 1 && i % 2 == 0 ){
                if (!flag){
                    //第一次出现1，则表示flag=true
                    flag = true;
                }else{
                    //出现多次1了，则返回false
                    return false;
                }
            }else if (tmp == 1){ // 在非偶数下标找到位数为1的，直接返回false
                return false;
            }
            //n向右进一位
            n = n >> 1;
        }
        return flag;

    }

    public static void main(String[] args) {


        System.out.println(Integer.toBinaryString(-2147483647));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(-2147483647));
    }
}
