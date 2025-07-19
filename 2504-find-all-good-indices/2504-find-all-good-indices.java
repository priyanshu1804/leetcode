class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n=nums.length;
        int suff[]=new int[n];
        int pre[]=new int[n];
        List<Integer> ans=new ArrayList<Integer>();
        int start=nums[0];
        int end=nums[0];
        int len=0;
        for(int i=0;i<n;i++){
            if(nums[i]<=start){
                len++;
            }
            else{
                len=1;
            }
            start=nums[i];
            suff[i]=len;
        }
        len=0;
        for(int i=0;i<n;i++){
            if(nums[i]>=end){
                len++;
            }
            else{
                len=1;
            }
            end=nums[i];
            pre[i]=len;
        }
        for(int i=k;i<n-k;i++){
            if(suff[i-1]>=k&&pre[i+k]>=k){
                ans.add(i);
            }
        }        
        return ans;
    }
}