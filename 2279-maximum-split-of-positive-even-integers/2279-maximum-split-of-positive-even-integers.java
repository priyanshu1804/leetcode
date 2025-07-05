class Solution {
    boolean flag=false;
    List<Long> ans=new ArrayList<>();
    public void solve(long curr,long sum,long target,List<Long> ds){
        if(flag){
            return;
        }
        if(sum==target){
            ans=new ArrayList<>(ds);
            flag=true;
            return;
        }
        if(sum+curr>target){
            return ;
        }
        if(sum+curr<=target){
            ds.add(curr);
            solve(curr+2,sum+curr,target,ds);
            ds.remove(ds.size()-1);
        }
        solve(curr+2,sum,target,ds);
    }
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum%2!=0){
            return new ArrayList<>();
        }
        solve(2,0,finalSum,new ArrayList<>());
        return ans;
    }
}