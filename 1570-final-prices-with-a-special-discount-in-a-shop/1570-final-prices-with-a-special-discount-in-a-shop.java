class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                if(prices[j]<=prices[i]&&j>i){
                    prices[i]=prices[i]-prices[j];
                    break;
                }else{
                    prices[i]=prices[i];
                }
            }
        }
        return prices;
    }
}