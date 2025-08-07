class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int pre=0;
        long ans=0;
        for(int it:nums){
            pre^=it;
            int count=map.getOrDefault(pre,0);
            ans+=count;
            map.put(pre,count+1);
        }
        return ans;
    }
}