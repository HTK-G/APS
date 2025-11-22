
import java.io.*;
import java.util.*;

public class YASP {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int n = list.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = list.get(i);
        }

        List<Integer> res = new ArrayList<>();

        for (int size = n; size > 1; size--) {
            int maxIdx = 0;
            for (int i = 1; i < size; i++) {
                if (a[i] > a[maxIdx]) {
                    maxIdx = i;
                }
            }
            if (maxIdx == size - 1) {
                continue;
            }

            if (maxIdx != 0) {
                int L1 = maxIdx + 1;
                int t1 = n - L1 + 1;
                res.add(t1);
                reversePrefix(a, L1);
            }

            int L2 = size;
            int t2 = n - L2 + 1;
            res.add(t2);
            reversePrefix(a, L2);
        }

        StringBuilder out = new StringBuilder();
        for (int x : res) {
            out.append(x).append(' ');
        }
        out.append('0');
        System.out.println(out.toString().trim());
    }

    private static void reversePrefix(int[] a, int len) {
        int i = 0, j = len - 1;
        while (i < j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
    }
}
