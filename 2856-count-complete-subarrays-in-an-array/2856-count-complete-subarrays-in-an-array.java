class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int i=0;
        int j=0;
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()==set.size()){
                ans+=n-j;
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                if(map.getOrDefault(nums[i],0)==0){
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}