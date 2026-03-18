import java.util.*;

public class Q12TravellingSalesmanBitmaskDP {
    private static final int INF = (int) 1e9;
    private int n;
    private int[][] cost;
    private int[][] memo;

    public int tsp(int[][] graph) {
        n = graph.length;
        cost = graph;
        memo = new int[1 << n][n];
        for (int[] row : memo) Arrays.fill(row, -1);

        return dfs(1, 0);
    }

    private int dfs(int mask, int u) {
        if (mask == (1 << n) - 1) {
            return cost[u][0] == 0 ? INF : cost[u][0];
        }

        if (memo[mask][u] != -1) return memo[mask][u];

        int ans = INF;
        for (int v = 0; v < n; v++) {
            if ((mask & (1 << v)) != 0) continue;
            if (cost[u][v] == 0) continue;
            ans = Math.min(ans, cost[u][v] + dfs(mask | (1 << v), v));
        }

        return memo[mask][u] = ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 20, 42, 25},
            {20, 0, 30, 34},
            {42, 30, 0, 10},
            {25, 34, 10, 0}
        };

        Q12TravellingSalesmanBitmaskDP solver = new Q12TravellingSalesmanBitmaskDP();
        int ans = solver.tsp(graph);
        System.out.println("Minimum TSP cost: " + ans);
    }
}
