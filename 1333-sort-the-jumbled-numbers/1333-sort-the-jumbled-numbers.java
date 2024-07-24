class tuple{
    int a;
    int b;
    int c;
    public tuple(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<tuple> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String s=Integer.toString(nums[i]);
            StringBuilder sb=new StringBuilder();
            for(char ch:s.toCharArray()){
                sb.append(mapping[ch-'0']);
            }
            arr.add(new tuple(nums[i],Integer.parseInt(sb.toString()),i));
        }
        arr.sort((a,b)->{
            if(a.b!=b.b){
                return Integer.compare(a.b,b.b);
            }else{
                return Integer.compare(a.c,b.c);
            }
        });
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=arr.get(i).a;
        }
        return nums;
    }
}