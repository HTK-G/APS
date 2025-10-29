
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MrPanda {

    static int n, m;
    static int[] parent;          // negative means root, abs(value) = component size
    static boolean[] active;      // true = land above current sea level
    static int comps;             // number of current connected components
    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int find(int x) {
        return parent[x] < 0 ? x : (parent[x] = find(parent[x]));
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        // merge smaller into larger
        if (parent[a] > parent[b]) {
            int t = a;
            a = b;
            b = t;
        }
        parent[a] += parent[b];
        parent[b] = a;
        comps--;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // input section
        int[][] h = new int[n][m];
        List<int[]> cells = new ArrayList<>(n * m);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                h[i][j] = Integer.parseInt(st.nextToken());
                cells.add(new int[]{h[i][j], i, j});
            }
        }

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] t = new int[T];
        for (int i = 0; i < T; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        // sort cells by height descending (simulate tide going down)
        cells.sort((a, b) -> Integer.compare(b[0], a[0]));

        parent = new int[n * m];
        Arrays.fill(parent, -1);
        active = new boolean[n * m];

        int ptr = 0;        // how many cells have emerged
        comps = 0;
        int[] ans = new int[T];

        // process queries from highest to lowest sea level
        for (int i = T - 1; i >= 0; i--) {
            int level = t[i];

            // "unflood" all cells higher than current level
            while (ptr < cells.size() && cells.get(ptr)[0] > level) {
                int r = cells.get(ptr)[1], c = cells.get(ptr)[2];
                int id = r * m + c;
                active[id] = true;
                comps++;  // new island
                // merge with active neighbors
                for (int[] d : DIRS) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && active[nr * m + nc]) {
                        union(id, nr * m + nc);
                    }
                }
                ptr++;
            }
            ans[i] = comps; // record current number of islands
        }

        // print answers in original order
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(ans[i]);
        }
        System.out.println(sb);
    }

// public static void main(String[] args) throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     StringTokenizer st;
//     st = new StringTokenizer(br.readLine());
//     int n = Integer.parseInt(st.nextToken());
//     int m = Integer.parseInt(st.nextToken());
//     int[][] map = new int[n][m];
//     for (int i = 0; i < n; i++) {
//         st = new StringTokenizer(br.readLine());
//         for (int j = 0; j < m; j++) {
//             map[i][j] = Integer.parseInt(st.nextToken());
//         }
//     }
//     int T = Integer.parseInt(br.readLine());
//     int[] levels = new int[T];
//     st = new StringTokenizer(br.readLine());
//     for (int i = 0; i < T; i++) {
//         levels[i] = Integer.parseInt(st.nextToken());
//     }
//     // Calculation Steps
//     for (int level : levels) {
//         boolean[][] visited = new boolean[n][m];
//         updateMap(map, visited, level);
//         System.out.print(countLands(map, visited));
//         if (T-- != 0) {
//             System.out.print(" ");
//         }
//     }
//     // Output section
//     // ending with a switch line
//     System.out.println();
// }
// public static void updateMap(int[][] map, boolean[][] visited, int level) {
//     for (int i = 0; i < map.length; i++) {
//         for (int j = 0; j < map[0].length; j++) {
//             if (map[i][j] <= level) {
//                 map[i][j] = -1;
//                 visited[i][j] = true;
//             }
//         }
//     }
// }
// public static int countLands(int[][] map, boolean[][] visited) {
//     int height = map.length;
//     int width = map[0].length;
//     int count = 0;
//     for (int i = 0; i < height; i++) {
//         for (int j = 0; j < width; j++) {
//             //true means visited, false means not visited
//             if (!visited[i][j] && map[i][j] != -1) {
//                 //If not visited, increase count
//                 //and mark the land as visited
//                 count++;
//                 flipLand(visited, map, i, j);
//             }
//         }
//     }
//     return count;
// }
// public static void flipLand(boolean[][] visited, int[][] map, int i, int j) {
//     if (i >= visited.length || i < 0 || j < 0 || j >= visited[0].length) {
//         return;
//     }
//     if (visited[i][j] || map[i][j] == -1) {
//         return;
//     }
//     visited[i][j] = true;
//     flipLand(visited, map, i + 1, j);
//     flipLand(visited, map, i - 1, j);
//     flipLand(visited, map, i, j + 1);
//     flipLand(visited, map, i, j - 1);
// }
}
