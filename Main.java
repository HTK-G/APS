
// This program is for submission's only
// Content subject to change at any moment
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Input section
        Scanner input = new Scanner(System.in);

        char[] before = input.next().toUpperCase().toCharArray();
        char[] after = input.next().toUpperCase().toCharArray();

        if (before.length != after.length) {
            System.out.println("[");
            System.out.println(']');
            return;
        }

        HashMap<Character, Integer> freq = new HashMap<>();
        for (Character c : before) {

            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (Character c : after) {
            if (freq.containsKey(c) && freq.get(c) != 0) {
                freq.put(c, freq.get(c) - 1);
            } else {
                System.out.println("[");
                System.out.println(']');
                return;
            }
        }

        // Calculation Steps
        ArrayList<ArrayList<Character>> paths = new ArrayList<>();
        dfs(before, after, 0, 0, paths, new ArrayList<>(), new ArrayDeque<>());

        // Output section
        System.out.println("[");
        for (ArrayList<Character> path : paths) {
            for (int k = 0; k < path.size(); k++) {
                System.out.print(path.get(k));
                if (k < path.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("]");

        input.close();

    }

    // i is the index for "before" and j is the index for "after"
    // At this step, it is guaranteed that len(before) == len(after)
    public static void dfs(
            char[] before, char[] after, int i, int j,
            ArrayList<ArrayList<Character>> paths, ArrayList<Character> path, Deque<Character> stack) {

        // This recursive method is going deeeep
        // base case:
        if (i == before.length && j == after.length) {
            paths.add(new ArrayList<>(path));
            return;
        }

        // We do 'i' operation first for lexicographical purpose
        if (i < before.length) {

            stack.push(before[i]);
            i++;
            path.add('i');
            dfs(before, after, i, j, paths, path, stack);
            stack.pop();
            path.remove(path.size() - 1);
            i--;

        }

        // Then we check for "o" operation
        if (!stack.isEmpty() && stack.peek() == after[j]) {

            char temp = stack.pop();
            j++;
            path.add('o');
            dfs(before, after, i, j, paths, path, stack);
            stack.push(temp);
            path.remove(path.size() - 1);
            j--;
        }
    }
}
