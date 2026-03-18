import java.util.*;

public class Q14MaximumStudentsExamBitmaskDP {
    public static int maxStudents(char[][] seats) {
        int rows = seats.length;
        int cols = seats[0].length;

        List<List<Integer>> validMasks = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            validMasks.add(new ArrayList<>());
            int blocked = 0;
            for (int c = 0; c < cols; c++) {
                if (seats[r][c] == '#') blocked |= (1 << c);
            }

            for (int mask = 0; mask < (1 << cols); mask++) {
                if ((mask & blocked) != 0) continue;
                if ((mask & (mask << 1)) != 0) continue;
                validMasks.get(r).add(mask);
            }
        }

        Map<Integer, Integer> prev = new HashMap<>();
        prev.put(0, 0);

        for (int r = 0; r < rows; r++) {
            Map<Integer, Integer> cur = new HashMap<>();
            for (int mask : validMasks.get(r)) {
                int bits = Integer.bitCount(mask);
                for (Map.Entry<Integer, Integer> e : prev.entrySet()) {
                    int pm = e.getKey();
                    int val = e.getValue();

                    if ((mask & (pm << 1)) != 0) continue;
                    if ((mask & (pm >> 1)) != 0) continue;

                    cur.put(mask, Math.max(cur.getOrDefault(mask, 0), val + bits));
                }
            }
            prev = cur;
        }

        int ans = 0;
        for (int v : prev.values()) ans = Math.max(ans, v);
        return ans;
    }

    public static void main(String[] args) {
        char[][] seats = {
            {'.', '#', '.', '.', '#', '.'},
            {'.', '.', '#', '.', '.', '.'},
            {'#', '.', '.', '.', '#', '.'}
        };

        System.out.println("Maximum students: " + maxStudents(seats));
    }
}
