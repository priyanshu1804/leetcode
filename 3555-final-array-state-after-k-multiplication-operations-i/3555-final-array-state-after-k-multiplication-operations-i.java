class pair implements Comparable<pair>{
    int value;
    int index;
    public pair(int value,int index){
        this.value=value;
        this.index=index;
    }
    @Override
    public int compareTo(pair other){
        if(this.value==other.value){
            return Integer.compare(this.index,other.index);
        }else{
            return Integer.compare(this.value,other.value);
        }
    }
}
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<pair> pq=new PriorityQueue<>();
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            pq.add(new pair(nums[i],i));
        }
        while(k-->0){
            pair a=pq.remove();
            int x=a.value;
            int y=a.index;
            x=x*multiplier;
            pq.add(new pair(x,y));
        }
        while(!pq.isEmpty()){
            pair a=pq.remove();
            int x=a.value;
            int y=a.index;
            ans[y]=x;
        }
        return ans;
    }
}