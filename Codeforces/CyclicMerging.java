
import java.io.*;
import java.util.*;

public class CyclicMerging {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        for (int caseIdx = 0; caseIdx < t; caseIdx++) {
            int n = fs.nextInt();
            long[] vals = new long[n];
            for (int i = 0; i < n; i++) {
                vals[i] = fs.nextLong();
            }
            long ans;
            if (n <= 1) {
                ans = 0L;
            } else {
                ans = solveCase(vals);
            }
            out.append(ans);
            if (caseIdx + 1 < t) {
                out.append('\n');
            }
        }
        System.out.print(out.toString());
    }

    private static long solveCase(long[] initial) {
        final int n = initial.length;
        long[] val = Arrays.copyOf(initial, n);
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];
        int[] version = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = (i - 1 + n) % n;
            next[i] = (i + 1) % n;
            alive[i] = true;
            version[i] = 0;
        }
        PriorityQueue<HeapEntry> pq = new PriorityQueue<>(n * 2);
        for (int u = 0; u < n; u++) {
            int v = next[u];
            long cost = Math.max(val[u], val[v]);
            pq.offer(new HeapEntry(cost, u, version[u]));
        }
        int aliveCount = n;
        long totalCost = 0L;
        while (aliveCount > 1) {
            HeapEntry entry = pq.poll();
            if (entry == null) {
                break;
            }
            int u = entry.index;
            if (entry.version != version[u]) {
                continue;
            }
            int v = next[u];
            if (!alive[u] || !alive[v]) {
                continue;
            }
            long cost = Math.max(val[u], val[v]);
            totalCost += cost;
            alive[v] = false;
            aliveCount--;
            val[u] = cost;
            int newNext = next[v];
            next[u] = newNext;
            prev[newNext] = u;
            version[u]++;
            if (aliveCount > 1) {
                int unext = next[u];
                long newCost = Math.max(val[u], val[unext]);
                pq.offer(new HeapEntry(newCost, u, version[u]));
                int w = prev[u];
                if (w != u && alive[w]) {
                    version[w]++;
                    int wnext = next[w];
                    long wcost = Math.max(val[w], val[wnext]);
                    pq.offer(new HeapEntry(wcost, w, version[w]));
                }
            }
        }
        return totalCost;
    }

    private static class HeapEntry implements Comparable<HeapEntry> {

        final long cost;
        final int index;
        final int version;

        HeapEntry(long cost, int index, int version) {
            this.cost = cost;
            this.index = index;
            this.version = version;
        }

        @Override
        public int compareTo(HeapEntry o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    private static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, bufLen = 0;

        FastScanner(InputStream is) {
            this.in = is;
        }

        private int read() throws IOException {
            if (ptr >= bufLen) {
                bufLen = in.read(buffer);
                ptr = 0;
                if (bufLen <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
                if (c == -1) {
                    return 0;
                }
            } while (c <= ' ');
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            long val = nextLong();
            return (int) val;
        }
    }
}
