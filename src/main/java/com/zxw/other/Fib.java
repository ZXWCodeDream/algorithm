package main.java.com.zxw.other;

/**
 * ClassName: Fib
 * Description:
 *  费波那西数列
 * @author zxw
 * @date 2021/1/2 10:06 下午
 * @since JDK 1.8
 */
public class Fib {


    /**
     * 普遍的递归求解
     * 存在问题：
     * 画出递归树后发现好多节点都重复计算
     * 时间复杂度为整棵树节点，即O(2^n)
     * @param n
     * @return
     */
    public static int fib1(int n){
        if (n == 1 || n == 2){return 1;}
        return fib1(n-1)+fib1(n-2);
    }

    /**
     *  备忘录，避免重复计算
     *  自顶向下的动态规划
     * @param n
     * @return
     */
    public static int fib(int n){
        int[] nodes = new int[n+1];
        return help(nodes,n);
    }
    public static int help(int[] nodes,int n){
        if (n == 1 || n == 2){return 1;}
        if (nodes[n] != 0 ){return nodes[n];}
        nodes[n] = fib(n-1)+fib(n-2);
        return nodes[n];
    }

    /**
     * 自底向上的动态规划解法
     * @param n
     * @return
     */
    public static int fib2(int n ){

        if (n == 1 || n == 2){return 1;}
        int[] dp = new int[n+1];
        //初始值
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 对dp进行状态压缩，只记录有用数据
     * @param n
     * @return
     */
    public static int fib3(int n){
        if (n == 1 || n == 2){return 1;}
        int pre = 1;
        int now = 1;
        for (int i = 3; i <= n; i++){
            int sum = now + pre;
            pre = now;
            now = sum;
        }
        return now;
    }


    public static void main(String[] args) {
        System.out.println(fib1(5));
        System.out.println(fib(5));
        System.out.println(fib2(5));
        System.out.println(fib3(5));
    }


}
