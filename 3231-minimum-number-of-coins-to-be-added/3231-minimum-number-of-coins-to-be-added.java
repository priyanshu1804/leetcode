class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        int count=0;
        long missing=1;
        int i=0;
        Arrays.sort(coins);
        while(missing<=target){
            if(i<coins.length&&coins[i]<=missing){
                missing+=coins[i];
                i++;
            }
            else{
                missing+=missing;
                count++;
            }
        }
        return count;
    }
}