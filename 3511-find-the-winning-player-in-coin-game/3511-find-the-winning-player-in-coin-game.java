class Solution {
    public String losingPlayer(int x, int y) {
       int n=Math.min(x,y/4);
       if(n%2==0){
        return "Bob";
       } else{
        return "Alice";
       }
    }
}