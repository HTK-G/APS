
import java.util.*;

public class CIMSPrinter {

    public static void main(String[] args) {

        // input section
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt(); // M is the position of task we are trying to track

        int[] list = new int[N];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int order = 0;

        for (int i = 0; i < N; i++) {
            int cur = input.nextInt();
            list[i] = cur;
            maxHeap.add(cur);
        }

        // calculation steps & output section
        int i = 0;
        while (i < list.length) {

            if (maxHeap.peek() == list[i]) {
                maxHeap.poll();
                order++;
                if (i == M) {
                    System.out.println(order);
                    return;
                }
                // System.out.println("task " + i + " is printed in order: " + order);
            }
            i = (i + 1) % list.length;

        }
    }

}
