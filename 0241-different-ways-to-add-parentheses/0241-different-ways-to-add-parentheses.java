class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans=new ArrayList<>();
        if(expression.length()==0){
            return ans;
        }
        if(expression.length()==1){
            ans.add(Integer.parseInt(expression));
            return ans;
        }
        if(expression.length()==2&&Character.isDigit(expression.charAt(0))){
            ans.add(Integer.parseInt(expression));
            return ans;
        }
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(Character.isDigit(ch)){
                continue;
            }
            List<Integer> left=diffWaysToCompute(expression.substring(0,i));
            List<Integer> right=diffWaysToCompute(expression.substring(i+1));
            for(int it:left){
                for(int it1:right){
                    int total=0;
                    if(ch=='+'){
                        total=it+it1;
                    }else if(ch=='-'){
                        total=it-it1;
                    }else if(ch=='*'){
                        total=it*it1;
                    }
                    ans.add(total);
                }
            }
        }
        return ans;
    }
}