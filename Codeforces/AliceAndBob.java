
import java.io.*;
import java.util.StringTokenizer;

public class AliceAndBob {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            out.append(solve()).append('\n');
        }

        System.out.print(out.toString());
    }

    public static int solve() throws IOException {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cntLeft = 0;
        int cntRight = 0;

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v < a) {
                cntLeft++;
            } else if (v > a) {
                cntRight++;
            }
        }

        if (cntLeft > cntRight) {
            return a - 1;
        } else if (cntRight > cntLeft) {
            return a + 1;
        } else {
            return a;
        }
    }
}
