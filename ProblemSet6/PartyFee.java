
import java.util.*;

public class PartyFee {

    static int[] parent;
    static long[] sum;  // store total debt per set

    public static void main(String[] args) {
        /*we could use a unionfind to gather all groups, and for each group, we want to see the sum to be 0 */
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        parent = new int[N];
        sum = new long[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            sum[i] = input.nextLong();  // debt of person i
        }

        for (int i = 0; i < M; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            union(a, b);
        }
        input.close();

        // check each root: must have total sum == 0
        for (int i = 0; i < N; i++) {
            if (i == parent[i] && sum[i] != 0) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println("POSSIBLE");
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) {
            return;
        }

        // attach smaller root to larger one (optional)
        parent[rb] = ra;
        sum[ra] += sum[rb];
    }
}
