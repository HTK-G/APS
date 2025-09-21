
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ArcheologicalPuzzle {

    public static void main(String[] args) {
        // Input section
        Scanner input = new Scanner(System.in);
        char[] instruction = input.next().toUpperCase().toCharArray();
        int n = input.nextInt();
        String data = input.next();
        // System.out.println("instruction: " + instruction + " n: " + n + " Data: " + data);
        input.close();

        Deque<Integer> puzzle = new ArrayDeque<>();

        String trimmed = data.substring(1, data.length() - 1); // remove [ ]
        if (!trimmed.isEmpty()) {
            for (String numStr : trimmed.split(",")) {
                puzzle.add(Integer.parseInt(numStr));
            }
        }
        // Initiate the deque
        int i = 0;
        boolean fifo = true;
        while (i < instruction.length) {

            if (instruction[i] == 'R') {
                int count = 0;
                while (i < instruction.length && instruction[i] == 'R') {
                    count++;
                    i++;
                }
                if (count % 2 == 1) {
                    fifo = !fifo;
                }
            } else { // 'D'
                if (puzzle.isEmpty()) {
                    System.out.println("error");
                    return;
                }

                if (fifo) { // use poll
                    puzzle.removeFirst();
                } else {
                    puzzle.removeLast();
                }
                i++;
            }
        }

        if (puzzle.isEmpty()) {
            System.out.println("[]");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');

            if (fifo) {

                while (!puzzle.isEmpty()) {

                    sb.append(puzzle.removeFirst());
                    sb.append(',');

                }
            } else {
                while (!puzzle.isEmpty()) {

                    sb.append(puzzle.removeLast());
                    sb.append(',');
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            System.out.println(sb.toString());
        }

    }
}
