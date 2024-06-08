class Solution {
    public int maxPower(String s) {
        int[] power=new int[s.length()];
        power[0]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                power[i]=1+power[i-1];
            }else{
                power[i]=1;
            }
        } 
        int max=Integer.MIN_VALUE;
        for(int i=0;i<power.length;i++){
            max=Math.max(max,power[i]);
        }
        return max;
    }
}