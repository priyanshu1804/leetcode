class Solution {
    public long countGood(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int n=nums.length;
        long ans=0;
        while(j<n){
            count+=map.getOrDefault(nums[j],0);
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(count>=k){
                ans+=n-j;
                count-=map.get(nums[i])-1;
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            j++;
        }
        return ans;
    }
}