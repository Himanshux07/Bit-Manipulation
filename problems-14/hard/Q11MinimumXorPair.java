import java.util.*;

public class Q11MinimumXorPair {
    public static int minXorPair(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] ^ nums[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {9, 5, 3};
        System.out.println("Minimum XOR pair value: " + minXorPair(nums));
    }
}
