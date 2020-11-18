package main.java.com.zxw.offer;

/**
 * ClassName: Offer10
 * Description:
 * 题目描述：求斐波那契数列的第 n 项，n <= 39。(第0项为0，第1项为1)
 *
 *解题思路：
 * 常规思路就是递归求解费波那西数列
 * 但是递归求解会重复计算值
 *
 *           / F(2)
 *       F(3)
 *     /     \ F(1)
 * F(4)        F(1)
 *     \    /
 *     F(2)
 *          \  F(0)
 *  由以上递归逻辑求解可知 F(2)和F(1)被重复计算了
 *
 *  所以：
 *  递归是将一个问题划分多个子问题求解，动态规划也是。但是动态规划会把子问题的解缓存起来，从而避免重复计算
 *  所以可以使用动态规划求解
 *
 *
 * @author zxw
 * @date 2020/10/20 10:01 上午
 * @since JDK 1.8
 */
public class Offer10 {


    /**
     * 动态规划存储空间优化 空间复杂度由 O(n) --> O(1)
     * @param n
     * @return
     */
    public int Fibonacci3(int n){

        if (n <= 1){
            return n;
        }
        int pre = 1;
        int preNext = 0;
        int result = 0;
        for ( int i = 2; i <= n;i++){
            result = pre + preNext;
            preNext = pre;
            pre = result;
        }
        return result;
    }

    /**
     * 动态规划求解
     * 但仔细发现求解每一个值都只与i-1和i-2值有关，所以只需要使用两个变量存储就可以了
     * @param n
     * @return
     */
    public int Fibonacci2(int n){

        if (n <= 1){
            return n;
        }
        int[] flag = new int[n+1];
        flag[1] = 1;
        int i;
        for ( i = 2; i <= n;i++){
            flag[i] = flag[i-1]+flag[i-2];
        }
        return flag[n];
    }

    /**
     * 递归求解
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 0){
            return 0;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }



}
