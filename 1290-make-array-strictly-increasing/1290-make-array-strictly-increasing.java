class Solution {
    public int solve1(List<Integer> arr,int target){
        int low=-1;
        int high=arr.size();
        while(low+1<high){
            int mid=(low+high)/2;
            if(arr.get(mid)<=target){
                low=mid;
            }else{
                high=mid;
            }
        }
        return high;
    }
    public int solve(int[] arr1,List<Integer> arr,int i,int j,Integer[][] dp){
        if(i==arr1.length){
            return 0;
        }
        if(dp[i][j+1]!=null){
            return dp[i][j+1];
        }
        int prev=i==0?Integer.MIN_VALUE:(j==-1?arr1[i-1]:arr.get(j));
        int idx=solve1(arr,prev);
        if(arr1[i]>prev){
            if(idx==arr.size()){
                return dp[i][j+1]=solve(arr1,arr,i+1,-1,dp);
            }
            int pick=1+solve(arr1,arr,i+1,idx,dp);
            int notpick=solve(arr1,arr,i+1,-1,dp);
            return dp[i][j+1]=Math.min(pick,notpick);
        }else{
            if(idx==arr.size()){
                return Integer.MAX_VALUE/2;
            }
            return dp[i][j+1]=1+solve(arr1,arr,i+1,idx,dp);
        }
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Set<Integer> set=new HashSet<>();
        for(int it:arr2){
            set.add(it);
        }
        List<Integer> arr=new ArrayList<>(set);
        Collections.sort(arr);
        Integer[][] dp=new Integer[arr1.length][arr.size()+1];
        int ans=solve(arr1,arr,0,-1,dp);
        return (ans>=Integer.MAX_VALUE/2)?-1:ans;
    }
}