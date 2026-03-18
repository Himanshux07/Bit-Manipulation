public class Q04MissingNumberXor {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i <= n; i++) xor ^= i;
        for (int x : nums) xor ^= x;
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println("Missing number: " + missingNumber(nums));
    }
}
