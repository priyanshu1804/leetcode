class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n=nums.length;
        if(n%k!=0){
            return false;
        }
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int it:nums){
            map.put(it,map.getOrDefault(it,0)+1);
        }
        for(int it:nums){
            if(map.get(it)>0){
                for(int i=0;i<k;i++){
                    int cur=it+i;
                    if(!map.containsKey(cur)||map.get(cur)<=0){
                        return false;
                    }
                    map.put(cur,map.get(cur)-1);
                }
            }
        }
        return true;
    }
}