class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        q.add(new Pair(1,0));
        Set<Integer> set=new HashSet<>();
        set.add(1);
        while(!q.isEmpty()){
            Pair<Integer,Integer> curr=q.poll();
            int index=curr.getKey();
            int move=curr.getValue();
            if(index==n*n){
                return move;
            }
            for(int i=index+1;i<=Math.min(index+6,n*n);i++){
                int quotient=(i-1)/n;
                int row=(n-1)-(quotient);
                int remainder=(i-1)%n;
                int col=quotient%2==0?remainder:(n-1)-remainder;
                int next=board[row][col]!=-1?board[row][col]:i;
                if(!set.contains(next)){
                    set.add(next);
                    q.add(new Pair<>(next,move+1));
                }
            }
        }
        return -1;
    }
}