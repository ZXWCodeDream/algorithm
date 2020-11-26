package main.java.com.zxw.leetcode;

/**
 * ClassName: Code121
 * Description:
 *
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author zxw
 * @date 2020/11/26 2:55 下午
 * @since JDK 1.8
 */
public class Code121 {

    /**
     * 思路：
     * 低买高卖
     * 定义买入价格，只要后面的日子的股票大于买入价格，就计算收益，并且和之前的收益比较取最大值
     * 只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1){
            return 0;
        }
        int buyMoney = prices[0];
        int sendMoney = 0;
        for (int i = 1; i < prices.length; i++){
            if (buyMoney < prices[i]){
                sendMoney = Math.max(sendMoney,prices[i]-buyMoney);
            }else{
                buyMoney = prices[i];
            }
        }
        return sendMoney;
    }
}
