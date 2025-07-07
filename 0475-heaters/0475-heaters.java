class Solution {
    public boolean solve(int[] houses,int[] heaters,int mid){
        int ans=0;
        for(int it:heaters){
            int low=it-mid;
            int high=it+mid;
            while(ans<houses.length&&low<=houses[ans]&&houses[ans]<=high){
                ans++;
            }
        }
        return ans>=houses.length;
    }
    public int findRadius(int[] houses,int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int low=0;
        int high=Math.max(houses[houses.length-1],heaters[heaters.length-1]);
        int ans=0;
        while(low<high){
            int mid=low+(high-low)/2;
            if(solve(houses,heaters,mid)){
                ans=mid;
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}