class Solution:
    # @param {integer} k
    # @param {integer[]} prices
    # @return {integer}
    def maxProfit(self, k, prices):
       days = prices.__len__()
       if k > days/2:
           return self.quick_solution(prices,0,days-1)
       return self.max_profit(prices, 0, days - 1, k)
       
       
    def quick_solution(self, prices, start, end):
        idx = start + 1
        length = end - start + 1
        if length <= 1:
            return 0
        profit = 0
        while idx <= end:
            if prices[idx] > prices[idx-1]:
                profit += prices[idx] - prices[idx-1]
            idx += 1
        return profit
        
        
    def max_profit(self, prices, start, end, k):
        global mem
        if k==0:
            return 0
        if start >= end :
            return 0
        if (start,k) in mem:
            return mem[(start,k)]
            
        days = end - start + 1
        if k > days/2:
            return self.quick_solution(prices, start, end)
       
        
        # Buy at current price. Sell at one point.
        sell_point = start + 1
        profit_after_sell = 0
        max_price = 0
        while sell_point <= end:
            sold_price = prices[sell_point] - prices[start]
            if sold_price > 0:
                profit_after_sell = self.max_profit(prices, sell_point+1, end, k-1)
                idx = sell_point + 1
                mem[(idx, k-1)] = profit_after_sell
                if profit_after_sell + sold_price > max_price:
                    max_price = profit_after_sell + sold_price
            sell_point += 1
                
        # Not buy at current price.
        profit_not_buy = self.max_profit(prices, start+1, end, k)
        mem[(start+1, k)] = profit_after_sell
        
        
        max_price = max(profit_not_buy, max_price)

        return max_price