class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<wall.size();i++){
            int prev=0;
            for(int j=0;j<wall.get(i).size()-1;j++){
                prev+=wall.get(i).get(j);
                map.put(prev,map.getOrDefault(prev,0)+1);
            }
        }
        int max=0;
        for(int val:map.values()){
            max=Math.max(max,val);
        }
        return wall.size()-max;
    }
}