class Solution {
    private String s;
    private String p;
    private int[] removable;
    public boolean isPossible(int k){
        boolean[] taken=new boolean[s.length()];
        for(int i=0;i<=k;i++){
            taken[removable[i]]=true;
        }
        int i=0;
        int j=0;
        while(j<p.length()&&i<s.length()){
            if(!taken[i]&&s.charAt(i)==p.charAt(j)){
                j++;
            }
            i++;
        }
        return j==p.length();
    }
    public int maximumRemovals(String s, String p, int[] removable) {
        this.s=s;
        this.p=p;
        this.removable=removable;
        int low=0;
        int high=removable.length-1;
        while(low<=high){
            int possible=low+(high-low)/2;
            if(isPossible(possible)){
                low=possible+1;
            }else{
                high=possible-1;
            }
        }
        return low;
    }
}