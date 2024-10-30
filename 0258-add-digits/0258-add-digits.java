class Solution {
    public int addDigits(int num){
        int ans=0;
        while(num>0){
        int temp=num%10;
        ans+=temp;
        num=num/10;
        }
        if(ans/10==0){ 
            return ans;
        }else{
        return addDigits(ans);
        }
    }
}