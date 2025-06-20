class Solution {
    public int maxDistance(String s, int k) {
        int north=0;
        int south=0;
        int east=0;
        int west=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='N'){
                north++;
            }else if(s.charAt(i)=='S'){
                south++;
            }else if(s.charAt(i)=='W'){
                west++;
            }else{
                east++;
            }
            int ans=Math.abs(north-south)+Math.abs(east-west);
            int ans1=Math.min(2*k,i+1-ans);
            int total=ans+ans1;
            max=Math.max(max,total);
        }
        return max;
    }
}