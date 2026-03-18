public class Q07BitwiseAndOfRange {
    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Keep removing differing suffix bits until prefixes match.
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }

    public static void main(String[] args) {
        System.out.println("[5,7] => " + rangeBitwiseAnd(5, 7));
        System.out.println("[0,0] => " + rangeBitwiseAnd(0, 0));
        System.out.println("[1,2147483647] => " + rangeBitwiseAnd(1, 2147483647));
    }
}
