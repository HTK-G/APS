
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LineUp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int G;
        st = new StringTokenizer(br.readLine());
        G = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> belong = new HashMap<>();
        for (int g = 0; g < G; g++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int i = 0; i < size; i++) {
                belong.put(Integer.parseInt(st.nextToken()), g);
            }
        }

        Queue<Integer> mainQ = new ArrayDeque<>();
        Map<Integer, ArrayDeque<Integer>> groupQ = new HashMap<>();
        StringBuilder out = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("Shutdown")) {
                break;
            }

            if (cmd.equals("Push")) {
                int x = Integer.parseInt(st.nextToken());
                int g = belong.get(x);

                ArrayDeque<Integer> q = groupQ.get(g);
                if (q == null) {
                    q = new ArrayDeque<>();
                    groupQ.put(g, q);
                    mainQ.add(g);
                }
                q.add(x);
            } else if (cmd.equals("Pop")) {
                int g = mainQ.peek();
                ArrayDeque<Integer> q = groupQ.get(g);
                int x = q.poll();
                out.append(x).append('\n');
                if (q.isEmpty()) {
                    groupQ.remove(g);
                    mainQ.poll();
                }
            }
        }

        System.out.print(out.toString());

    }
}
