public class Q05ReverseBits {
    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println("Reversed bits value: " + reverseBits(n));
    }
}
