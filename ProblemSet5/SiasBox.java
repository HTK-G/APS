
import java.util.*;

public class SiasBox {

    public static void main(String[] args) {
        // input section
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            System.out.println("not sure");
            return;
        }
        int N = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        // Calculation steps
        boolean isStack = true, isQueue = true, isPQ = true;

        for (int i = 0; i < N; i++) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            if (op == 1) {
                if (isStack) {
                    stack.push(x);
                }
                if (isQueue) {
                    queue.offer(x);
                }
                if (isPQ) {
                    maxpq.offer(x);
                }
            } else { // op == 2
                if (isStack) {
                    if (stack.isEmpty() || stack.pop() != x) {
                        isStack = false;

                    }
                }
                if (isQueue) {
                    if (queue.isEmpty() || queue.poll() != x) {
                        isQueue = false;

                    }
                }
                if (isPQ) {
                    if (maxpq.isEmpty() || maxpq.poll() != x) {
                        isPQ = false;

                    }
                }
            }
        }
        // output section
        int c = (isStack ? 1 : 0) + (isQueue ? 1 : 0) + (isPQ ? 1 : 0);
        if (c == 0) {
            System.out.println("impossible");
        } else if (c > 1) {
            System.out.println("not sure");
        } else if (isStack) {
            System.out.println("stack");
        } else if (isQueue) {
            System.out.println("queue");
        } else {
            System.out.println("priority queue");
        }
        sc.close();
    }
}
