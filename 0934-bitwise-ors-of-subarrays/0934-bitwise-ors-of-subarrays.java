class Solution {
    public int solve(Set<Integer> ans,Set<Integer> prev,Set<Integer> curr,int[] arr,int idx){
        if(idx<0){
            return ans.size();
        }
        curr.add(arr[idx]);
        for(int it:prev){
            curr.add(arr[idx]|it);
        }
        ans.addAll(curr);
        return solve(ans,curr,new HashSet<>(),arr,idx-1);
    }
    public int subarrayBitwiseORs(int[] arr) {
        return solve(new HashSet<>(),new HashSet<>(),new HashSet<>(),arr,arr.length-1);
    }
}