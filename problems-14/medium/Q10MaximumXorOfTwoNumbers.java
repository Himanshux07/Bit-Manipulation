public class Q10MaximumXorOfTwoNumbers {
    static class Node {
        Node zero;
        Node one;
    }

    static class BitTrie {
        Node root = new Node();

        void insert(int num) {
            Node cur = root;
            for (int bit = 31; bit >= 0; bit--) {
                int b = (num >>> bit) & 1;
                if (b == 0) {
                    if (cur.zero == null) cur.zero = new Node();
                    cur = cur.zero;
                } else {
                    if (cur.one == null) cur.one = new Node();
                    cur = cur.one;
                }
            }
        }

        int bestXor(int num) {
            Node cur = root;
            int ans = 0;
            for (int bit = 31; bit >= 0; bit--) {
                int b = (num >>> bit) & 1;
                if (b == 0) {
                    if (cur.one != null) {
                        ans |= (1 << bit);
                        cur = cur.one;
                    } else {
                        cur = cur.zero;
                    }
                } else {
                    if (cur.zero != null) {
                        ans |= (1 << bit);
                        cur = cur.zero;
                    } else {
                        cur = cur.one;
                    }
                }
            }
            return ans;
        }
    }

    public static int findMaximumXOR(int[] nums) {
        BitTrie trie = new BitTrie();
        for (int x : nums) trie.insert(x);

        int best = 0;
        for (int x : nums) {
            best = Math.max(best, trie.bestXor(x));
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR: " + findMaximumXOR(nums));
    }
}
