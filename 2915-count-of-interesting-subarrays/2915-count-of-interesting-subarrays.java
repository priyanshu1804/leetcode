class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] prefixSum = new int[n + 1];
        Map<Integer, Integer> count = new HashMap<>();

        prefixSum[0] = 0;
        count.put(0, 1);
        long result = 0;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = (prefixSum[i] + (nums.get(i) % modulo == k ? 1 : 0)) % modulo;
            int complement = (prefixSum[i + 1] - k + modulo) % modulo;
            result += count.getOrDefault(complement, 0);
            count.put(prefixSum[i + 1], count.getOrDefault(prefixSum[i + 1], 0) + 1);
        }

        return result;
    }
}