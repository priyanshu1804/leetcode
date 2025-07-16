class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        PriorityQueue<int[]> cuts=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int cost:horizontalCut){
            cuts.add(new int[]{cost,'H'});
        }
        for(int cost:verticalCut){
            cuts.add(new int[]{cost,'V'});
        }
        int horizontal_pieces=1;
        int vertical_pieces=1;
        long total_cost=0;
        while(!cuts.isEmpty()){
            int[] cut=cuts.poll();
            int cost=cut[0];
            char cut_type=(char) cut[1];
            if(cut_type=='H'){
                total_cost+=(long)cost*vertical_pieces;
                horizontal_pieces++;
            }else{
                total_cost+=(long)cost*horizontal_pieces;
                vertical_pieces++;
            }
        }
        return total_cost;
    }
}
