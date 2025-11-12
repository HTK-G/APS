
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeSteps {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        StringBuilder out = new StringBuilder();

        int limit = 1 << N;

        for (int i = 0; i < limit; i++) {

            if (Integer.bitCount(i) == H) {
                String bin = Integer.toBinaryString(i);
                for (int k = bin.length(); k < N; k++) {
                    out.append('0');
                }
                out.append(bin).append('\n');

            }

        }

        System.out.print(out);
    }
}
