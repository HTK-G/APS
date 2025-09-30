
// This program is for submission's only
// Content subject to change at any moment
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        if (isFamily(n)) {
            System.out.println("July Fourth Family Number");
        } else {
            System.out.println("Not in the family");
        }
    }

    private static boolean isFamily(long n) {
        Queue<Long> q = new ArrayDeque<>();
        q.add(4L);
        q.add(7L);

        while (!q.isEmpty()) {
            long cur = q.poll();

            if (cur > n) continue;  // prune
            if (n % cur == 0) return true;

            long a = cur * 10 + 4;
            long b = cur * 10 + 7;

            if (a > 0 && a <= n) q.add(a);
            if (b > 0 && b <= n) q.add(b);
        }
        return false;
    }

}
