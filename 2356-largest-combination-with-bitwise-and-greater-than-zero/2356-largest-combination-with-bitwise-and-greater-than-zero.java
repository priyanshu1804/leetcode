class Solution {
    public int largestCombination(int[] candidates) {
        int[] ans=new int[24];
        for(int i=0;i<24;i++){
            for(int nums:candidates){
                if((nums&(1<<i))!=0){
                    ans[i]++;
                }
            }
        }
        int max=0;
        for(int count:ans){
            max=Math.max(max,count);
        }
        return max;
    }
}