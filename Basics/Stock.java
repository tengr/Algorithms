
public class Stock {
	public static void main(String[] args){
		Stock ins = new Stock();
		int prices[] = {1,2,3,0,2};
		System.out.println(ins.BuySellWithCoolDown(prices));
	}
	public int BuySellWithCoolDown(int [] prices){
		if(prices == null || prices.length == 0 || prices.length == 1) return 0;
		int rest[] = new int[prices.length]; //max profit for day i when day i is cooldown
		int buy[] = new int[prices.length]; //max profit for day i when day i is a buy
		int sell[] = new int[prices.length]; //max profit for day i when day i is a sell
		
		buy[0] = -prices[0]; buy[1] = -prices[1];
		sell[1] = prices[1] - prices[0];
		for(int i = 2; i < prices.length; i++){
			rest[i] = Math.max(Math.max(sell[i - 1], rest[i-1]), buy[i-1]);
			buy[i] = rest[i-1] - prices[i];
			sell[i] = prices[i] + Math.max(buy[i-1], rest[i-1]);
		}
		return Math.max(Math.max(sell[prices.length - 1], rest[prices.length - 1]), buy[prices.length - 1]);
	}
}
