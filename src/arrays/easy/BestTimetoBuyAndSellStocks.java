package src.easy.arrays;

public class BestTimetoBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int max = 0;
        
        for(int i=0;i<prices.length;i++){
            if(prices[i] < minValue){
                minValue = prices[i];
            } else if(prices[i] - minValue > max){
                max = prices[i]-minValue;
            }
        }
        
        return max;
    }
	
    
    
	/**
	 * O(n) one pass solution
	 * We can plot the graph of all the points and then we realise we need to find the maximum peak the minimum trough.
	 * Also, we just have to look forward for any of the trough we find. 
	 * 
	 *  At every point (if its not less than our trough), we check if the difference between the point and our trough is larger than the max answer we already have
	 */
	
	/**
	 * O(n2) time by brute force
	 * 
	 * 	 public int maxProfit(int[] prices) {
	        int max = Integer.MIN_VALUE;
	        for(int i=0;i<prices.length;i++){
	            for(int j=i+1;j<prices.length;j++){
	                if(prices[j] > prices[i]){
	                    int val = prices[j] - prices[i];
	                    if(val > max) max = val;
	                }
	            }
	        }
	        
	        return max == Integer.MIN_VALUE ? 0 : max;
	    }
	 */
	

}
