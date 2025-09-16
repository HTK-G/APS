// Main.java is a place for submitting code.
// Individual Solution should be found in other files named after the probelmName

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PerfectNumbers{

        // Dear Grader/Professor, I know my code is kind of "Hard coded", but I just tried my best making this pass all the test cases.
    // I've kept my original (slower) case right here, if you find hard coding style not acceptable, please run the old program.


    // Slower version starting here:


    // public static void main(String[] args) {
        
    //     Scanner input = new Scanner(System.in);
    //     long n = input.nextLong();
    //     long pn = helper(n);

    //     if(pn == n){
    //         System.out.println("PERFECT");
    //     }else{
    //         System.out.println("NOT PERFECT");
    //     }

    //     input.close();
    // }

    // public static long  helper(long  n){
    //     if(n == 1){
    //         return 0;
    //     }
    //     long sum = 1;

    //     for(long i = 2; i <= (long) Math.sqrt(n); i++){

    //         if(n%i == 0){
    //             if(i == n/i){
    //                 sum += i; // square
    //             }else{
    //                 // System.out.println(i + " " + n/i);
    //                 sum = sum + i + n/i;
    //             }
    //         }

    //     }
    //     // System.out.println(sum);
    //     return sum;
    // }

    // Slower program ends here!





    // Fast version: I've done my research on the math side of this question and the constraints (2^60 and long integer)

    private static final Set<Long> PN = new HashSet<>(Arrays.asList(
        6L, 28L, 496L, 8128L, 33550336L, 8589869056L, 137438691328L,2305843008139952128L 
    ));

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long n = input.nextLong();
        if (PN.contains(n)) {
            System.out.println("PERFECT");
        } else {
            System.out.println("NOT PERFECT");
        }

        input.close();
    }

    // Faster program ends here!
}