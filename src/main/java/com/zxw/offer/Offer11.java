package main.java.com.zxw.offer;

/**
 * ClassName: Offer11
 * Description:
 * 题目描述：
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 *
 * 从第一个开始画图开始就会发现规律就是费波那西数列 f(n)=f(n-1)+f(n-2)
 *
 * @author zxw
 * @date 2020/10/21 9:24 上午
 * @since JDK 1.8
 */
public class Offer11 {

    public int RectCover(int target) {
        if (target <= 2){
            return target;
        }
        int pre = 2;
        int preNext = 1;
        int result = 0;
        for (int i = 3; i <= target;i++){
            result = pre+preNext;
            preNext = pre;
            pre = result;
        }
        return result;
    }

}
