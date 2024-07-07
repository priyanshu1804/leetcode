class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count=0;
        while(numBottles>=numExchange){
            int ans=numBottles/numExchange;
            count+=numExchange*ans;
            numBottles-=numExchange*ans;
            numBottles+=ans;
        }
        return count+numBottles;
    }
}