package main.java.com.zxw.offer;

/**
 * ClassName: Offer12
 * Description:
 * 题目描述：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 1级台阶：1
 * 2级台阶：2
 * 3级台阶：1+2
 * 4级台阶：3+2
 *
 * 思路：画出每一个台阶的跳法，就能找到规律
 * 关键点：青蛙一次只能跳1级或者2级。所以若是n级台阶，第一次跳1级，那么剩下n-1级台阶就总共有f(n-1)种跳法，第一次跳2级，那么剩下n-2级台阶就总共有f(n-2)级台阶跳法
 * f(n) = f(n-1)+f(n-2)
 * @author zxw
 * @date 2020/10/22 9:23 上午
 * @since JDK 1.8
 */
public class Offer12 {

    public int JumpFloor(int target) {
        if (target <= 2){
            return target;
        }
        int pre = 2;
        int preNext = 1;
        int result = 0;
        for (int i = 3;i <= target;i++){
            result = pre+preNext;
            preNext = pre;
            pre = result;
        }
        return result;
    }
}
