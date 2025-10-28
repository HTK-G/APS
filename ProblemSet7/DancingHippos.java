
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DancingHippos {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int W = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());
            int sum = 0;

            for (int i = 0; i < N; i++) {
                int cur = Integer.parseInt(st.nextToken());

                if (cur > W) {
                    continue;
                }

                if (sum + cur <= W) {
                    maxh.add(cur);
                    sum += cur;
                } else if (!maxh.isEmpty() && cur < maxh.peek()) {
                    // Replace the max with current min
                    sum -= maxh.poll();
                    sum += cur;
                    maxh.add(cur);
                }
            }

            System.out.print(maxh.size());

        } catch (IOException e) {
            System.out.print(e);
        }

    }

}
