class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean s1CanBreakS2 = true;
        boolean s2CanBreakS1 = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < arr2[i]) {
                s1CanBreakS2 = false;
            }
            if (arr2[i] < arr1[i]) {
                s2CanBreakS1 = false;
            }
        }
        return s1CanBreakS2 || s2CanBreakS1;
    }
}