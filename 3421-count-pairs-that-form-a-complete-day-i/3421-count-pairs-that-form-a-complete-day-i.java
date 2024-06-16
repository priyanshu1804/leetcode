class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int it:hours){
            it%=24;
            if(map.containsKey(Math.abs(24-it)%24)){
                count+=map.get(Math.abs(24-it)%24);
            }
            map.put(it,map.getOrDefault(it,0)+1);
        }
        return count;
    }
}