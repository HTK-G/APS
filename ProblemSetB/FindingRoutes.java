
import java.io.*;
import java.util.*;

public class FindingRoutes {

    static List<Integer>[] g = new ArrayList[21];
    static boolean[] vis = new boolean[21];
    static int target;
    static List<List<Integer>> ans = new ArrayList<>();

    public static void dfs(int u, List<Integer> path) {
        if (u == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int v : g[u]) {
            if (!vis[v]) {
                vis[v] = true;
                path.add(v);
                dfs(v, path);
                path.remove(path.size() - 1);
                vis[v] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 21; i++) {
            g[i] = new ArrayList<>();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        target = n;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) {
                break;
            }
            g[a].add(b);
            g[b].add(a);
        }

        for (int i = 1; i < 21; i++) {
            Collections.sort(g[i]);
        }

        vis[1] = true;
        List<Integer> path = new ArrayList<>();
        path.add(1);
        dfs(1, path);

        for (List<Integer> p : ans) {
            for (int i = 0; i < p.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(p.get(i));
            }
            System.out.println();
        }
        System.out.print("There are " + ans.size() + " routes from the initial position to corner " + target + ".");
    }
}
