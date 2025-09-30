// My previous code does not pass all the test in Java
// This algorithm uses the SAME idea, but it passed; it's c, okay.

#include <stdio.h>
#include <stdbool.h>
// macro
#define MAX_QUEUE 600000ULL


int main() {
    unsigned long long n;
    if (scanf("%llu", &n) != 1) return 0;

    // First check: if n itself is JFN
    if (isJFN(n)) {
        printf("July Fourth Family Number\n");
        return 0;
    }

    if (n % 4 == 0 || n % 7 == 0) {
        printf("July Fourth Family Number\n");
        return 0;
    }

    unsigned long long queue[MAX_QUEUE];
    int front = 0, back = 0;

    queue[back++] = 4;
    queue[back++] = 7;

    while (front < back) {
        unsigned long long cur = queue[front++];

        if (cur > n) continue;
        if (n % cur == 0) {
            printf("July Fourth Family Number\n");
            return 0;
        }

        // Use __int128 to avoid overflow in multiplication
        __int128 a = (__int128)cur * 10 + 4;
        __int128 b = (__int128)cur * 10 + 7;
        // I consulted GPT for this part above.

        if (a > 0 && a <= n && back < MAX_QUEUE) queue[back++] = (unsigned long long)a;
        if (b > 0 && b <= n && back < MAX_QUEUE) queue[back++] = (unsigned long long)b;
    }

    printf("Not in the family\n");
    return 0;
}

bool isJFN(unsigned long long n) {
    if (n == 0) return false;
    while (n > 0) {
        int d = n % 10;
        if (d != 4 && d != 7) return false;
        n /= 10;
    }
    return true;
}

/* Pasting my java code here too, for reference:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class JulyFourth {
    // This method did not pass all the test cases. Open for discussion.
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

*/