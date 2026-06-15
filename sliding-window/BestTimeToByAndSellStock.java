public class BestTimeToByAndSellStock {

    // You are given an integer array prices where prices[i] is the price of
    // NeetCoin on the ith day.

    // You may choose a single day to buy one NeetCoin and choose a different day in
    // the future to sell it.

    // Return the maximum profit you can achieve. You may choose to not make any
    // transactions, in which case the profit would be 0.

    // Example 1:

    // Input: prices = [10,1,5,6,7,1]

    // Output: 6
    // Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.

    // Example 2:

    // Input: prices = [10,8,7,5,2]

    // Output: 0
    // Explanation: No profitable transactions can be made, thus the max profit is
    // 0.

    // Constraints:

    // 1 <= prices.length <= 100
    // 0 <= prices[i] <= 100

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int i = 0;
        int j = 1;

        int maxProfit = 0;

        while (i < n && j < n) {
            j = i + 1;
            if (j < n && prices[i] >= prices[j]) {
                i++;
                continue;
            }
            while (j < n && prices[j] > prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                j++;
            }
            i++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToByAndSellStock solver = new BestTimeToByAndSellStock();

        int[] prices1 = { 10, 1, 5, 6, 7, 1 };
        System.out.println("Test 1 - expected 6, got: " + solver.maxProfit(prices1));

        int[] prices2 = { 10, 8, 7, 5, 2 };
        System.out.println("Test 2 - expected 0, got: " + solver.maxProfit(prices2));

        int[] prices3 = { 3, 4, 1, 2 };
        System.out.println("Test 3 - expected 1, got: " + solver.maxProfit(prices3));
    }
}
