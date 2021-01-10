package main.java.com.zxw.leetcode;

/**
 * ClassName: Code5633
 * Description:
 *
 * @author zxw
 * @date 2021/1/9 10:34 下午
 * @since JDK 1.8
 */
public class Code5633 {

    public static int totalMoney(int n) {

        int m = n / 7;
        int sum1 = 28*m+7*(1+m-1)*(m-1)/2;
        int m1 = n % 7;
        int sum2 = 0;
        if (m1 != 0){
           sum2 = (m+1+m+m1) *m1/2;
        }
        return sum1+sum2;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }
}
