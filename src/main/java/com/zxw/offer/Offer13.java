package main.java.com.zxw.offer;

/**
 * ClassName: Offer13
 * Description:
 *
 * 题目描述：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 思路：
 * 跳n级台阶，有下面几种跳法:
 *      第一步先跳1级:剩下n-1级台阶就有f(n-1)种跳法
 *      第一步先跳2级:剩下n-2级台阶就有f(n-2)种跳法
 *      ......
 *      第一步先跳n-1级台阶:剩下1级台阶就有f(1)种跳法
 *      第一步先跳n级台阶:只有1种跳法
 *
 *      规律就是
 *      f(n) = f(n-1)+f(n-2)+....+f(1)+1
 *       即JumpFloorII_1()方法使用动态规划求解
 *
 *       其实可以继续往下推:
 *       公式1:
 *       f(n) = f(n-1)+f(n-2)+....+f(1)+1
 *       同理可得出:
 *       公式2:
 *       f(n-1) = f(n-2)+f(n-3)+....+f(1)+1
 *       那么公式1-公式2得出:
 *       f(n)-f(n-1)=f(n-1)
 *       f(n) = 2*f(n-1)
 *       f(1) = 1,所以f(n)是一个等比数列
 *
 *
 * @author zxw
 * @date 2020/10/23 9:24 上午
 * @since JDK 1.8
 */
public class Offer13 {

    public static int JumpFloorII_1(int target) {
        if (target == 1){
            return 1;
        }
        int[] arr = new int[target+1];
        arr[1] = 1;
        for (int i = 2; i <= target; i++){
            for (int j = 1; j < i; j++){
                arr[i] +=arr[j];
            }
            arr[i]+=1;
        }
        return arr[target];
    }

    public static int JumpFloorII(int target) {
        return (int)Math.pow(2,target-1);
    }
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++){
            System.out.println(JumpFloorII(i));
        }
    }
}
