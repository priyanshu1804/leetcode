class Solution {
    public void swap(int i,int j,List<Long> arr){
        long temp=arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
    public long smallestNumber(long num) {
        List<Long> arr=new ArrayList<>();
        long nums=Math.abs(num);
        while(nums>0){
            arr.add(nums%10);
            nums/=10;
        }
        if(num<0){
            Collections.sort(arr,Collections.reverseOrder());
        }else{
            Collections.sort(arr);
        }
        long ans=0;
        if(!arr.isEmpty()&&arr.get(0)==0){
            for(int i=1;i<arr.size();i++){
                if(arr.get(i)!=0){
                    swap(0,i,arr);
                    break;
                }
            }
        }
        int i=0;
        int n=arr.size();
        while(i<n){
            ans=ans*10+arr.get(i);
            i++;
        }
        if(num<0){
            return ans*-1;
        }
        return ans;
    }
}