public class Q08MaximumProductOfWordLengths {
    public static int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];

        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char ch : words[i].toCharArray()) {
                mask |= (1 << (ch - 'a'));
            }
            masks[i] = mask;
            lens[i] = words[i].length();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    ans = Math.max(ans, lens[i] * lens[j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println("Maximum product: " + maxProduct(words));
    }
}
