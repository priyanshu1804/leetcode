class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set=new HashSet<>();
        for(int it:friends){
            set.add(it);
        }
        int[] ans=new int[friends.length];
        int i=0;
        for(int j=0;j<order.length;j++){
            if(set.contains(order[j])){
                ans[i]=order[j];
                i++;
            }
        }
        return ans;
    }
}