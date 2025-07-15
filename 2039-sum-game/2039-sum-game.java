class Solution {
    public boolean sumGame(String nums) {
        int n=nums.length();
        int leftsum=0;
        int rightsum=0;
        int leftq=0;;
        int rightq=0;
        for(int i=0;i<n/2;i++){
            if(nums.charAt(i)!='?'){
                leftsum+=nums.charAt(i)-'0';
            }else{
                leftq++;
            }
        } 
        for(int i=n/2;i<n;i++){
            if(nums.charAt(i)!='?'){
                rightsum+=nums.charAt(i)-'0';
            }else{
                rightq++;
            }
        }
        if(leftq==0&&rightq==0){
            return leftsum!=rightsum;
        }
        return (rightsum-leftsum)*2!=(leftq-rightq)*9;
    }
}