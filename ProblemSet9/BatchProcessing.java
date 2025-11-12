
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BatchProcessing {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        long lo = 0, hi = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            lo = Math.max(lo, a[i]);
            hi += a[i];
        }
        long ans = hi;
        while (lo <= hi) {
            long mid = (lo + hi) >> 1;
            if (needParts(a, mid) <= M) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int parts = M, i = N - 1;
        long sum = 0;
        while (i >= 0) {

            if (sum + a[i] > ans || i + 1 < parts) {
                sb.append("/ ");
                parts--;
                sum = 0;
            }
            sb.append(a[i]).append(' ');
            sum += a[i];
            i--;
        }

        String[] tokens = sb.toString().trim().split("\\s+");
        // reverse
        List<String> list = Arrays.asList(tokens);
        Collections.reverse(list);

        StringBuilder out = new StringBuilder();
        for (int k = 0; k < list.size(); k++) {
            if (k > 0) {
                out.append(' ');
            }
            out.append(list.get(k));
        }
        System.out.println(out.toString());
    }

    static int needParts(int[] a, long cap) {
        int cnt = 1;
        long sum = 0;
        for (int x : a) {
            if (sum + x > cap) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
}
