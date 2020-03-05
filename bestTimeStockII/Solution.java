class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        if(prices.length!=0){
            int min=prices[0],max=prices[0];
            for(int i=1;i<prices.length;i++){
                if(prices[i]>max){
                    max=prices[i];
                }else{
                    res+=(max-min);
                    min=max=prices[i];
                }
            }
            res+=(max-min);
        }
        return res;
    }
}