public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set=new HashSet<>();
        int n=digits.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i==j||j==k||i==k){
                        continue;
                    }
                    int num=digits[i]*100+digits[j]*10+digits[k];
                    if(num>=100&&num%2==0){
                        set.add(num);
                    }
                }
            }
        }
        List<Integer> res=new ArrayList<>(set);
        Collections.sort(res);
        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
}