class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        long count=0;
        long total=(1L*n*(n-1))/2;
        for(int i=0;i<n;i++){
            if(map.containsKey(i-nums[i])){
                count+=map.getOrDefault(i-nums[i],0);
            }
            map.put(i-nums[i],map.getOrDefault(i-nums[i],0)+1);
        }
        return total-count;
    }
}