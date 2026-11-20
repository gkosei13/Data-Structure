import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 1;

        for (int x : nums) {
            int oldX = dp.getOrDefault(x, 0);
            int oldXp1 = dp.getOrDefault(x + 1, 0);

            dp.put(x + 1,
                   Math.max(oldXp1, oldX + 1));

            dp.put(x,
                   Math.max(oldX,
                            dp.getOrDefault(x - 1, 0) + 1));

            ans = Math.max(ans,
                    Math.max(dp.get(x), dp.get(x + 1)));
        }

        return ans;
    }
}
