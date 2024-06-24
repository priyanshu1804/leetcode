class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                min=Math.min(min,(i+1)-map.get(cards[i]));
            }
            map.put(cards[i],i);
        }
        if(min==Integer.MAX_VALUE)
            min=-1;
        return min;
    }
}