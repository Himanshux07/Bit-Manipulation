import java.util.*;

public class Q01SingleNumber {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int x : nums) ans ^= x;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Single number: " + singleNumber(nums));
    }
}
