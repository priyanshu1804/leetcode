class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans=0;
        int n=baskets.length;
        for(int it:fruits) {
            int count=1;
            for(int i=0;i<n;i++){
                if(it<=baskets[i]){
                    baskets[i]=0;
                    count=0;
                    break;
                }
            }
            ans+=count;
        }
        return ans;
    }
}