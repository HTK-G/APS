
import java.util.*;

public class TimeMaster {

    // We define a class, besically wanted to achieve:
    // 1. storing its next run time
    // 2. storing its interval of increment
    static class Reminder {

        int id, interval;
        long next;

        Reminder(int id, int interval) {
            this.id = id;
            this.interval = interval;
            this.next = interval;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Reminder> pq = new PriorityQueue<>(
                (a, b) -> a.next == b.next ? Integer.compare(a.id, b.id) : Long.compare(a.next, b.next)
        );

        // Read "Register id interval" lines until a lone "#"
        while (sc.hasNext()) {
            String cur = sc.next();
            if (cur.equals("#")) {
                break; // end of registrations
            }            // cur should be "Register"
            int id = sc.nextInt();
            int interval = sc.nextInt();
            pq.add(new Reminder(id, interval));
        }

        int N = sc.nextInt();
        // StringBuilder out = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Reminder r = pq.poll();
            System.out.println(r.id);
            r.next += r.interval;
            pq.add(r);
        }
        // System.out.print(out.toString());
        sc.close();
    }
}
