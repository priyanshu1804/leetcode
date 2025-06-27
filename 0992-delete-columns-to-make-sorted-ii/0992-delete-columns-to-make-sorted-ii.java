class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<strs[0].length();i++){
            boolean flag=true;
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    if(!set.contains(j)){
                        count++;
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                for(int j=1;j<strs.length;j++){
                    set.add(j);
                }
            }
        }
        return count;
    }
}