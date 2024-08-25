class Solution {
    public boolean solve(int x,int y){
        int[] arr1=solve1(x);
        int[] arr2=solve1(y);
        int a=-1;
        int b=-1;
        int c=0;
        for(int k=0;k<7;k++){
            if(arr1[k]!=arr2[k]){
                b=a;
                a=k;
                c++;
            }
        }
        if(c==0){
            return true;
        }
        if(c==1){
            return false;
        }
        if(c>2){
            return false;
        }
        if(arr1[a]==arr2[b]&&arr1[b]==arr2[a]){
            return true;
        }
        return false;
    }
    public int[] solve1(int num){
        int[] arr=new int[7];
        int i=0;
        while(num>0){
            arr[i]=num%10;
            num/=10;
            i++;
        }
        return arr;
    }
    public int countPairs(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(solve(nums[i],nums[j])){
                    count++;
                }
            }
        }
        return count;
    }
}