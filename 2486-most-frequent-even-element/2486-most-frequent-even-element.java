class Solution {
    public int mostFrequentEven(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int it:nums){
            if(it%2==0){
                set.add(it);
                map.put(it,map.getOrDefault(it,0)+1);
            }
        }
        int ans=0;
        int max=Integer.MIN_VALUE;
        for(int it:set){
            if(map.get(it)>max){
                max=map.get(it);
                ans=it;
            }
        }
        if(max==Integer.MIN_VALUE){
            return -1;
        }
        return ans;
    }
}