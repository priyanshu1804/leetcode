class Solution {
    public boolean solve(int i,int target,ArrayList<Integer> ans){
        if(i>=ans.size()){
            if(target==0){
                return true;
            }
            return false;
        }
        if(target==0){
            return true;
        }
        boolean notpick=solve(i+1,target,ans);
        boolean pick=false;
        if(ans.get(i)<=target){
            pick=solve(i+1,target-ans.get(i),ans);
        }
        return pick||notpick;
    }
    public boolean checkPowersOfThree(int n) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<16;i++){
            ans.add((int)Math.pow(3,i));
        }
        return solve(0,n,ans);
    }
}