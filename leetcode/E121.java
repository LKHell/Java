import sun.tools.tree.PreIncExpression;

// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Example 1:
// Input: [7, 1, 5, ++++, 4]
// Output: 5

// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0

// In this case, no transaction is done, i.e. max profit = 0.

class Solution {
  public int maxProfit(int[] prices) {
  
    int min_price = Integer.MAX_VALUE;
    int max_profit = 0;
    for(int i : prices) {
      if (i < min_price) {
        min_price = i;
      }
      else if ( i - min_price > max_profit) {
        max_profit = i - min_price;
      }
    }   
    return max_profit;   
  }
}
// Kadane's Algorithm
class Solution{
  public int maxProfit(int[] prices) {
    int maxCur = 0, maxSoFar = 0;
    for(int i = 1; i < prices.length; i++) {
        maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
        maxSoFar = Math.max(maxCur, maxSoFar);
    }
    return maxSoFar;
}
}