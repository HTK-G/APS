
import java.io.*;
import java.util.StringTokenizer;

public class ClosingTabs {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            solve();
        }

        System.out.print(out.toString());
    }

    public static void solve() throws IOException {

        st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());

        double b = Long.parseLong(st.nextToken());

        long n = Long.parseLong(st.nextToken());

        // int moves = 1; //default we need one move;
        if (b >= a) {

            System.out.println(1);
        } else if ((double) (a / n) < b) {
            System.out.println(2);

        } else {
            System.out.println(1);
        }
    }
}
