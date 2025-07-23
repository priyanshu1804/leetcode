class Solution {
    int max=0;
    Set<Integer> set=new HashSet<>();
    public int gcd(int a,int b){
        return (a==0)?b:gcd(b%a,a);
    }
    public boolean solve(int it){
        int val=0;
        for(int i=it;i<=max;i+=it){
            if(set.contains(i)){
                val=gcd(i,val);
            }
        }
        return val==it;
    }
    public int countDifferentSubsequenceGCDs(int[] nums) {
        for(int it:nums){
            max=Math.max(max,it);
            set.add(it);
        }
        int ans=0;
        for(int i=1;i<=max;i++){
            if(solve(i)){
                ans++;
            }
        }
        return ans;
    }
}