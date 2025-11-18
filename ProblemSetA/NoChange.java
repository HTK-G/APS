
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NoChange {

    public static void main(String[] args) throws IOException {

        // Input section:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int[] coins = new int[N];

        int total = 0;

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            total += coins[i];
        }

        // ith position in dp array stores the minimum coin needed
        int[] dp = new int[total + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {

            for (int s = total; s >= coin; s--) {

                if (dp[s - coin] != Integer.MAX_VALUE) {

                    dp[s] = Math.min(dp[s], dp[s - coin] + 1);
                }
            }
        }

        // Output
        for (int i = price; i <= total; i++) {

            if (dp[i] != Integer.MAX_VALUE) {

                System.out.println(i + " " + dp[i]);
                return;
            }
        }

        System.out.println(-1);
    }
}
