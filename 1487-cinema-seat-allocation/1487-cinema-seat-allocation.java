class Solution {
    public boolean solve(int r,int st,int end,Map<Integer,List<Integer>> map){
        for(int i=st;i<=end;i++){
            if( map.get(r).contains(i)){
                return false;
            }
        }
        return true;
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<reservedSeats.length;i++){
            int r=reservedSeats[i][0];
            int c=reservedSeats[i][1];
            if(!map.containsKey(r)){
                map.put(r,new ArrayList<>());
            }
            map.get(r).add(c);
        } 
        int ans=0;
        for(int i:map.keySet()){
            boolean left=solve(i,2,5,map);
            boolean center=solve(i,4,7,map);
            boolean right=solve(i,6,9,map);
            if(left){
                ans+=1;
            }
            if(right){
                ans+=1;
            }
            if(left==false&&right==false&&center==true){
                ans+=1;
            }
        }
        ans+=(2*(n-map.keySet().size()));
        return ans;
    }
}