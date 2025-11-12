
import java.io.*;
import java.util.*;

public class CFB {

    static final class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(fs.next());

        while (T-- > 0) {
            int n = fs.nextInt();
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = fs.nextInt();
            }
            String x = fs.next();

            // edge case 1, 
            if (x.charAt(0) == '1' || x.charAt(x.length() - 1) == '1') {
                out.append("-1\n");
                continue;
            }

            boolean any = false;
            for (int i = 0; i < n; i++) {
                if (x.charAt(i) == '1') {
                    any = true;
                    break;
                }
            }
            if (!any) {
                out.append("0\n");
                continue;
            }

            // processing the array
            // determin if they have bigger/smaller "cover" both ends
            boolean[] leftSm = new boolean[n + 1];
            boolean[] leftLg = new boolean[n + 1];
            boolean[] rightSm = new boolean[n + 1];
            boolean[] rightLg = new boolean[n + 1];

            int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (mn < p[i]) {
                    leftSm[i] = true;
                }
                if (mx > p[i]) {
                    leftLg[i] = true;
                }
                mn = Math.min(mn, p[i]);
                mx = Math.max(mx, p[i]);
            }

            mn = Integer.MAX_VALUE;
            mx = Integer.MIN_VALUE;
            for (int i = n; i >= 1; i--) {
                if (mn < p[i]) {
                    rightSm[i] = true;
                }
                if (mx > p[i]) {
                    rightLg[i] = true;
                }
                mn = Math.min(mn, p[i]);
                mx = Math.max(mx, p[i]);
            }

            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (x.charAt(i - 1) == '1') {
                    boolean cover
                            = (leftSm[i] && rightLg[i])
                            || (leftLg[i] && rightSm[i]);
                    if (!cover) {
                        ok = false;
                        break;
                    }
                }
            }
            if (!ok) {
                out.append("-1\n");
                continue;
            }

            // find overall min and max
            int Lpos = 1;
            for (int i = 2; i <= n; i++) {
                if (p[i] < p[Lpos]) {
                    Lpos = i;
                }
            }
            int Rpos = 1;
            for (int i = 2; i <= n; i++) {
                if (p[i] > p[Rpos]) {
                    Rpos = i;
                }
            }

            List<int[]> ops = new ArrayList<>();

            if (Lpos != Rpos) {
                ops.add(new int[]{Math.min(Lpos, Rpos), Math.max(Lpos, Rpos)});
            }

            int leftBound = Math.min(Lpos, Rpos);
            int rightBound = Math.max(Lpos, Rpos);

            // seek left
            int leftMost1 = -1;
            for (int i = 1; i < leftBound; i++) {
                if (x.charAt(i - 1) == '1') {
                    leftMost1 = i;
                    break;
                }
            }
            if (leftMost1 != -1) {
                ops.add(new int[]{leftMost1, rightBound});
            }

            // seek right
            int rightMost1 = -1;
            for (int i = n; i > rightBound; i--) {
                if (x.charAt(i - 1) == '1') {
                    rightMost1 = i;
                    break;
                }
            }
            if (rightMost1 != -1) {
                ops.add(new int[]{leftBound, rightMost1});
            }

            // more than 5 times
            if (ops.size() > 5) {
                ops = ops.subList(0, 5);
            }

            out.append(ops.size()).append('\n');
            for (int[] op : ops) {
                out.append(op[0]).append(' ').append(op[1]).append('\n');
            }
        }

        System.out.print(out);
    }
}
