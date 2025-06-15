class Solution {
    public int maxDiff(int num) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(char x='0';x<='9';x++){
            for(char y='0';y<='9';y++){
                char[] arr=Integer.toString(num).toCharArray();
                for(int i=0;i<arr.length;i++){
                    if(arr[i]==x){
                        arr[i]=y;
                    }
                }
                if(arr[0]=='0'){
                    continue;
                }
                int number=Integer.parseInt(new String(arr));
                max=Math.max(max,number);
                min=Math.min(min,number);
            }
        }

        return max-min;
    }
}