class Solution {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        int ans=Integer.MAX_VALUE;
        for(int it:nums){
            int x=it%space;
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int it:nums){
            int count=map.get(it%space);
            if(count>max){
                max=count;
                ans=it;
            }else if(count==max){
                ans=Math.min(ans,it); 
            }
        }
        return ans;
    }
}