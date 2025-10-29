
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class APSHomework {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] list = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            // 0 is task time, 1 is the finish time
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());

        }

        // Sort by the parallel time, we start from the longest.
        Arrays.sort(list, (a, b) -> Integer.compare(b[1], a[1]));

        int solveTime = 0;
        int maxFinish = 0;

        for (int[] task : list) {

            solveTime += task[0];
            maxFinish = Math.max(maxFinish, solveTime + task[1]);
        }

        System.out.println(maxFinish);

    }
}
