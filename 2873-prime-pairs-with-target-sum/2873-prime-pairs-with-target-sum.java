class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] prime=new boolean[n+1];
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=2;i<n;i++){
            prime[i]=true;
        }
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i*i<=n;i++){
            if(prime[i]){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=false;
                }
            }
        }
        for(int i=2;i<=n-1;i++){
            int j=n-i;
            if(prime[i]&&prime[j]&&i<=j){
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
            }
        }
        return ans;
    }
}