class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int m = 0, i = 0, freq[] = new int[1001];
        for (int num : arr1){
            freq[num]++;
            m = Math.max(m, num);
        }
        for (int num : arr2)
            while (freq[num]-- > 0)
                arr1[i++] = num;
        for (int j = 0; j <= m; j++)
            while (freq[j]-- > 0)
                arr1[i++] = j;
        return arr1;
    }
}