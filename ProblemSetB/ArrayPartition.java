
import java.io.*;
import java.util.*;

public class ArrayPartition {

    static int N, M;
    static long[] a;

    static boolean ok(long mid) {
        long sum = 0;
        int cnt = 1;
        for (long x : a) {
            if (x > mid) {
                return false;
            }
            if (sum + x > mid) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt <= M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new long[N];
        st = new StringTokenizer(br.readLine());
        long lo = 0, hi = 0;

        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
            hi += a[i];
        }

        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (ok(mid)) {
                hi = mid; 
            }else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}
