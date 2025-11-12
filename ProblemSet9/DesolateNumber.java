
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DesolateNumber {

    public static void main(String[] args) throws IOException {

        // Input section
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // Base cases check:
        // if no 1 or only 1, then output is 1
        if (A == 0 || A == 1) {

            System.out.println(A);
            return;
        }

        // if no 0? then every digit is 1
        if (B == 0) {

            long ans = 0L;

            ans |= (1L << A);
            ans--;

            System.out.println(ans);

            return;
        }

        // here from our observation, a string can have at most
        // 2 * B '01' or '10's
        // To illustrate this, see: 101101101, depending on how
        // many 0s we have, we can form at most B 101 pairs, so
        // therefore at most 2B 1s are paired with 0
        // The rest of 1s, we just put them in the right most
        // section to keep the number as small as possible
        // Structure: _1__0__11__0__11__0__1__
        // the first and last can has at most one 1, since 101.
        // int ones = Math.max(A, (2 * B));
        int remainOnes = A;

        int[] bits = new int[B + 1];

        // think of from right to left
        for (int i = 0; i <= B; i++) {

            int maxOnes = 2;

            // if we are at both ends
            // the first and last can has at most one 1, since 101.
            if (i == 0 || i == B) {

                maxOnes = 1;
            }

            while (maxOnes != 0 && remainOnes != 0) {

                bits[i]++;
                remainOnes--;
                maxOnes--;
            }

        }

        // The rest 1: _1__0__11__0__11__0__111111__
        if (remainOnes != 0) {

            bits[0] += remainOnes;
            remainOnes = 0;
        }

        long ans = 0L;

        for (int i = B; i >= 0; i--) {

            while (bits[i] != 0) {

                ans = ((ans << 1L) | 1L);
                bits[i]--;
            }
            if (i > 0) {
                ans = (ans << 1L);
            }

        }

        System.out.println(ans);
    }

}
