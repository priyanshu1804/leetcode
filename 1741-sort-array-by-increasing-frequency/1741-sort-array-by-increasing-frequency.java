class pair{
    int a;
    int b;
    public pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        PriorityQueue<pair> pq=new PriorityQueue<>((pair p1,pair p2)->{
            if(p1.b==p2.b){
                return p2.a-p1.a;
            }
            return p1.b-p2.b;
        });
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new pair(entry.getKey(),entry.getValue()));
        }
        int[] arr=new int[nums.length];
        int index=0;
        while(!pq.isEmpty()){
            for(int i=0;i<pq.peek().b;i++){
                arr[index++]=pq.peek().a;
            }
            pq.remove();
        }
        return arr;
    }
}