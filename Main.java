
// This program is for submission's only
// Content subject to change at any moment
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int W = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            String hippos = br.readLine();

            Scanner input = new Scanner(hippos);
            PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());
            int sum = 0;

            for (int i = 0; i < N; i++) {
                int cur = input.nextInt();

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
            input.close();

            System.out.print(maxh.size());

        } catch (IOException e) {
            System.out.print(e);
        }

    }

}
