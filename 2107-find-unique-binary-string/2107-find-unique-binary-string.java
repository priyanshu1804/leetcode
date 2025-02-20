class Solution {
    public String solve(String s,int n,HashSet<String> set){
        if(s.length()==n){
            if(!set.contains(s)){
                return s;
            }
            return "";
        }
        String curr=solve(s+"0",n,set);
        if(curr.length()>0){
            return curr;
        }
        return solve(s+"1",n,set);
    }
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        HashSet<String> set=new HashSet<>();
        for(String it:nums){
            set.add(it);
        }
        return solve("",n,set);
    }
}