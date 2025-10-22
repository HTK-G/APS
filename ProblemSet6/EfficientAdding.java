
import java.util.PriorityQueue;
import java.util.Scanner;

public class EfficientAdding {

    public static void main(String[] args) {

        // observation: always adding the smaller ones first
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        PriorityQueue<Long> heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            heap.add(input.nextLong());
        }
        input.close();

        long sum = 0;

        while (heap.size() > 1) {
            long a = heap.poll();
            long b = heap.poll();
            sum += (long) (a + b);
            heap.add((long) a + b);
        }

        System.out.println(sum);
    }

}
