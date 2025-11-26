
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LoadBalance {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] tasks = new int[2 * M]; // initialize 2M size, pad with 0s later

        st = new StringTokenizer(br.readLine());

        double sum = 0.0;

        for (int i = 0; i < N; i++) {

            tasks[i] = Integer.parseInt(st.nextToken());
            sum += tasks[i];

        }

        for (int i = N; i < tasks.length; i++) {

            tasks[i] = 0;
        }

        Arrays.sort(tasks);

        double avg = (double) (sum / M); //get the average

        double I = 0.0;

        int left = 0, right = tasks.length - 1;

        // We are trying to make the sum of each
        // pair close to the mean.
        while (left < right) {

            double loadi = (double) (tasks[left] + tasks[right]);
            I += (double) Math.abs(avg - loadi);
            left++;
            right--;
        }

        System.out.printf("IMBALANCE = %.5f\n", I);
    }
}
