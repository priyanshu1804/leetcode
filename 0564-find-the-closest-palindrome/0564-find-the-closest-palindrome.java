class Solution {
    public long solve(long half,boolean even){
        long res=half;
        if(!even){
            half=half/10;
        }
        while(half>0){
            res=res*10+(half%10);
            half/=10;
        }
        return res;
    }
    public String nearestPalindromic(String n) {
        int len=n.length();
        int i=len%2==0?len/2-1:len/2;
        long half=Long.parseLong(n.substring(0,i+1));
        List<Long> ans=new ArrayList<>();
        ans.add(solve(half,len%2==0));
        ans.add(solve(half+1,len%2==0));
        ans.add(solve(half-1,len%2==0));
        ans.add((long)Math.pow(10,len-1)-1);
        ans.add((long)Math.pow(10,len)+1);
        long diff=Long.MAX_VALUE;
        long result=0;
        long x=Long.parseLong(n);
        for(long it:ans){
            if(it==x){
                continue;
            }
            if((Math.abs(it-x))<diff){
                diff=Math.abs(it-x);
                result=it;
            }else if(Math.abs(it-x)==diff){
                result=Math.min(result,it);
            }
        }
        return String.valueOf(result);
    }
}