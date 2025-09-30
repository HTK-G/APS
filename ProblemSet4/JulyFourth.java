
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


/*
 *     public static void main(String[] args) {

        // Input Section
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();


        // Calculation Steps
        ArrayList<Long> JFNs = new ArrayList<>();
        generateJFNs(n, 0, JFNs);

        // be aware of the 0 case!
        for(long JFN : JFNs){

            if (n % JFN == 0){
                System.out.println("July Fourth JFFN Number");
                return;
            }
        }

        // Output section
        System.out.println("Not in the JFFN");

    }

    private static void  generateJFNs(long n, long cur, ArrayList<Long> list){

        // Base case, the number gets too big
        if(cur > n){
            return;
        }

        // Case 1: we add nothing / terminates here
        if(cur != 0){
            list.add(cur);
        }

        // Case 2: we add 4 to the cur
        long newNum = cur * 10 + 4;
        generateJFNs(n, newNum, list);

        // Case 3: we add 7 to the cur
        newNum = cur * 10 + 7;
        generateJFNs(n, newNum, list);
    }

    // Second Method:
        public static boolean found = false;
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        checkJFN(n, 0);
        input.close();

        if(found) System.out.println("July Fourth JFFN Number");
        else System.out.println("Not in the JFFN");

    }
    
    
    public  static void checkJFN(long n, long cur){

        if(found){
            return;
        }
        if(cur > n){
            return;
        }

        if(cur != 0 && n % cur == 0){
            found = true;
            return;
        }

        checkJFN(n, cur * 10 + 4);
        checkJFN(n, cur * 10 + 7);
    }
 */
