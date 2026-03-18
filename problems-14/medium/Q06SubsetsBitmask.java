import java.util.*;

public class Q06SubsetsBitmask {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) cur.add(nums[i]);
            }
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
