
import java.io.*;
import java.util.*;

public class GiantSquad {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int[] h = new int[N];

        int idx = 0;

        // read remaining integers, possibly across multiple lines
        while (idx < N) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            h[idx++] = Integer.parseInt(st.nextToken());
        }

        // captain is the median
        System.out.println(h[N / 2]);
    }
}
