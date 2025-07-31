class Solution {
    Map<Integer,Boolean> dp=new HashMap<>();
    public boolean solve(int max,int target,int idx){
        if(target<=0){
            return false;
        }
        if(dp.containsKey(idx)){
            return dp.get(idx);
        }
        for(int i=1;i<=max;i++){
            int curr=1<<(i-1);
            if((idx&curr)!=0){
                continue;
            }
            if(!solve(max,target-i,idx|curr)){
                dp.put(idx,true);
                return true;
            }
        }
        dp.put(idx,false);
        return false;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=maxChoosableInteger){
            return true;
        }
        if(((1+maxChoosableInteger)/2*maxChoosableInteger)<desiredTotal){
            return false;
        }
        return solve(maxChoosableInteger,desiredTotal,0);
    }
}