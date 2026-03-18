import java.util.*;

public class Q13ShortestPathVisitingAllNodes {
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int finalMask = (1 << n) - 1;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] seen = new boolean[1 << n][n];

        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            q.offer(new int[]{i, mask, 0});
            seen[mask][i] = true;
        }

        while (!q.isEmpty()) {
            int[] state = q.poll();
            int node = state[0], mask = state[1], dist = state[2];

            if (mask == finalMask) return dist;

            for (int nei : graph[node]) {
                int nextMask = mask | (1 << nei);
                if (!seen[nextMask][nei]) {
                    seen[nextMask][nei] = true;
                    q.offer(new int[]{nei, nextMask, dist + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {1, 2, 3},
            {0},
            {0},
            {0}
        };
        System.out.println("Shortest path visiting all nodes: " + shortestPathLength(graph));
    }
}
