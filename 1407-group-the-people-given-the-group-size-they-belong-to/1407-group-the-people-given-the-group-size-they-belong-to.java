class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int n=groupSizes.length;
        for(int i=0;i<n;i++){
            List<Integer> ds=map.getOrDefault(groupSizes[i],new ArrayList<>());
            ds.add(i);
            map.put(groupSizes[i],ds);
            if(ds.size()==groupSizes[i]){
                ans.add(ds);
                map.remove(groupSizes[i]);
            }
        }
        return ans;
    }
}