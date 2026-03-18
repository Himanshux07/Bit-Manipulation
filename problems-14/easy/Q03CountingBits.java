import java.util.*;

public class Q03CountingBits {
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(10)));
    }
}
