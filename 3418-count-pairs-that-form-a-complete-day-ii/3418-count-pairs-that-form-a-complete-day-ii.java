class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int it:hours){
            it=it%24;
            if(map.containsKey(Math.abs(24-it)%24)){
                ans+=map.get(Math.abs(24-it)%24);
            }
            map.put(it,map.getOrDefault(it,0)+1);
        }
        return ans;
    }
}