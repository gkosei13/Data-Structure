class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];

        Deque<Integer> dq = new ArrayDeque<>(); // chain of prefix-max starts in window [l, r]
        long maxSum = 0;  // sum of prefix maxima over window
        int r = n - 1;
        long ans = 0;

        for (int l = n - 1; l >= 0; l--) {
            // pop dominated segments from the front
            while (!dq.isEmpty() && nums[dq.peekFirst()] <= nums[l]) {
                int p = dq.pollFirst();
                int nextStart = dq.isEmpty() ? r + 1 : dq.peekFirst();
                maxSum -= (long) nums[p] * (nextStart - p);
            }
            int nextStart = dq.isEmpty() ? r + 1 : dq.peekFirst();
            maxSum += (long) nums[l] * (nextStart - l);
            dq.offerFirst(l);

            // shrink from the right until cost <= k
            while (maxSum - (pre[r + 1] - pre[l]) > k) {
                maxSum -= nums[dq.peekLast()];
                if (dq.peekLast() == r) dq.pollLast();
                r--;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}