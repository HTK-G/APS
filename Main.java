
// This program is for submission's only
// Content subject to change at any moment
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        boolean[] time = new boolean[1000001];

        for (int i = 0; i < n; i++) {
            int start = input.nextInt();
            int end = input.nextInt();

            for (int j = start; j < end; j++) {
                if (time[j]) {
                    System.out.println("CONFLICT");
                    return;
                }
                time[j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            long interval = input.nextInt();
            long duration = end - start;
            for (long j = start; j < time.length; j += interval) {

                for (long k = j; k < j + duration && k < time.length; k++) {
                    if (time[(int) k]) {
                        System.out.println("CONFLICT");
                        return;
                    }
                    time[(int) k] = true;
                }
            }
        }

        System.out.println("NO CONFLICT");
    }
}
