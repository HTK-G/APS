
import java.util.Scanner;

public class JobScheduling {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        boolean[] time = new boolean[1000001];

        // One-time tasks
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

        // Repeating tasks
        for (int i = 0; i < m; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            int interval = input.nextInt();
            int duration = end - start;

            for (int j = start; j <= 1_000_000; j += interval) {
                for (int k = j; k < j + duration && k <= 1_000_000; k++) {
                    if (time[k]) {
                        System.out.println("CONFLICT");
                        return;
                    }
                    time[k] = true;
                }
            }
        }

        System.out.println("NO CONFLICT");
    }
}
