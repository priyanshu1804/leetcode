class Solution {
    public int solve(int n){
        int count=0;
        while(n>0){
            n/=10;
            count++;
        }
        return count;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        if(arr1.length==0||arr2.length==0){
            return 0;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i:arr1){
            while(i>0){
                set.add(i);
                i/=10;
            }
        }
        int len=0;
        for(int i:arr2){
            while(i>0){
                if(set.contains(i)){
                    len=Math.max(len,solve(i));
                }
                i/=10;
            }
        }
        return len;
    }
}