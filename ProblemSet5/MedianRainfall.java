
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianRainfall {

    public static void main(String[] args) {

        // Input section & calculation steps
        Scanner input = new Scanner(System.in);
        // PriorityQueue data structure is by default a MinHeap, or natural order

        // Use minheap to store big values
        PriorityQueue<Integer> right = new PriorityQueue<>();
        // Use maxheap to store small values
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

        // We treat this array as a "sorted array", which has 2 parts
        // Left stores smaller ones, right stores bigger ones
        // In this case, we keep track of a "semi-sorted" structure,
        // Where we know for sure that left heap has all numbers smaller than numbers in the right
        // So the middle one/ones is the median
        while (input.hasNext()) {

            int cur = input.nextInt();

            // Default case, we put number on the left
            if (left.isEmpty() || cur <= left.peek()) { // order matters
                left.add(cur);
            } else {
                right.add(cur);
            }

            // Deal with the case where size(left) > (size(right) + 1)
            // we can tolerate left unbalanced by 1, not by more than 1! because it's the default
            // we can't tolerate right bigger than left by 1
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            } else if (right.size() > left.size()) {
                left.add(right.poll());
            }

            if (left.size() == right.size()) {
                long l = left.peek();
                long r = right.peek();

                System.out.println((l + r) / 2);
            } else {
                System.out.println(left.peek());
            }
        }

        input.close();
    }
}
