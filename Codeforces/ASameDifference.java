
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ASameDifference {

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

        int n = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (s[i] == s[n - 1]) {

                count++;
            }
        }

        System.out.println(n - count);

    }

}
