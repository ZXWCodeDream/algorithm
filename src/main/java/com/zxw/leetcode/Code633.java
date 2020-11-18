package main.java.com.zxw.leetcode;

/**
 * ClassName: Code533
 * Description:
 *
 * 633. 平方数之和
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zxw
 * @date 2020/11/14 6:17 下午
 * @since JDK 1.8
 */
public class Code633 {

    /**
     * 思路1:
     * 双指针，l最小，r最大。若是面积>c，则r--,若是面积<c,则l++
     * 思路2:
     * a=0;a*a<=c;a++进行遍历，计算b=Math.sqrt(c-a*a),若b是整数，则存在
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {

        long l = 0;
        long r = (long)Math.ceil(Math.sqrt((double) c));
        while (l <= r){
            if (l*l + r*r == c){
                return true;
            }else if (l*l + r*r > c){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(1000000));
    }

}
