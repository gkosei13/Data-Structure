import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        if (n <= 3) {
            return 0;
        }

        Arrays.sort(nums);

        int option1 = nums[n - 3] - nums[0]; // change two largest
        int option2 = nums[n - 2] - nums[1]; // change one smallest, one largest
        int option3 = nums[n - 1] - nums[2]; // change two smallest

        return Math.min(option1, Math.min(option2, option3));
    }
}
