
import java.io.*;
import java.util.*;

public class GroceryDelivery {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] v = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        int k = 0;
        boolean[] lastDP = new boolean[W + 1];

        for (int i = 0; i < N; i++) {
            int total = 0;
            for (int j = 0; j <= i; j++) {
                total += v[j];
            }
            if (total > 2 * W) {
                break;
            }

            boolean[] dp = new boolean[W + 1];
            dp[0] = true;
            for (int j = 0; j <= i; j++) {
                for (int cap = W; cap >= v[j]; cap--) {
                    dp[cap] |= dp[cap - v[j]];
                }
            }

            boolean ok = false;
            for (int cap = 0; cap <= W; cap++) {
                if (dp[cap] && total - cap <= W) {
                    ok = true;
                    break;
                }
            }

            if (!ok) {
                break;
            }

            k = i + 1;
            lastDP = dp;
        }

        System.out.println(k);

        // rebound items to boxes using lastDP
        boolean[] dp = lastDP;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += v[i];
        }

        int target = -1;
        for (int t = 0; t <= W; t++) {
            if (dp[t] && sum - t <= W) {
                target = t;
                break;
            }
        }

        boolean[] used = new boolean[k];
        boolean[][] can = new boolean[k + 1][W + 1];
        can[0][0] = true;

        for (int i = 0; i < k; i++) {
            for (int cap = 0; cap <= W; cap++) {
                if (can[i][cap]) {
                    can[i + 1][cap] = true;
                    if (cap + v[i] <= W) {
                        can[i + 1][cap + v[i]] = true;
                    }
                }
            }
        }

        int cap = target;
        for (int i = k - 1; i >= 0; i--) {
            if (cap >= v[i] && can[i][cap - v[i]]) {
                used[i] = true;
                cap -= v[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(used[i] ? "1st" : "2nd");
        }
    }
}
