class pair{
    String name;
    int height;
    public pair(String name,int height){
        this.name=name;
        this.height=height;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<pair> pq=new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair p1,pair p2) {
                return p2.height-p1.height;
            }
        });
        for(int i=0;i<names.length;i++){
            pq.add(new pair(names[i],heights[i]));
        }
        String[] ans=new String[names.length];
        for(int i=0;i<names.length;i++){
            ans[i]=pq.remove().name;
        }
        return ans;
    }
}