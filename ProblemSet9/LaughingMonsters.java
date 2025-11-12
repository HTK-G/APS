
import java.io.*;
import java.util.*;

public class LaughingMonsters {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        double D = Double.parseDouble(st.nextToken());
        double Dsq = D * D;

        double[][] positions = new double[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i][0] = Double.parseDouble(st.nextToken());
            positions[i][1] = Double.parseDouble(st.nextToken());
        }

        DSU dsu = new DSU(N);

        // O(n^2)
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                double dx = positions[i][0] - positions[j][0];
                double dy = positions[i][1] - positions[j][1];

                double dsq = dx * dx + dy * dy;

                if (dsq <= Dsq) {

                    dsu.union(i, j);
                }

            }
        }
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {

            set.add(dsu.find(i));

        }

        System.out.print(set.size());

    }

    static class DSU {

        int[] parent;

        DSU(int n) {

            parent = new int[n];
            Arrays.fill(parent, -1);

        }

        int find(int x) {

            // Size optimization
            if (parent[x] < 0) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {

            a = find(a);
            b = find(b);

            if (a == b) {
                return;
            }

            if (parent[a] < parent[b]) {
                // a has larger size than b, merge b to a
                parent[a] += parent[b];

                parent[b] = a;

            } else {

                parent[b] += parent[a];
                parent[a] = b;

            }
        }
    }

}
