class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int it:hand){
            pq.add(it);
        }
        while(!pq.isEmpty()){
            int curr=pq.peek();
            for(int i=curr;i<curr+groupSize;i++){
                if(!pq.remove(i)){
                    return false;
                }
            }
        }
        return true;
    }
}