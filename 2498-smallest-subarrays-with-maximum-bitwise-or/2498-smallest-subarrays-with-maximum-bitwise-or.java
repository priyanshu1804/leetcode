class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int max=Arrays.stream(nums).max().getAsInt();
        int bits=max==0?0:1+(int)(Math.log(max)/Math.log(2));
        int[] arr=new int[bits];
        Arrays.fill(arr,n);
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            int near=i;
            for(int j=0;j<bits;j++){
                if((nums[i]&(1<<j))!=0){
                    arr[j]=i;
                }else if(arr[j]!=n){
                    near=Math.max(near,arr[j]);
                }
            }
            ans[i]=near-i+1;
        }
        return ans;
    }
}