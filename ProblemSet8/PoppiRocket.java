
import java.io.*;
import java.util.*;

public class PoppiRocket {
    // hint: binary search or heap?

    public static void main(String[] args) throws IOException {

        // input section
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] levels = new int[n + 1];
        levels[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        // calculation steps
        int k = 0;
        int maxDiff = 0;

        for (int i = n; i > 0; i--) {

            int diff = levels[i] - levels[i - 1];

            maxDiff = Math.max(maxDiff, diff);

            if (diff == maxDiff && k == maxDiff) {
                k = maxDiff + 1;
            }

            k = Math.max(k, maxDiff);
        }

        // output section
        System.out.println(k);
    }
}
