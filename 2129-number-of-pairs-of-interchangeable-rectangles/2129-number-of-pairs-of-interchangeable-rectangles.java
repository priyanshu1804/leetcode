class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long ans=0;
        Map<Double,Integer> map=new HashMap<>();
        for(int[] it:rectangles){
            double x=(double) it[0]/it[1];
            ans+=map.getOrDefault(x,0);
            map.put(x,map.getOrDefault(x,0)+1);
        }
        return ans;
    }
}