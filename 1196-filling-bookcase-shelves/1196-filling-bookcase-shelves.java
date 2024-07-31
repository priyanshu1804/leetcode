class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int []memo = new int[n];

        for(int i = 0 ; i < n ; i++)  memo[i] = -1;

        return solve(0,books,shelfWidth,memo)+1;
    }
    int solve(int ind, int[][] books, int shelfWidth, int[] memo) {
        if(ind == books.length) return -1;

        if(memo[ind] != -1) return memo[ind];

        int ans = Integer.MAX_VALUE, currMaxHeight = 0, currWidth = 0;

        for(int i = ind ; i < books.length ; i++) {
            currWidth += books[i][0];
            if(currWidth > shelfWidth) break;

            currMaxHeight = Math.max(books[i][1], currMaxHeight);
            ans = Math.min(ans,currMaxHeight+solve(i+1,books,shelfWidth,memo));
        }

        return memo[ind] = ans;
    }
}