
import java.util.*;

public class MoveUnionFind {

    static int[] parent;
    static long[] sum;
    static int[] size;
    static int[] belong;
    static int nextId;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();

        int capacity = N + M + 12;

        parent = new int[capacity];
        sum = new long[capacity];
        size = new int[capacity];
        belong = new int[N + 1];  // element indices are 1..N

        // initialize each element as its own set (node id == element id)
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
            sum[i] = i;
            belong[i] = i;
        }
        nextId = N + 1;

        for (int k = 0; k < M; k++) {

            int command = input.nextInt();

            switch (command) {
                case 1 -> {
                    int a = input.nextInt();
                    int b = input.nextInt();
                    union(find(belong[a]), find(belong[b]));
                }
                case 2 -> {
                    int a = input.nextInt();
                    int b = input.nextInt();
                    move(a, b);
                }
                case 3 -> {
                    int a = input.nextInt();
                    returnE(a);
                }
                default -> {
                }
            }
        }
        input.close();
    }

    /**
     * recursively find an element's root
     */
    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]); // compress at the same time
    }

    /**
     * union sets containing a and b, if they are the same, ignore
     */
    public static void union(int a, int b) {

        if (a == b) {
            return;
        }

        // union by size (attach smaller to larger)
        if (size[a] < size[b]) {
            int t = a;
            a = b;
            b = t;
        }
        parent[b] = a;
        size[a] += size[b];
        sum[a] += sum[b];
    }

    /**
     * Move the element a to the set containing b. If a and b are already in the
     * same set, ignore this command (special treat to 'root')
     *
     * @param a to be moved
     * @param b target set
     */
    public static void move(int a, int b) {
        int ra = find(belong[a]);
        int rb = find(belong[b]);
        if (ra == rb) {
            return;
        }

        // remove a from its old set aggregates
        size[ra]--;
        sum[ra] -= a;

        // create a new node for element a (virtual node)
        int newNode = nextId++;
        parent[newNode] = newNode;
        size[newNode] = 1;
        sum[newNode] = a;

        // now a belongs to this new node
        belong[a] = newNode;

        // merge that new node into b's set
        union(newNode, rb);
    }

    /**
     * Return the number of elments and the sum of elements in the set
     * containing a
     *
     * @param a target set
     */
    public static void returnE(int a) {
        int root = find(belong[a]);
        System.out.println(size[root] + " " + sum[root]);
    }

}
