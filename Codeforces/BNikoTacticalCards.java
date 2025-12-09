
import java.io.*;
import java.util.*;

public class BNikoTacticalCards {

    public static long solve(int n, long[] a, long[] b) {

        long low = 0, high = 0;

        for (int i = 0; i < n; i++) {

            long redLow = low - a[i];
            long redHigh = high - a[i];

            long blueLow = b[i] - high;
            long blueHigh = b[i] - low;

            long newLow = Math.min(redLow, blueLow);
            long newHigh = Math.max(redHigh, blueHigh);

            low = newLow;
            high = newHigh;
        }

        return high;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            long[] a = new long[n];
            long[] b = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            out.append(solve(n, a, b)).append("\n");
        }

        System.out.print(out);
    }
}
