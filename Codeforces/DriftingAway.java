
import java.io.*;

public class DriftingAway {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            String s = br.readLine().trim();
            int n = s.length();

            if (n <= 1) {

                out.append(n).append('\n');
                continue;
            }

            boolean infinite = false;
            for (int i = 0; i + 1 < n; i++) {
                char a = s.charAt(i);
                char b = s.charAt(i + 1);

                if ((a == '>' && b == '<')
                        || (a == '>' && b == '*')
                        || (a == '*' && b == '<')
                        || (a == '*' && b == '*')) {
                    infinite = true;
                    break;
                }
            }

            if (infinite) {
                out.append("-1\n");
                continue;
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                int pos = i + 1;
                int cand;

                if (c == '<') {
                    cand = pos;
                } else if (c == '>') {
                    cand = n - i;
                } else { // '*'
                    cand = Math.max(pos, n - i);
                }

                if (cand > ans) {
                    ans = cand;
                }
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}
