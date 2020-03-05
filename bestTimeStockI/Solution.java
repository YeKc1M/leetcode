class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int n=prices.length;
        if(n>=1){
            int min=prices[0], max=prices[0];
            for(int i=1;i<n;i++){
                if(prices[i]>max){
                    max=prices[i];
                    res=Math.max(res, max-min);
                }
                if(prices[i]<min){
                    min=prices[i];
                    max=prices[i];
                }
            }
        }
        return res;
    }
}