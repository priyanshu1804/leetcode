class Solution {
    public String solve(int x){
        char[] arr=String.valueOf(x).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public boolean reorderedPowerOf2(int n){
        String target=solve(n);
        for(int i=0;i<31;i++){
            if(solve(1<<i).equals(target)){
                return true;
            }
        }
        return false;
    }
}