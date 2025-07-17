class Solution {
    public int solve(List<Integer> adj){
        List<Integer> max=new ArrayList<>();
        for(int it:adj){
            if(max.isEmpty()||it>max.get(max.size()-1)){
                max.add(it);
            }else{
                int pos=Collections.binarySearch(max,it);
                if(pos>=0){
                    max.set(pos,it);
                }else{
                    max.set(-(pos+1),it);
                }
            }
        }
        return max.size();
    }
    public int minOperations(int[] target, int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<target.length;i++){
            map.put(target[i],i);
        }
        List<Integer> adj=new ArrayList<>();
        for(int it:arr){
            if(map.containsKey(it)){
                adj.add(map.get(it));
            }
        }
        int max=solve(adj);
        return target.length-max;
    }
}