class Solution {
    public int numOfSubarrays(int[] arr) {
        long MOD = 1_000_000_007L;

        long even = 1; // empty prefix sum
        long odd = 0;
        long ans = 0;
        long prefix = 0;

        for (int num : arr) {
            prefix += num;

            if ((prefix & 1) == 0) {
                ans = (ans + odd) % MOD;
                even++;
            } else {
                ans = (ans + even) % MOD;
                odd++;
            }
        }

        return (int) ans;
    }
}