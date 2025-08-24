class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<coordinates.size();i++){
            String s=coordinates.get(i).get(0)+" "+coordinates.get(i).get(1);
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int ans=0;
        for(int i=0;i<coordinates.size();i++){
            int x=coordinates.get(i).get(0);
            int y=coordinates.get(i).get(1);
            if(map.get(x+" "+y)>1){
                map.put(x+" "+y,map.get(x+" "+y)-1);
            }else{
                map.remove(x+" "+y);
            }
            for(int j=0;j<=k;j++){
                int x1=x^j;
                int y1=(k-j)^y;
                if(map.containsKey(x1+" "+y1)){
                    ans+=map.get(x1+" "+y1);
                }
            }
        }
        return ans;
    }
}