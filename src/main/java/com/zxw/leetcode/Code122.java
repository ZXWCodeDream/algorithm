package main.java.com.zxw.leetcode;
/**
 * ClassName: Code122
 * Description:
 *
 *
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * @author zxw
 * @date 2020/11/26 1:43 下午
 * @since JDK 1.8
 */


/**
 * 解题思路：
 * 1、动态规划
 * 2、贪心算法
 */
public class Code122 {

    /**
     * 思路：
     * 此次炒股可以进行多次买卖，但每次自己手中只允许存在一只股票
     * 1、当手中没买入股票或者今日的股票低于买入的股票时，存在以下两种情况
     *  1.1、之前已经进行了几次买入卖出的操作，即不存在上次卖出的价格时，那么判断此次的价格是否高于上次卖出的价格，若高于，则在今日卖出股票。更新收益，更新上次卖出的价格，更新此时手里没有股票
     *  1.2、之前未进行买入卖出操作，那么买入今日的股票
     * 2、当手中已经买入一只股票时，并且今日的股票高于买入的股票时，存在以下两种情况
     *  2.1、如果之前已经进行股票买入卖出操作，即存在上次卖出的价格时，此时情况为A点买入，B点卖出，C点买入，此时在D点，应该考虑是D点卖出A点买入的股票收益高 还是是B点卖出A点的收益+D点卖出C点的收益高
     *      因为income=B-A的收益是固定的，于是比较后面差值即 income += Max(D-B,D-C)
     *  2.2、如果之前并未进行股票买入卖出操作，即不存在上次卖出的价格，那么此时的收益即为 = 今日的股票价格-买入的股票价格
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int buyPrice  = prices[0],lastSendPrice = -1,income = 0;
        for (int i = 1; i < prices.length; i++){
            if (buyPrice != -1 && prices[i] > buyPrice){
                if (lastSendPrice != -1){
                    income += Math.max(prices[i] - buyPrice,prices[i]-lastSendPrice);
                }else{
                    income = Math.max(income,prices[i]-buyPrice);
                }
                lastSendPrice = prices[i];
                buyPrice = -1;
            }else{
                if (lastSendPrice != -1 && prices[i] - lastSendPrice > 0) {
                    income = income + prices[i] - lastSendPrice;
                    lastSendPrice = prices[i];
                    buyPrice = -1;
                }else{
                    buyPrice = prices[i];
                }
            }
        }

        return  income;
    }

    /**
     * 思路：
     * 理解1：既然不限制购买次数，那么把所有的上坡收益都计算到手即为最大收益
     * 理解2：对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a) ，
     *       因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
     * 理解3：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices){
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] - prices[i-1] > 0){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{1,2,3,4,5};
        int[] arr3 = new int[]{2,1,2,0,1};
        int[] arr4 = new int[]{2,1,4,5,2,9,7};
        System.out.println(maxProfit(arr));

    }
}
