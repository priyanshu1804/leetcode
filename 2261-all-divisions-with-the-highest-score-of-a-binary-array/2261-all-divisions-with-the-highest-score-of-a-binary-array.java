class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] suff=new int[n];
        if(n==1&&nums[0]==0){
            return Arrays.asList(1);
        }
        if(n==1&&nums[0]==1){
            return Arrays.asList(0);
        }
        pre[0]=nums[0]==0?1:0;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+(nums[i]==0?1:0);
        }
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=suff[i+1]+nums[i];
        }
        int max=0;
        for(int i=1;i<n;i++){
            max=Math.max(max,pre[i-1]+suff[i]);
        }
        max=Math.max(max,pre[n-1]);
        max=Math.max(max,suff[0]);   
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(pre[i-1]+suff[i]==max){
                ans.add(i);
            }
        }
        if(suff[0]==max){
            ans.add(0);
        }
        if(pre[n-1]==max){
            ans.add(n);
        }
        return ans;
    }
}