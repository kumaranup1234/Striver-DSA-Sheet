package Array;

public class stockBuySell {
    public static int maxProfit(int[] prices) {
        int profitSoFar = 0;
        int maxProfit = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            profitSoFar = Math.max(0, profitSoFar + prices[i] - prices[i - 1]);
            maxProfit = Math.max(maxProfit, profitSoFar);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
