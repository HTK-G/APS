
import java.io.*;

public class RangeOperations {

    private static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            this.in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c = read();
            while (c <= ' ' && c >= 0) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int t;
        try {
            t = fs.nextInt();
        } catch (Exception e) {
            return;
        }
        while (t-- > 0) {
            int n;
            try {
                n = fs.nextInt();
            } catch (Exception e) {
                break;
            }
            long[] a = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextLong();
            }
            long[] prefix = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + a[i];
            }
            long minY = Long.MAX_VALUE;
            long best = 0L;
            for (int i = 1; i <= n; i++) {
                // Compute Y for position i (representing l = i)
                long y = (long) i * i - i - prefix[i - 1];
                if (y < minY) {
                    minY = y;
                }
                // Compute X for r = i
                long x = (long) i * i + i - prefix[i];
                long delta = x - minY;
                if (delta > best) {
                    best = delta;
                }
            }
            long sum = prefix[n];
            long result = sum + (best > 0 ? best : 0);
            out.append(result).append('\n');
        }
        System.out.print(out.toString());
    }
}
